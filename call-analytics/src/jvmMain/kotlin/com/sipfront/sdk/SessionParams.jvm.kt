package com.sipfront.sdk

import com.sipfront.sdk.interfaces.ProguardKeep
import com.sipfront.sdk.json.JsonParser
import com.sipfront.sdk.json.config.SessionConfig
import com.sipfront.sdk.log.Log
import kotlinx.serialization.SerializationException

actual class SessionParams(private val json: String): ProguardKeep {
    @Throws(SerializationException::class, IllegalArgumentException::class)
    internal actual fun parse(): SessionConfig {
        Log.debug()?.i("Received Json SessionParams: $json")
        return JsonParser.toObject<SessionConfig>(json)
    }
}
