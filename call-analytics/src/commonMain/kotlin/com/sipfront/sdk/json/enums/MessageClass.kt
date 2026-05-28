package com.sipfront.sdk.json.enums

import com.sipfront.sdk.interfaces.EnumValue
import com.sipfront.sdk.json.serializer.MessageClassSerializer
import kotlinx.serialization.Serializable

@Serializable(with = MessageClassSerializer::class)
internal enum class MessageClass(override val value: String) : EnumValue {
    TRACE(Value.trace),
    CALL(Value.call),
    APPLICATION(Value.application),
    MWI(Value.mwi),
    VU_REPORT(Value.vuReport),
    AUDIO_LATENCY(Value.audioLatency),
    ASTERISK_FAX(Value.asteriskFax),
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
        const val application: String = "application"
        const val mwi: String = "mwi"
        const val vuReport: String = "VU_REPORT"
        const val audioLatency: String = "audio_latency"
        const val asteriskFax: String = "asterisk_fax"
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
