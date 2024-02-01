package com.sipfront.sdk.network.config

import com.sipfront.sdk.network.sslsocket.SSLConfigAndroid
import io.ktor.client.engine.*
import io.ktor.client.engine.okhttp.*

internal actual fun getHttpClientEngine(trustAllCerts: Boolean, customSSLAlpn: String?): HttpClientEngine = OkHttp.create {
    config {
        val sslConfig = SSLConfigAndroid(trustAllCerts = trustAllCerts, customSslAlpn = customSSLAlpn)
        sslSocketFactory(sslConfig.getSSLSocketFactory(), sslConfig.getTrustManager())
        if (trustAllCerts) @Suppress("UNUSED_ANONYMOUS_PARAMETER") hostnameVerifier { hostname, session -> true }
    }
}