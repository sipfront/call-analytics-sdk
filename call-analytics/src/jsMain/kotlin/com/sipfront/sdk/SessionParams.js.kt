package com.sipfront.sdk

import com.sipfront.sdk.interfaces.ProguardKeep
import com.sipfront.sdk.json.JsonParser
import com.sipfront.sdk.json.config.SessionConfig
import com.sipfront.sdk.log.Log
import kotlinx.serialization.SerializationException

@Suppress("ACTUAL_ANNOTATIONS_NOT_MATCH_EXPECT", "EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")
actual class SessionParams(private val json: String): ProguardKeep {
    internal actual fun parse(): SessionConfig {
        try {
            val sessionParams = JsonParser.toObject<SessionConfig>(json)
            Log.debug()?.i("Received JSON SessionParams: $sessionParams")
            return sessionParams
        } catch (e: SerializationException) {
            throw e
        } catch (e: Exception) {
            throw IllegalArgumentException("Couldn't parse SessionParams: ${e.message}")
        }
    }
}