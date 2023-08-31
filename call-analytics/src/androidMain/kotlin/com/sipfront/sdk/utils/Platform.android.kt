package com.sipfront.sdk.utils

import android.os.Build
import co.touchlab.kermit.BuildConfig

actual object Platform {
    actual fun getOsFamily(): OsFamily = OsFamily.ANDROID
    actual fun getOsVersion(): String = Build.VERSION.SDK_INT.toString()
    actual fun getDeviceModel(): String = "${Build.MANUFACTURER} ${Build.MODEL}"
    actual fun isDebug(): Boolean = BuildConfig.BUILD_TYPE == "debug"
    actual fun getBuildType(): String = if (isDebug()) "debug" else "release"
}