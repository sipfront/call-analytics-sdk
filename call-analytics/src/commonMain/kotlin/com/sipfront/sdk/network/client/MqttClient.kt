package com.sipfront.sdk.network.client

import com.sipfront.sdk.constants.Constants
import com.sipfront.sdk.json.JsonParser
import com.sipfront.sdk.json.config.SdkConfig
import com.sipfront.sdk.json.config.SessionConfig
import com.sipfront.sdk.json.message.RtcpMessage
import com.sipfront.sdk.json.message.SdpMessage
import com.sipfront.sdk.json.message.SipMessage
import com.sipfront.sdk.json.message.StateMessage
import com.sipfront.sdk.json.message.base.BaseMessage
import com.sipfront.sdk.json.response.ResponseMqttMessage
import com.sipfront.sdk.log.Log
import com.sipfront.sdk.network.config.getHttpClientEngine
import com.sipfront.sdk.utils.*
import com.sipfront.sdk.utils.DispatcherProvider
import com.sipfront.sdk.utils.KotlinHelper
import com.sipfront.sdk.utils.Platform
import com.sipfront.sdk.utils.getUserAgent
import io.ktor.client.*
import io.ktor.client.plugins.*
import io.ktor.client.plugins.auth.*
import io.ktor.client.plugins.auth.providers.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.logging.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

internal class MqttClient private constructor(
    private val sessionConfig: SessionConfig, sdkConfig: SdkConfig
) {
    private val httpClient = HttpClient(getHttpClientEngine(sdkConfig.trustAllCerts)) {
        install(Auth) {
            basic {
                credentials {
                    BasicAuthCredentials(
                        username = sessionConfig.credentials.username.unmasked(),
                        password = sessionConfig.credentials.password.unmasked()
                    )
                }
                sendWithoutRequest { request ->
                    request.url.host == sessionConfig.server
                }
            }
        }
        install(ContentNegotiation) {
            json(JsonParser.json)
        }
        install(HttpRequestRetry) {
            retryOnExceptionOrServerErrors(maxRetries = Constants.MQTT_MAX_RETRIES)
            exponentialDelay()
        }
        install(HttpTimeout) {
            connectTimeoutMillis = Constants.MQTT_TIMEOUT_MS_CONNECTION
            socketTimeoutMillis = Constants.MQTT_TIMEOUT_MS_SOCKET
            requestTimeoutMillis = Constants.MQTT_TIMEOUT_MS_REQUEST
        }
        install(UserAgent) {
            agent = getUserAgent()
        }
        install(Logging) {
            level = if (sdkConfig.debugHttpLogs) LogLevel.ALL else LogLevel.INFO
        }
        expectSuccess = true
    }

    private val sipUrl: Url = URLBuilder().apply {
        protocol = URLProtocol.HTTPS
        port = 443
        host = sessionConfig.server
        encodedPath = sessionConfig.mqttSipPath
    }.build()

    private val rtcpUrl: Url = URLBuilder().apply {
        protocol = URLProtocol.HTTPS
        port = 443
        host = sessionConfig.server
        encodedPath = sessionConfig.mqttRtcpPath
    }.build()

    @Throws(IllegalArgumentException::class)
    internal fun sendMessage(message: BaseMessage) {
        val url: Url = when (message) {
            is SipMessage,
            is SdpMessage,
            is StateMessage -> sipUrl

            is RtcpMessage -> rtcpUrl
            else -> throw IllegalArgumentException("Not supported MQTT message type ${message::class.simpleName}")
        }
        val separator = if (Platform.getOsFamily() != OsFamily.JAVASCRIPT) "\n" else " "
        Log.debug()?.v { "MQTT request to URL: ${url}${separator}Body:${separator}${JsonParser.toString(message)}" }
        CoroutineScope(DispatcherProvider.IO).launch {
            try {
                val response: HttpResponse = httpClient.request {
                    method = HttpMethod.Post
                    url(url)
                    contentType(ContentType.Application.Json)
                    setBody(message)
                }

                val responseString = "${response.status.value}/${response.status.description}"
                when (response.status) {
                    HttpStatusCode.OK -> {
                        val parsedResponse = JsonParser.toObject<ResponseMqttMessage>(response.bodyAsText())
                        Log.debug()
                            ?.d("MQTT response $responseString - message: ${parsedResponse.message}, traceId: ${parsedResponse.traceId}}")
                    }

                    else -> Log.release().e("MQTT response $responseString - body: ${response.bodyAsText()}")
                }
            } catch (e: Exception) {
                Log.release().e("MQTT Request Error", e)
            }
        }
    }

    internal class Builder {
        private var sessionConfig: SessionConfig? = null
        private var sdkConfig: SdkConfig? = null

        fun sessionConfig(sessionConfig: SessionConfig) = apply { this.sessionConfig = sessionConfig }

        fun sdkConfig(sdkConfig: SdkConfig) = apply { this.sdkConfig = sdkConfig }

        fun build(): MqttClient {
            KotlinHelper.multiLet(
                sessionConfig,
                sdkConfig
            ) { (sessionConfig, sdkConfig) ->
                return@build MqttClient(
                    sessionConfig = sessionConfig as SessionConfig,
                    sdkConfig = sdkConfig as SdkConfig
                )
            }
            throw IllegalStateException("Invalid configuration for ${MqttClient::class.simpleName}")
        }
    }
}