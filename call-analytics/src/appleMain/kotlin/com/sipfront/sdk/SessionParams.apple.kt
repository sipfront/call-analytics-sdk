package com.sipfront.sdk

import com.sipfront.sdk.constants.Keys
import com.sipfront.sdk.interfaces.ProguardKeep
import com.sipfront.sdk.json.JsonParser
import com.sipfront.sdk.json.config.SessionConfig
import com.sipfront.sdk.log.Log
import kotlinx.serialization.SerializationException
import platform.Foundation.NSProcessInfo

actual class SessionParams : ProguardKeep {
    @Throws(SerializationException::class, IllegalArgumentException::class, IllegalStateException::class)
    internal actual fun parse(): SessionConfig {
        try {
            val json: String = NSProcessInfo.processInfo.environment[Keys.INITIALIZATION] as String
            Log.debug()?.i("Received JSON SessionParams: $json")
            return JsonParser.toObject<SessionConfig>(json)
        } catch (e: SerializationException) {
            throw e
        } catch (e: Exception) {
            throw IllegalStateException("Couldn't parse SessionParams: ${e.message}")
        }
    }
}