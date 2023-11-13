package com.sipfront.sdk

import com.sipfront.sdk.interfaces.ProguardKeep
import com.sipfront.sdk.json.config.SessionConfig
import kotlinx.serialization.SerializationException

/**
 * ### Parse session params provided with Sipfront test
 *
 * The Format differs depending on which platform a test is run, this class normalizes and parses the data in order to
 * correctly set up the test
 *
 * @since 1.0.0
 * @author Dominik Ridjic
 */
@Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")
expect class SessionParams: ProguardKeep {
    @Throws(IllegalArgumentException::class, SerializationException::class)
    internal fun parse(): SessionConfig
}