package com.sipfront.sdk

import android.content.Intent
import com.sipfront.sdk.constants.Keys
import com.sipfront.sdk.interfaces.ProguardKeep
import com.sipfront.sdk.json.JsonParser
import com.sipfront.sdk.json.config.SessionConfig
import com.sipfront.sdk.log.Log
import kotlinx.serialization.SerializationException

@Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")
actual class SessionParams(private val intent: Intent) : ProguardKeep {
    @Throws(IllegalArgumentException::class, SerializationException::class)
    internal actual fun parse(): SessionConfig {
        intent.getStringExtra(Keys.INITIALIZATION)?.let { json ->
            val sessionParams = JsonParser.toObject<SessionConfig>(json)
            Log.debug()?.i("Received Intent SessionParams: $sessionParams")
            return sessionParams
        } ?: run {
            val extras: String = intent.extras?.keySet()?.map {
                it to (intent.extras?.getString(it) ?: "null")
            }.toString()
            throw IllegalArgumentException("Invalid or null Intent with SessionParams provided, extras=$extras")
        }
    }
}