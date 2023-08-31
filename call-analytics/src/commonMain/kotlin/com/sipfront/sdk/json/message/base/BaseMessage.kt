package com.sipfront.sdk.json.message.base

import com.sipfront.sdk.interfaces.ProguardKeep
import com.sipfront.sdk.json.message.enums.MessageClass
import com.sipfront.sdk.json.message.enums.MessageType
import kotlinx.datetime.Clock
import kotlinx.serialization.Serializable

@Serializable
abstract class BaseMessage : ProguardKeep {
    abstract val timestamp: Double
    abstract val type: MessageType
    internal abstract val clazz: MessageClass

    companion object {
        internal fun currentTimeMillisFormatted() = currentTimeMillis().formatTimestamp()
        private fun currentTimeMillis() = Clock.System.now().toEpochMilliseconds()
        private fun Long.formatTimestamp() =
            StringBuilder(this.toString()).apply { insert(10, '.') }.toString().toDouble()
    }
}
