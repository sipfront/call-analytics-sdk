package com.sipfront.sdk.mqtt.sslsocket

import java.security.KeyStore
import java.security.cert.X509Certificate
import javax.net.ssl.*

internal open class SSLConfigJvm(trustAllCerts: Boolean) {
    private val trustManager: X509TrustManager =
        if (trustAllCerts) createUnsafeTrustManager() else createSafeTrustManager()
    private val sslContext: SSLContext = createSSLContext(arrayOf(trustManager))
    private val sslSocketFactory: SSLSocketFactory = sslContext.socketFactory

    internal open fun getTrustManager(): X509TrustManager = trustManager
    internal open fun getSSLSocketFactory(): SSLSocketFactory = sslSocketFactory


    private fun createSSLContext(trustManager: Array<X509TrustManager>?): SSLContext {
        val sslContext = SSLContext.getInstance("SSL")
        sslContext.init(null, trustManager, java.security.SecureRandom())
        return sslContext
    }

    private fun createSafeTrustManager(): X509TrustManager {
        val trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm())
        trustManagerFactory.init(null as KeyStore?)
        val trustManagers = trustManagerFactory.trustManagers
        if (trustManagers.size != 1 || trustManagers[0] !is X509TrustManager) {
            throw IllegalStateException(
                "Unexpected default trust managers: ${trustManagers.contentToString()}"
            )
        }
        return trustManagers[0] as X509TrustManager
    }

    private fun createUnsafeTrustManager(): X509TrustManager {
        return object : X509TrustManager {
            override fun checkClientTrusted(
                chain: Array<out X509Certificate>?, authType: String?
            ) {
            }

            override fun checkServerTrusted(
                chain: Array<out X509Certificate>?, authType: String?
            ) {
            }

            override fun getAcceptedIssuers() = arrayOf<X509Certificate>()
        }
    }
}