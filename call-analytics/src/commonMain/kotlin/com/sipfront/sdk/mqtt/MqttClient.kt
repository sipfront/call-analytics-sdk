package com.sipfront.sdk.mqtt

import com.sipfront.sdk.BuildKonfig
import com.sipfront.sdk.constants.Constants
import com.sipfront.sdk.json.JsonParser
import com.sipfront.sdk.json.config.SessionConfig
import com.sipfront.sdk.json.message.RtcpMessage
import com.sipfront.sdk.json.message.SdpMessage
import com.sipfront.sdk.json.message.SipMessage
import com.sipfront.sdk.json.message.StateMessage
import com.sipfront.sdk.json.message.base.BaseMessage
import com.sipfront.sdk.log.Log
import com.sipfront.sdk.utils.DispatcherProvider
import com.sipfront.sdk.utils.KotlinHelper
import com.sipfront.sdk.utils.Platform
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
import io.ktor.utils.io.errors.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

internal class MqttClient private constructor(
    private val sessionConfig: SessionConfig, trustAllCerts: Boolean
) {
    private val httpClient = HttpClient(getHttpClientEngine(trustAllCerts)) {
        install(Auth) {
            basic {
                credentials {
                    BasicAuthCredentials(
                        username = sessionConfig.credentials.username, password = sessionConfig.credentials.password
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
            // Example UserAgent: CallAnalyticsSdk.debug (iOS 14.1 - iPhone13)
            agent =
                "${BuildKonfig.PROJECT_NAME}.${Platform.getBuildType()} (${Platform.getOsVersion()} ${Platform.getOsVersion()} - ${Platform.getDeviceModel()})"
        }
        install(Logging) {
            level = LogLevel.ALL
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

    @Throws(IllegalArgumentException::class, IllegalStateException::class, IOException::class)
    internal fun sendMessage(message: BaseMessage) {
        val url: Url = when (message) {
            is SipMessage,
            is SdpMessage,
            is StateMessage -> sipUrl

            is RtcpMessage -> rtcpUrl
            else -> throw IllegalArgumentException("Not supported MQTT message type ${message::class.simpleName}")
        }
        Log.debug()?.v { "MQTT request to URL: $url\nBody:${JsonParser.toString(message)}" }
        CoroutineScope(DispatcherProvider.IO).launch {
            val response: HttpResponse = httpClient.request {
                method = HttpMethod.Post
                url(url)
                contentType(ContentType.Application.Json)
                setBody(message)
            }

            when (response.status) {
                HttpStatusCode.OK -> Log.debug()?.d("MQTT response: ${response.bodyAsText()}")
                else -> Log.release().e("MQTT response: ${response.bodyAsText()}")
            }
        }
    }

    internal class Builder {
        private var sessionConfig: SessionConfig? = null
        private var trustAllCerts: Boolean = false

        fun sessionData(sessionConfig: SessionConfig) = apply { this.sessionConfig = sessionConfig }

        fun trustAllCerts(trustAllCerts: Boolean) = apply { this.trustAllCerts = trustAllCerts }

        fun build(): MqttClient {
            KotlinHelper.multiLet(sessionConfig, trustAllCerts) { (sessionConfig, trustAllCerts) ->
                return@build MqttClient(
                    sessionConfig as SessionConfig, trustAllCerts as Boolean
                )
            }
            throw IllegalStateException("Invalid configuration for MqttClient")
        }
    }
}