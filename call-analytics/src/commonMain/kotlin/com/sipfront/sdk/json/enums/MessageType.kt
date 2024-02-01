package com.sipfront.sdk.json.enums

import com.sipfront.sdk.interfaces.EnumValue
import com.sipfront.sdk.json.serializer.RtcpSerializer
import com.sipfront.sdk.json.serializer.SdpSerializer
import com.sipfront.sdk.json.serializer.SipSerializer
import com.sipfront.sdk.json.serializer.StateSerializer
import kotlinx.serialization.Serializable
import kotlin.experimental.ExperimentalObjCName
import kotlin.native.ObjCName

/**
 * Represents different types of messages used within the SDK.
 *
 * This interface is a marker for various message types, each represented as an enum.
 */
@OptIn(ExperimentalObjCName::class)
@ObjCName("Message")
interface MessageType : EnumValue {
    private companion object {
        const val SIP_OUTGOING: String = "TRACE_TX_MSG"
        const val SIP_INCOMING: String = "TRACE_RX_MSG"
        const val SDP_OUTGOING: String = SIP_OUTGOING
        const val SDP_INCOMING: String = SIP_INCOMING
        const val RTCP: String = "CALL_RTCP"
        const val STATE_REGISTER: String = "REGISTER_OK"
        const val STATE_REGISTERING: String = "REGISTERING"
        const val STATE_UNREGISTERING: String = "UNREGISTERING"
        const val STATE_CREATE: String = "CREATE"
        const val STATE_SHUTDOWN: String = "SHUTDOWN"
        const val STATE_EXIT: String = "EXIT"
        const val STATE_CALL_INCOMING: String = "CALL_INCOMING"
        const val STATE_CALL_OUTGOING: String = "CALL_OUTGOING"
        const val STATE_CALL_RINGING: String = "CALL_RINGING"
        const val STATE_CALL_ESTABLISHED: String = "CALL_ESTABLISHED"
        const val STATE_CALL_RTPESTAB: String = "CALL_RTPESTAB"
        const val STATE_CALL_ENDED_LOCAL: String = "CALL_ENDED_LOCAL"
        const val STATE_CALL_ENDED_REMOTE: String = "CALL_ENDED_REMOTE"
        const val STATE_CALL_REJECTED: String = "CALL_REJECTED"
        const val STATE_CALL_FAILED: String = "CALL_FAILED"
        const val STATE_CALL_CLOSED: String = "CALL_CLOSED"
        const val STATE_CALL_IN_PROGRESS: String = "CALL_IN_PROGRESS"
    }

    /**
     * Represents RTCP message types.
     *
     * Currently, only one type [RTCP] is defined.
     */
    @Serializable(with = RtcpSerializer::class)
    enum class Rtcp(override val value: String) : MessageType {
        /**
         * Represents the default RTCP message type.
         */
        RTCP(MessageType.RTCP)
    }

    /**
     * Represents SIP message types.
     *
     * Types include:
     * - [OUTGOING]: Message is outgoing.
     * - [INCOMING]: Message is incoming.
     */
    @Serializable(with = SipSerializer::class)
    enum class Sip(override val value: String) : MessageType {
        /**
         * Represents an outgoing SIP message.
         */
        OUTGOING(SIP_OUTGOING),
        /**
         * Represents an incoming SIP message.
         */
        INCOMING(SIP_INCOMING)
    }

    /**
     * Represents SDP message types.
     *
     * Types include:
     * - [OUTGOING]: SDP message is outgoing.
     * - [INCOMING]: SDP message is incoming.
     */
    @Serializable(with = SdpSerializer::class)
    enum class Sdp(override val value: String) : MessageType {
        /**
         * Represents an outgoing SDP message.
         */
        OUTGOING(SDP_OUTGOING),
        /**
         * Represents an incoming SDP message.
         */
        INCOMING(SDP_INCOMING)
    }

    /**
     * Represents various call state messages.
     *
     * This enum encapsulates different states a call can be in, such as being established, ended, rejected, and so on.
     */
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