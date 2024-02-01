package com.sipfront.sdk.utils

import kotlinx.datetime.Clock

internal fun currentTimeMillisFormatted() = currentTimeMillis().formatTimestamp()
private fun currentTimeMillis() = Clock.System.now().toEpochMilliseconds()
private fun Long.formatTimestamp() =
    StringBuilder(this.toString()).apply { insert(10, '.') }.toString().toDouble()