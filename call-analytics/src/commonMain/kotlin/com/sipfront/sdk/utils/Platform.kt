package com.sipfront.sdk.utils

internal enum class OsFamily {
    UNKNOWN,
    MACOSX,
    IOS,
    JAVASCRIPT,
    JAVA,
    LINUX,
    WINDOWS,
    ANDROID,
    WASM,
    TVOS,
    WATCHOS
}

internal expect object Platform {
    fun getOsFamily(): OsFamily
    fun getOsVersion(): String
    fun isDebug(): Boolean
    fun getBuildType() : String
    fun getDeviceModel(): String
}