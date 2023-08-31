package com.sipfront.sdk.dns

internal actual fun resolveCname(server: String): String? {
    throw NotImplementedError("Resolving CNAME is currently not implemented on JavaScript!")
}