package com.sipfront.sdk

import com.sipfront.sdk.interfaces.ProguardKeep
import com.sipfront.sdk.json.config.SessionConfig
import kotlinx.serialization.SerializationException

/**
 * ### Parse session params provided with Sipfront test
 *
 * Format differs depending on which platform a test is run, this class normalizes and parses the data in order to
 * correctly set up the test
 */
expect class SessionParams: ProguardKeep {
    @Throws(IllegalArgumentException::class, SerializationException::class)
    internal fun parse(): SessionConfig
}