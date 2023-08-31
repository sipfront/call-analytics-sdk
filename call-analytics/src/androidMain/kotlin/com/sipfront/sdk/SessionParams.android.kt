package com.sipfront.sdk

import android.content.Intent
import com.sipfront.sdk.constants.SipfrontIntent
import com.sipfront.sdk.interfaces.ProguardKeep
import com.sipfront.sdk.json.JsonParser
import com.sipfront.sdk.json.config.SessionConfig
import com.sipfront.sdk.log.Log
import kotlinx.serialization.SerializationException

actual class SessionParams(private val intent: Intent): ProguardKeep {
    @Throws(SerializationException::class, IllegalArgumentException::class)
    internal actual fun parse(): SessionConfig {
        intent.getStringExtra(SipfrontIntent.Extra.CONFIG.value)?.let { data ->
            Log.debug()?.i("Received Intent SessionParams: $data")
            return JsonParser.toObject(data)
        } ?: run {
            val extras: String = intent.extras?.keySet()?.map {
                it to (intent.extras?.getString(it) ?: "null")
            }.toString()
            throw IllegalArgumentException("Invalid or null Intent with SessionParams provided, extras=$extras")
        }
    }
}