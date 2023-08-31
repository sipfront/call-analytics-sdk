package com.sipfront.sdk.mqtt

import io.ktor.client.engine.*

internal expect fun getHttpClientEngine(trustAllCerts: Boolean, customSSLAlpn: String? = null): HttpClientEngine