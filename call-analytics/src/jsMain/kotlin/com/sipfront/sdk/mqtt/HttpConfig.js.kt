package com.sipfront.sdk.mqtt

import io.ktor.client.engine.*
import io.ktor.client.engine.js.*

internal actual fun getHttpClientEngine(
    trustAllCerts: Boolean, customSSLAlpn: String?
): HttpClientEngine = Js.create {
    
}