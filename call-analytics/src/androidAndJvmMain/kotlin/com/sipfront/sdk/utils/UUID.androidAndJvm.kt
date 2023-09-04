package com.sipfront.sdk.utils

internal actual fun randomUUID(): String = java.util.UUID.randomUUID().toString()