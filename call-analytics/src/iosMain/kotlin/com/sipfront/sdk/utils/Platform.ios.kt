package com.sipfront.sdk.utils

import platform.UIKit.UIDevice
import kotlin.experimental.ExperimentalNativeApi

internal actual object Platform {
    actual fun getOsFamily(): OsFamily = OsFamily.IOS
    actual fun getOsVersion(): String = UIDevice.currentDevice.systemVersion
    actual fun getDeviceModel(): String = UIDevice.currentDevice.model

    @OptIn(ExperimentalNativeApi::class)
    actual fun isDebug(): Boolean = kotlin.native.Platform.isDebugBinary
    actual fun getBuildType(): String = if (isDebug()) "debug" else "release"
}