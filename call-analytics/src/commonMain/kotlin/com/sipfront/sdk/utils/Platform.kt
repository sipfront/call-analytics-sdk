package com.sipfront.sdk.utils

import com.sipfront.sdk.BuildKonfig

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

@Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")
internal expect object Platform {
    fun getOsFamily(): OsFamily
    fun getOsVersion(): String
    fun isDebug(): Boolean
    fun getBuildType(): String
    fun getDeviceModel(): String
}

/**
 * This function assembles and returns a descriptive string detailing the software and hardware configuration in use.
 * The resulting string provides insights into the version of the SDK, the build type, the operating system, and the device model.
 *
 * Example: CallAnalyticsSdk v1.0.3-debug (iOS 14.1 - iPhone13)
 *
 * @return [String] UserAgent describing software and hardware configuration
 * @since 1.0.4
 */
internal fun getUserAgent(): String =
    "${BuildKonfig.PROJECT_NAME} v${BuildKonfig.VERSION_CODE}-${Platform.getBuildType()} (${Platform.getOsFamily()} ${Platform.getOsVersion()} - ${Platform.getDeviceModel()})"