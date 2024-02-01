package com.sipfront.sdk.network.config

import io.ktor.client.engine.*

internal expect fun getHttpClientEngine(trustAllCerts: Boolean, customSSLAlpn: String? = null): HttpClientEngine