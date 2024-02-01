package com.sipfront.sdk.constants

internal object Constants {
    const val DEBUG_FALLBACK_INIT_DATA: Boolean = false
    const val RTCP_READ_INTERVAL_MS: Long = 100
    const val MQTT_MAX_RETRIES: Int = 5
    const val MQTT_TIMEOUT_MS_CONNECTION: Long = 10_000
    const val MQTT_TIMEOUT_MS_REQUEST: Long = 30_000
    const val MQTT_TIMEOUT_MS_SOCKET: Long = 60_000
    const val HTTP_MAX_RETRIES: Int = 5
    const val HTTP_TIMEOUT_MS_CONNECTION: Long = 10_000
    const val HTTP_TIMEOUT_MS_REQUEST: Long = 30_000
    const val HTTP_TIMEOUT_MS_SOCKET: Long = 60_000
}