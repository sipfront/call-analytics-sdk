package com.sipfront.sdk.network.sslsocket

import android.annotation.SuppressLint
import java.security.KeyStore
import java.security.cert.X509Certificate
import javax.net.ssl.*

internal class SSLConfigAndroid(trustAllCerts: Boolean, customSslAlpn: String? = null): SSLConfigJvm(trustAllCerts) {
    private val trustManager: X509TrustManager =
        if (trustAllCerts) createUnsafeTrustManager() else createSafeTrustManager()
    private val sslContext: SSLContext = createSSLContext(arrayOf(trustManager))
    private val sslSocketFactory: SSLSocketFactory = createSSLSocketFactory(customSslAlpn)

    override fun getTrustManager(): X509TrustManager = trustManager
    override fun getSSLSocketFactory(): SSLSocketFactory = sslSocketFactory

    private fun createSSLSocketFactory(customSslAlpn: String?): SSLSocketFactory = customSslAlpn?.let { sslAlpn ->
        object : DelegatingSSLSocketFactory(sslContext.socketFactory) {
            override fun configureSocket(sslSocket: SSLSocket): SSLSocket {
                return object : DelegatingSSLSocket(sslSocket) {
                    override fun getApplicationProtocol(): String {
                        // this is required in order to speak with Amazon IoT MQTT backend
                        return sslAlpn
                    }
                }
            }
        }
    } ?: run {
        sslContext.socketFactory
    }


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

    @SuppressLint("CustomX509TrustManager")
    private fun createUnsafeTrustManager(): X509TrustManager {
        return object : X509TrustManager {
            @SuppressLint("TrustAllX509TrustManager")
            override fun checkClientTrusted(
                chain: Array<out X509Certificate>?, authType: String?
            ) {
            }

            @SuppressLint("TrustAllX509TrustManager")
            override fun checkServerTrusted(
                chain: Array<out X509Certificate>?, authType: String?
            ) {
            }

            override fun getAcceptedIssuers() = arrayOf<X509Certificate>()
        }
    }
}