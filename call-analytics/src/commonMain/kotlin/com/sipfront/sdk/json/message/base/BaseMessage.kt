package com.sipfront.sdk.json.message.base

import com.sipfront.sdk.interfaces.ProguardKeep
import com.sipfront.sdk.json.enums.MessageClass
import com.sipfront.sdk.json.enums.MessageType
import kotlinx.serialization.Serializable

@Serializable
abstract class BaseMessage : ProguardKeep {
    abstract val timestamp: Double
    abstract val type: MessageType
    internal abstract val clazz: MessageClass
}
