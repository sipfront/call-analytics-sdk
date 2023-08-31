package com.sipfront.sdk.json.message.enums

import com.sipfront.sdk.interfaces.EnumValue
import com.sipfront.sdk.json.serializer.RtcpSerializer
import com.sipfront.sdk.json.serializer.SdpSerializer
import com.sipfront.sdk.json.serializer.SipSerializer
import com.sipfront.sdk.json.serializer.StateSerializer
import kotlinx.serialization.Serializable
import kotlin.experimental.ExperimentalObjCName
import kotlin.native.ObjCName

@OptIn(ExperimentalObjCName::class)
@ObjCName("Message")
interface MessageType : EnumValue {
    companion object {
        internal const val SIP_OUTGOING: String = "TRACE_TX_MSG"
        internal const val SIP_INCOMING: String = "TRACE_RX_MSG"
        internal const val SDP_OUTGOING: String = SIP_OUTGOING
        internal const val SDP_INCOMING: String = SIP_INCOMING
        internal const val RTCP: String = "CALL_RTCP"
        internal const val STATE_REGISTER: String = "REGISTER_OK"
        internal const val STATE_REGISTERING: String = "REGISTERING"
        internal const val STATE_UNREGISTERING: String = "UNREGISTERING"
        internal const val STATE_CREATE: String = "CREATE"
        internal const val STATE_SHUTDOWN: String = "SHUTDOWN"
        internal const val STATE_EXIT: String = "EXIT"
        internal const val STATE_CALL_INCOMING: String = "CALL_INCOMING"
        internal const val STATE_CALL_OUTGOING: String = "CALL_OUTGOING"
        internal const val STATE_CALL_RINGING: String = "CALL_RINGING"
        internal const val STATE_CALL_ESTABLISHED: String = "CALL_ESTABLISHED"
        internal const val STATE_CALL_RTPESTAB: String = "CALL_RTPESTAB"
        internal const val STATE_CALL_ENDED_LOCAL: String = "CALL_ENDED_LOCAL"
        internal const val STATE_CALL_ENDED_REMOTE: String = "CALL_ENDED_REMOTE"
        internal const val STATE_CALL_REJECTED: String = "CALL_REJECTED"
        internal const val STATE_CALL_FAILED: String = "CALL_FAILED"
        internal const val STATE_CALL_CLOSED: String = "CALL_CLOSED"
        internal const val STATE_CALL_IN_PROGRESS: String = "CALL_IN_PROGRESS"
    }

    @Serializable(with = RtcpSerializer::class)
    enum class Rtcp(override val value: String) : MessageType {
        RTCP(MessageType.RTCP)
    }

    @Serializable(with = SipSerializer::class)
    enum class Sip(override val value: String) : MessageType {
        OUTGOING(SIP_OUTGOING),
        INCOMING(SIP_INCOMING)
    }

    @Serializable(with = SdpSerializer::class)
    enum class Sdp(override val value: String) : MessageType {
        OUTGOING(SDP_OUTGOING),
        INCOMING(SDP_INCOMING)
    }

    @Serializable(with = StateSerializer::class)
    enum class State(override val value: String) : MessageType {
        CREATE(STATE_CREATE),
        REGISTER(STATE_REGISTER),
        REGISTERING(STATE_REGISTERING),
        UNREGISTERING(STATE_UNREGISTERING),
        SHUTDOWN(STATE_SHUTDOWN),
        EXIT(STATE_EXIT),
        CALL_INCOMING(STATE_CALL_INCOMING),
        CALL_OUTGOING(STATE_CALL_OUTGOING),
        CALL_RINGING(STATE_CALL_RINGING),
        CALL_ESTABLISHED(STATE_CALL_ESTABLISHED),
        CALL_RTP_ESTABLISHED(STATE_CALL_RTPESTAB),
        CALL_ENDED_LOCAL(STATE_CALL_ENDED_LOCAL),
        CALL_ENDED_REMOTE(STATE_CALL_ENDED_REMOTE),
        CALL_REJECTED(STATE_CALL_REJECTED),
        CALL_FAILED(STATE_CALL_FAILED),
        CALL_CLOSED(STATE_CALL_CLOSED),
        CALL_IN_PROGRESS(STATE_CALL_IN_PROGRESS);
    }
}