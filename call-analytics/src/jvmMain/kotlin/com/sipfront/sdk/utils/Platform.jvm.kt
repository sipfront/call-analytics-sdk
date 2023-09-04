package com.sipfront.sdk.utils

internal actual object Platform {
    actual fun getOsFamily(): OsFamily = OsFamily.JAVA

    actual fun getOsVersion(): String = System.getProperty("os.version")

    actual fun isDebug(): Boolean = javaClass.classLoader?.getResource("application.properties") != null

    actual fun getBuildType(): String  = if (isDebug()) "debug" else "release"

    actual fun getDeviceModel(): String = System.getProperty("os.name")
}