package com.sipfront.sdk

import com.sipfront.sdk.interfaces.ProguardKeep
import com.sipfront.sdk.json.JsonParser
import com.sipfront.sdk.json.config.SessionConfig
import com.sipfront.sdk.log.Log

@Suppress("ACTUAL_ANNOTATIONS_NOT_MATCH_EXPECT", "EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")
actual class SessionParams(private val json: String): ProguardKeep {
    internal actual fun parse(): SessionConfig {
        Log.debug()?.i("Received Json SessionParams: $json")
        return JsonParser.toObject<SessionConfig>(json)
    }
}