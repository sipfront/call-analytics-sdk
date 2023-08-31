package com.sipfront.sdk.constants

object SipfrontIntent {
    private const val separator = "_"
    private const val prefix = "SIPFRONT"
    private const val session = "${prefix}${separator}SESSION${separator}"

    enum class Extra(val value: String) {
        CONFIG("${session}INITIALIZATION")
    }
}