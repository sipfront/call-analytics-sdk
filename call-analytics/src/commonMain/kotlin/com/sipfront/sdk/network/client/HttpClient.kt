package com.sipfront.sdk.network.client

import com.sipfront.sdk.constants.Constants
import com.sipfront.sdk.json.JsonParser
import com.sipfront.sdk.json.config.SessionConfig
import com.sipfront.sdk.json.response.ResponseGetUploadArtifactUrl
import com.sipfront.sdk.log.Log
import com.sipfront.sdk.network.config.getHttpClientEngine
import com.sipfront.sdk.utils.DispatcherProvider
import com.sipfront.sdk.utils.KotlinHelper
import com.sipfront.sdk.utils.getUserAgent
import io.ktor.client.*
import io.ktor.client.plugins.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.logging.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import io.ktor.http.content.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

internal class HttpClient private constructor(
    private val sessionConfig: SessionConfig, trustAllCerts: Boolean
) {
    private val httpClient = HttpClient(getHttpClientEngine(trustAllCerts)) {
        install(ContentNegotiation) {
            json(JsonParser.json)
        }
        install(HttpRequestRetry) {
            retryOnExceptionOrServerErrors(maxRetries = Constants.HTTP_MAX_RETRIES)
            exponentialDelay()
        }
        install(HttpTimeout) {
            connectTimeoutMillis = Constants.HTTP_TIMEOUT_MS_CONNECTION
            socketTimeoutMillis = Constants.HTTP_TIMEOUT_MS_SOCKET
            requestTimeoutMillis = Constants.HTTP_TIMEOUT_MS_REQUEST
        }
        install(UserAgent) {
            agent = getUserAgent()
        }
        install(Logging) {
            level = LogLevel.ALL
        }
        expectSuccess = true
    }
    val sipfrontApiUrl: URLBuilder = URLBuilder().apply {
        protocol = URLProtocol.HTTPS
        port = 443
        host = sessionConfig.sipfrontApi.substringAfter("://") // discard scheme in url
    }

    @Throws(IllegalStateException::class)
    internal fun uploadArtifact(data: ByteArray, mimeType: String, fileName: String) {
        try {
            CoroutineScope(DispatcherProvider.IO).launch {
                // Request an Amazon S3 upload URL for Sipfront API
                val urlUpload = getUploadArtifactUrl(fileName = fileName)
                urlUpload?.let { url ->
                    // Now do the upload of the file to Amazon S3
                    val resultUpload = uploadArtifact(url = url, data = data, mimeType = mimeType)
                    if (resultUpload) {
                        // The Last step is to confirm with Sipfront API that the file was uploaded.
                        // Note: without this no database entry will be created on Sipfront, and thus the upload
                        // will not be shown in the Sipfront app
                        val resultConfirm = confirmArtifact(fileName)
                        if (resultConfirm) {
                            Log.debug()?.i("Confirm artifact success")
                        } else {
                            Log.release().e("Confirm artifact failed")
                        }
                    } else {
                        Log.release().e("Upload artifact failed")
                    }
                } ?: run {
                    Log.release().e("No upload artifact url received")
                }
            }
        } catch (e: Exception) {
            Log.release().e("Sipfront API Request Error, uploadArtifact()", e)
        }
    }

    private suspend fun getUploadArtifactUrl(fileName: String): Url? = withContext(DispatcherProvider.IO) {
        try {
            val url: Url = sipfrontApiUrl.clone().apply {
                encodedPath = with(sessionConfig) {
                    "internal/sessions/$sessionId/s3url?name=${fileName}&role=${role.value}&instance_id=$instanceId"
                }
            }.build()
            Log.debug()?.v { "Trying to get upload url, HTTP GET to URL: $url" }
            val response: HttpResponse = httpClient.request {
                method = HttpMethod.Get
                url(url)
                bearerAuth(sessionConfig.sipfrontApiToken.unmasked())
            }

            val responseString = "${response.status.value}/${response.status.description}"
            when (response.status) {
                HttpStatusCode.OK -> {
                    val parsedResponse = JsonParser.toObject<ResponseGetUploadArtifactUrl>(response.bodyAsText())
                    Log.debug()
                        ?.d("Successfully received upload url, response: $responseString, status: ${parsedResponse.status}")
                    // Successful request, return upload artifact url
                    URLBuilder(parsedResponse.url).build()
                }

                else -> {
                    Log.release()
                        .e("Failed to get upload url, response: $responseString, body: ${response.bodyAsText()}")
                    // Return null in case of non-OK status
                    null
                }
            }
        } catch (e: Exception) {
            Log.release().e("Sipfront API Request Error, getUploadArtifactUrl()", e)
            // Return null in case of exception
            null
        }
    }

    private suspend fun uploadArtifact(url: Url, data: ByteArray, mimeType: String): Boolean =
        withContext(DispatcherProvider.IO) {
            try {
                Log.debug()?.d { "Uploading artifact with HTTP PUT to URL: $url" }
                val response: HttpResponse = httpClient.request {
                    method = HttpMethod.Put
                    url(url)
                    setBody(ByteArrayContent(data, ContentType.parse(mimeType)))
                }

                val responseString = "${response.status.value}/${response.status.description}"
                when (response.status) {
                    HttpStatusCode.OK -> {
                        Log.debug()
                            ?.d("Upload artifact response $responseString")
                        // Return true in case of OK status
                        true
                    }

                    else -> {
                        Log.release().e("Upload artifact response $responseString")
                        // Return false in case of non-OK status
                        false
                    }
                }
            } catch (e: Exception) {
                Log.release().e("Sipfront API Request Error, uploadArtifact()", e)
                // Return false in case of exception
                false
            }
        }

    private suspend fun confirmArtifact(fileName: String): Boolean = withContext(DispatcherProvider.IO) {
        try {
            val url: Url = sipfrontApiUrl.clone().apply {
                encodedPath = with(sessionConfig) {
                    "internal/sessions/$sessionId/artifacts/confirm?name=${fileName}&role=${role.value}&instance_id=$instanceId"
                }
            }.build()
            val response: HttpResponse = httpClient.request {
                method = HttpMethod.Post
                url(url)
                bearerAuth(sessionConfig.sipfrontApiToken.unmasked())
            }
            val responseString = "${response.status.value}/${response.status.description}"
            when (response.status) {
                HttpStatusCode.Created -> {
                    Log.debug()
                        ?.d("Successfully confirmed for file $fileName, response: $responseString")
                    // Return true in case of OK status
                    true
                }

                else -> {
                    Log.release().e("Failed to confirm for file $fileName, response: $responseString")
                    // Return false in case of non-OK status
                    false
                }
            }
        } catch (e: Exception) {
            Log.release().e("Sipfront API Request Error, confirmArtifact()", e)
            // Return false in case of exception
            false
        }
    }

    internal class Builder {
        private var sessionConfig: SessionConfig? = null
        private var trustAllCerts: Boolean = false

        fun sessionData(sessionConfig: SessionConfig) = apply { this.sessionConfig = sessionConfig }

        fun trustAllCerts(trustAllCerts: Boolean) = apply { this.trustAllCerts = trustAllCerts }

        fun build(): HttpClient {
            KotlinHelper.multiLet(sessionConfig, trustAllCerts) { (sessionConfig, trustAllCerts) ->
                return@build HttpClient(
                    sessionConfig as SessionConfig, trustAllCerts as Boolean
                )
            }
            throw IllegalStateException("Invalid configuration for ${HttpClient::class.simpleName}")
        }
    }
}