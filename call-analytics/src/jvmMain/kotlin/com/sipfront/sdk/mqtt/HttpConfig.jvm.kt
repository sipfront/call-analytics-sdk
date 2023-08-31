package com.sipfront.sdk.mqtt

import com.sipfront.sdk.mqtt.sslsocket.SSLConfigJvm
import io.ktor.client.engine.*
import io.ktor.client.engine.okhttp.*

internal actual fun getHttpClientEngine(
    trustAllCerts: Boolean, customSSLAlpn: String?
): HttpClientEngine = OkHttp.create {
    config {
        val sslConfig = SSLConfigJvm(trustAllCerts = trustAllCerts)
        sslSocketFactory(sslConfig.getSSLSocketFactory(), sslConfig.getTrustManager())
        if (trustAllCerts) @Suppress("UNUSED_ANONYMOUS_PARAMETER") hostnameVerifier { hostname, session -> true }
    }
}