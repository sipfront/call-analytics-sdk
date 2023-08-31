package com.sipfront.sdk.utils

import platform.Foundation.NSProcessInfo
import kotlin.experimental.ExperimentalNativeApi

actual object Platform {
    actual fun getOsFamily(): OsFamily = OsFamily.MACOSX

    actual fun getOsVersion(): String = NSProcessInfo.processInfo.operatingSystemVersionString

    @OptIn(ExperimentalNativeApi::class)
    actual fun isDebug(): Boolean = kotlin.native.Platform.isDebugBinary

    actual fun getBuildType(): String = if (isDebug()) "debug" else "release"

    actual fun getDeviceModel(): String = "Mac"
}