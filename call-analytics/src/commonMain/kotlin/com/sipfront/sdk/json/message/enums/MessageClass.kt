package com.sipfront.sdk.json.message.enums

import com.sipfront.sdk.interfaces.EnumValue
import com.sipfront.sdk.json.serializer.MessageClassSerializer
import kotlinx.serialization.Serializable

@Serializable(with = MessageClassSerializer::class)
enum class MessageClass(override val value: String) : EnumValue {
    TRACE(Value.trace),
    CALL(Value.call),
    RTCP(Value.rtp),
    CREATE(Value.create),
    SHUTDOWN(Value.shutdown),
    EXIT(Value.exit),
    REGISTERING(Value.registering),
    UNREGISTERING(Value.unregistering),
    REGISTER(Value.register),
    OTHER(Value.other);

    internal object Value {
        const val trace: String = "trace"
        const val call: String = "call"
        const val rtp: String = "rtp"
        const val create: String = "create"
        const val shutdown: String = "shutdown"
        const val exit: String = "exit"
        const val registering: String = "registering"
        const val unregistering: String = "unregistering"
        const val register: String = "register"
        const val other: String = "other"
    }
}