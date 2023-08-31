package com.sipfront.sdk.utils

actual fun randomUUID(): String = java.util.UUID.randomUUID().toString()