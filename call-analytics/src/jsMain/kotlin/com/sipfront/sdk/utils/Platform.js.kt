package com.sipfront.sdk.utils

internal actual object Platform {
    private const val NOT_AVAILABLE = "Not available in JS"
    actual fun getOsFamily(): OsFamily = OsFamily.JAVASCRIPT

    actual fun getOsVersion(): String {
        return try {
            js("process.versions.node") as String
        } catch (e: dynamic) {
            NOT_AVAILABLE
        }
    }

    actual fun isDebug(): Boolean = js("process.env.NODE_ENV") == "development"

    actual fun getBuildType(): String = if (isDebug()) "debug" else "release"

    actual fun getDeviceModel(): String = NOT_AVAILABLE
}