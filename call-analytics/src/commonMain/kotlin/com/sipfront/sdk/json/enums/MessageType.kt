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
        const val STATE_REGISTER_FAILED: String = "REGISTER_FAIL"
        const val STATE_REGISTERING: String = "REGISTERING"
        const val STATE_UNREGISTERING: String = "UNREGISTERING"
        const val STATE_FALLBACK_OK: String = "FALLBACK_OK"
        const val STATE_FALLBACK_FAILED: String = "FALLBACK_FAIL"
        const val STATE_MWI_NOTIFY: String = "MWI_NOTIFY"
        const val STATE_CREATE: String = "CREATE"
        const val STATE_SHUTDOWN: String = "SHUTDOWN"
        const val STATE_EXIT: String = "EXIT"
        const val STATE_SIP_SESSION_CONNECTED: String = "SIPSESS_CONN"
        const val STATE_CALL_POST_DIAL_DELAY: String = "CALL_STAT"
        const val STATE_CALL_INCOMING: String = "CALL_INCOMING"
        const val STATE_CALL_OUTGOING: String = "CALL_OUTGOING"
        const val STATE_CALL_RINGING: String = "CALL_RINGING"
        const val STATE_CALL_PROGRESS: String = "CALL_PROGRESS"
        const val STATE_CALL_ANSWERED: String = "CALL_ANSWERED"
        const val STATE_CALL_ANSWERING: String = "CALL_ANSWERING"
        const val STATE_CALL_ANSWER_DELAY: String = "CALL_ANSWER_DELAY"
        const val STATE_CALL_ESTABLISHED: String = "CALL_ESTABLISHED"
        const val STATE_CALL_RTPESTAB: String = "CALL_RTPESTAB"
        const val STATE_CALL_LOCAL_SDP: String = "CALL_LOCAL_SDP"
        const val STATE_CALL_REMOTE_SDP: String = "CALL_REMOTE_SDP"
        const val STATE_CALL_ENDED_LOCAL: String = "CALL_ENDED_LOCAL"
        const val STATE_CALL_ENDED_REMOTE: String = "CALL_ENDED_REMOTE"
        const val STATE_CALL_REJECTED: String = "CALL_REJECTED"
        const val STATE_CALL_FAILED: String = "CALL_FAILED"
        const val STATE_CALL_BUSY_HERE: String = "CALL_BUSY_HERE"
        const val STATE_CALL_TEMPORARILY_UNAVAILABLE: String = "CALL_TEMPORARILY_UNAVAILABLE"
        const val STATE_CALL_FORBIDDEN: String = "CALL_FORBIDDEN"
        const val STATE_CALL_NOT_ACCEPTABLE: String = "CALL_NOT_ACCEPTABLE"
        const val STATE_CALL_NOT_FOUND: String = "CALL_NOT_FOUND"
        const val STATE_CALL_DECLINE: String = "CALL_DECLINE"
        const val STATE_CALL_CANCEL: String = "CALL_CANCEL"
        const val STATE_CALL_UNAUTHORIZED: String = "CALL_UNAUTHORIZED"
        const val STATE_CALL_PROXY_AUTHENTICATION_REQUIRED: String = "CALL_PROXY_AUTHENTICATION_REQUIRED"
        const val STATE_CALL_CLOSED: String = "CALL_CLOSED"
        const val STATE_CALL_IN_PROGRESS: String = "CALL_IN_PROGRESS"
        const val STATE_CALL_HOLD: String = "CALL_HOLD"
        const val STATE_CALL_RESUME: String = "CALL_RESUME"
        const val STATE_CALL_HOLD_LOCAL: String = "CALL_HOLD_LOCAL"
        const val STATE_CALL_RESUME_LOCAL: String = "CALL_RESUME_LOCAL"
        const val STATE_CALL_TRANSFER: String = "CALL_TRANSFER"
        const val STATE_CALL_TRANSFER_FAILED: String = "CALL_TRANSFER_FAILED"
        const val STATE_CALL_REDIRECT: String = "CALL_REDIRECT"
        const val STATE_CALL_DTMF_START: String = "CALL_DTMF_START"
        const val STATE_CALL_DTMF_0: String = "CALL_DTMF_0"
        const val STATE_CALL_DTMF_1: String = "CALL_DTMF_1"
        const val STATE_CALL_DTMF_2: String = "CALL_DTMF_2"
        const val STATE_CALL_DTMF_3: String = "CALL_DTMF_3"
        const val STATE_CALL_DTMF_4: String = "CALL_DTMF_4"
        const val STATE_CALL_DTMF_5: String = "CALL_DTMF_5"
        const val STATE_CALL_DTMF_6: String = "CALL_DTMF_6"
        const val STATE_CALL_DTMF_7: String = "CALL_DTMF_7"
        const val STATE_CALL_DTMF_8: String = "CALL_DTMF_8"
        const val STATE_CALL_DTMF_9: String = "CALL_DTMF_9"
        const val STATE_CALL_DTMF_A: String = "CALL_DTMF_A"
        const val STATE_CALL_DTMF_B: String = "CALL_DTMF_B"
        const val STATE_CALL_DTMF_C: String = "CALL_DTMF_C"
        const val STATE_CALL_DTMF_D: String = "CALL_DTMF_D"
        const val STATE_CALL_DTMF_ASTERISK: String = "CALL_DTMF_*"
        const val STATE_CALL_DTMF_POUND: String = "CALL_DTMF_#"
        const val STATE_CALL_DTMF_END: String = "CALL_DTMF_END"
        const val STATE_CALL_SEND_DTMF_START: String = "CALL_SEND_DTMF_START"
        const val STATE_CALL_SEND_DTMF_0: String = "CALL_SEND_DTMF_0"
        const val STATE_CALL_SEND_DTMF_1: String = "CALL_SEND_DTMF_1"
        const val STATE_CALL_SEND_DTMF_2: String = "CALL_SEND_DTMF_2"
        const val STATE_CALL_SEND_DTMF_3: String = "CALL_SEND_DTMF_3"
        const val STATE_CALL_SEND_DTMF_4: String = "CALL_SEND_DTMF_4"
        const val STATE_CALL_SEND_DTMF_5: String = "CALL_SEND_DTMF_5"
        const val STATE_CALL_SEND_DTMF_6: String = "CALL_SEND_DTMF_6"
        const val STATE_CALL_SEND_DTMF_7: String = "CALL_SEND_DTMF_7"
        const val STATE_CALL_SEND_DTMF_8: String = "CALL_SEND_DTMF_8"
        const val STATE_CALL_SEND_DTMF_9: String = "CALL_SEND_DTMF_9"
        const val STATE_CALL_SEND_DTMF_A: String = "CALL_SEND_DTMF_A"
        const val STATE_CALL_SEND_DTMF_B: String = "CALL_SEND_DTMF_B"
        const val STATE_CALL_SEND_DTMF_C: String = "CALL_SEND_DTMF_C"
        const val STATE_CALL_SEND_DTMF_D: String = "CALL_SEND_DTMF_D"
        const val STATE_CALL_SEND_DTMF_ASTERISK: String = "CALL_SEND_DTMF_*"
        const val STATE_CALL_SEND_DTMF_POUND: String = "CALL_SEND_DTMF_#"
        const val STATE_CALL_SEND_DTMF_END: String = "CALL_SEND_DTMF_END"
        const val STATE_CALL_MENC: String = "CALL_MENC"
        const val STATE_VU_TX: String = "VU_TX"
        const val STATE_VU_RX: String = "VU_RX"
        const val STATE_AUDIO_ERROR: String = "AUDIO_ERROR"
        const val STATE_AUDIO_LATENCY_OUTGOING: String = "AUDIO_LATENCY_OUTGOING"
        const val STATE_AUDIO_LATENCY_INCOMING: String = "AUDIO_LATENCY_INCOMING"
        const val STATE_FAX_SUCCESS: String = "FAX_SUCCESS"
        const val STATE_FAX_FAILED: String = "FAX_FAILED"
        const val STATE_FAXMODE_AUDIO: String = "FAXMODE_AUDIO"
        const val STATE_FAXMODE_T38: String = "FAXMODE_T38"
        const val STATE_PHONE_ATTACHED: String = "PHONE_ATTACHED"
        const val STATE_PHONE_DETACHED: String = "PHONE_DETACHED"
        const val STATE_PHONE_SELECTED: String = "PHONE_SELECTED"
        const val STATE_PHONE_PROPERTY_CHANGED: String = "PHONE_PROPERTY_CHANGED"
        const val STATE_HANDSFREE_PROPERTY_CHANGED: String = "HANDSFREE_PROPERTY_CHANGED"
        const val STATE_CALLVOLUME_CHANGED: String = "CALLVOLUME_CHANGED"
        const val STATE_CALL_REMOVED: String = "CALL_REMOVED"
        const val STATE_CALL_HELD: String = "CALL_HELD"
        const val STATE_CALL_WAITING: String = "CALL_WAITING"
        const val STATE_CALL_STATE_CHANGED: String = "CALL_STATE_CHANGED"
        const val STATE_CALL_PROPERTY_CHANGED: String = "CALL_PROPERTY_CHANGED"
        const val STATE_CALL_DISCONNECTED: String = "CALL_DISCONNECTED"
        const val STATE_CALLMANAGER_PROPERTY_CHANGED: String = "CALLMANAGER_PROPERTY_CHANGED"
        const val STATE_CALLMANAGER_BARRING_ACTIVE: String = "CALLMANAGER_BARRING_ACTIVE"
        const val STATE_CALLMANAGER_FORWARDED: String = "CALLMANAGER_FORWARDED"
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
        REGISTER_FAILED(STATE_REGISTER_FAILED),
        REGISTERING(STATE_REGISTERING),
        UNREGISTERING(STATE_UNREGISTERING),
        FALLBACK_OK(STATE_FALLBACK_OK),
        FALLBACK_FAILED(STATE_FALLBACK_FAILED),
        MWI_NOTIFY(STATE_MWI_NOTIFY),
        SHUTDOWN(STATE_SHUTDOWN),
        EXIT(STATE_EXIT),
        SIP_SESSION_CONNECTED(STATE_SIP_SESSION_CONNECTED),
        CALL_POST_DIAL_DELAY(STATE_CALL_POST_DIAL_DELAY),
        CALL_INCOMING(STATE_CALL_INCOMING),
        CALL_OUTGOING(STATE_CALL_OUTGOING),
        CALL_RINGING(STATE_CALL_RINGING),
        CALL_PROGRESS(STATE_CALL_PROGRESS),
        CALL_ANSWERED(STATE_CALL_ANSWERED),
        CALL_ANSWERING(STATE_CALL_ANSWERING),
        CALL_ANSWER_DELAY(STATE_CALL_ANSWER_DELAY),
        CALL_ESTABLISHED(STATE_CALL_ESTABLISHED),
        CALL_RTP_ESTABLISHED(STATE_CALL_RTPESTAB),
        CALL_LOCAL_SDP(STATE_CALL_LOCAL_SDP),
        CALL_REMOTE_SDP(STATE_CALL_REMOTE_SDP),
        CALL_ENDED_LOCAL(STATE_CALL_ENDED_LOCAL),
        CALL_ENDED_REMOTE(STATE_CALL_ENDED_REMOTE),
        CALL_REJECTED(STATE_CALL_REJECTED),
        CALL_FAILED(STATE_CALL_FAILED),
        CALL_BUSY_HERE(STATE_CALL_BUSY_HERE),
        CALL_TEMPORARILY_UNAVAILABLE(STATE_CALL_TEMPORARILY_UNAVAILABLE),
        CALL_FORBIDDEN(STATE_CALL_FORBIDDEN),
        CALL_NOT_ACCEPTABLE(STATE_CALL_NOT_ACCEPTABLE),
        CALL_NOT_FOUND(STATE_CALL_NOT_FOUND),
        CALL_DECLINE(STATE_CALL_DECLINE),
        CALL_CANCEL(STATE_CALL_CANCEL),
        CALL_UNAUTHORIZED(STATE_CALL_UNAUTHORIZED),
        CALL_PROXY_AUTHENTICATION_REQUIRED(STATE_CALL_PROXY_AUTHENTICATION_REQUIRED),
        CALL_CLOSED(STATE_CALL_CLOSED),
        CALL_IN_PROGRESS(STATE_CALL_IN_PROGRESS),
        CALL_HOLD(STATE_CALL_HOLD),
        CALL_RESUME(STATE_CALL_RESUME),
        CALL_HOLD_LOCAL(STATE_CALL_HOLD_LOCAL),
        CALL_RESUME_LOCAL(STATE_CALL_RESUME_LOCAL),
        CALL_TRANSFER(STATE_CALL_TRANSFER),
        CALL_TRANSFER_FAILED(STATE_CALL_TRANSFER_FAILED),
        CALL_REDIRECT(STATE_CALL_REDIRECT),
        CALL_DTMF_START(STATE_CALL_DTMF_START),
        CALL_DTMF_0(STATE_CALL_DTMF_0),
        CALL_DTMF_1(STATE_CALL_DTMF_1),
        CALL_DTMF_2(STATE_CALL_DTMF_2),
        CALL_DTMF_3(STATE_CALL_DTMF_3),
        CALL_DTMF_4(STATE_CALL_DTMF_4),
        CALL_DTMF_5(STATE_CALL_DTMF_5),
        CALL_DTMF_6(STATE_CALL_DTMF_6),
        CALL_DTMF_7(STATE_CALL_DTMF_7),
        CALL_DTMF_8(STATE_CALL_DTMF_8),
        CALL_DTMF_9(STATE_CALL_DTMF_9),
        CALL_DTMF_A(STATE_CALL_DTMF_A),
        CALL_DTMF_B(STATE_CALL_DTMF_B),
        CALL_DTMF_C(STATE_CALL_DTMF_C),
        CALL_DTMF_D(STATE_CALL_DTMF_D),
        CALL_DTMF_ASTERISK(STATE_CALL_DTMF_ASTERISK),
        CALL_DTMF_POUND(STATE_CALL_DTMF_POUND),
        CALL_DTMF_END(STATE_CALL_DTMF_END),
        CALL_SEND_DTMF_START(STATE_CALL_SEND_DTMF_START),
        CALL_SEND_DTMF_0(STATE_CALL_SEND_DTMF_0),
        CALL_SEND_DTMF_1(STATE_CALL_SEND_DTMF_1),
        CALL_SEND_DTMF_2(STATE_CALL_SEND_DTMF_2),
        CALL_SEND_DTMF_3(STATE_CALL_SEND_DTMF_3),
        CALL_SEND_DTMF_4(STATE_CALL_SEND_DTMF_4),
        CALL_SEND_DTMF_5(STATE_CALL_SEND_DTMF_5),
        CALL_SEND_DTMF_6(STATE_CALL_SEND_DTMF_6),
        CALL_SEND_DTMF_7(STATE_CALL_SEND_DTMF_7),
        CALL_SEND_DTMF_8(STATE_CALL_SEND_DTMF_8),
        CALL_SEND_DTMF_9(STATE_CALL_SEND_DTMF_9),
        CALL_SEND_DTMF_A(STATE_CALL_SEND_DTMF_A),
        CALL_SEND_DTMF_B(STATE_CALL_SEND_DTMF_B),
        CALL_SEND_DTMF_C(STATE_CALL_SEND_DTMF_C),
        CALL_SEND_DTMF_D(STATE_CALL_SEND_DTMF_D),
        CALL_SEND_DTMF_ASTERISK(STATE_CALL_SEND_DTMF_ASTERISK),
        CALL_SEND_DTMF_POUND(STATE_CALL_SEND_DTMF_POUND),
        CALL_SEND_DTMF_END(STATE_CALL_SEND_DTMF_END),
        CALL_MENC(STATE_CALL_MENC),
        VU_TX(STATE_VU_TX),
        VU_RX(STATE_VU_RX),
        AUDIO_ERROR(STATE_AUDIO_ERROR),
        AUDIO_LATENCY_OUTGOING(STATE_AUDIO_LATENCY_OUTGOING),
        AUDIO_LATENCY_INCOMING(STATE_AUDIO_LATENCY_INCOMING),
        FAX_SUCCESS(STATE_FAX_SUCCESS),
        FAX_FAILED(STATE_FAX_FAILED),
        FAXMODE_AUDIO(STATE_FAXMODE_AUDIO),
        FAXMODE_T38(STATE_FAXMODE_T38),
        PHONE_ATTACHED(STATE_PHONE_ATTACHED),
        PHONE_DETACHED(STATE_PHONE_DETACHED),
        PHONE_SELECTED(STATE_PHONE_SELECTED),
        PHONE_PROPERTY_CHANGED(STATE_PHONE_PROPERTY_CHANGED),
        HANDSFREE_PROPERTY_CHANGED(STATE_HANDSFREE_PROPERTY_CHANGED),
        CALLVOLUME_CHANGED(STATE_CALLVOLUME_CHANGED),
        CALL_REMOVED(STATE_CALL_REMOVED),
        CALL_HELD(STATE_CALL_HELD),
        CALL_WAITING(STATE_CALL_WAITING),
        CALL_STATE_CHANGED(STATE_CALL_STATE_CHANGED),
        CALL_PROPERTY_CHANGED(STATE_CALL_PROPERTY_CHANGED),
        CALL_DISCONNECTED(STATE_CALL_DISCONNECTED),
        CALLMANAGER_PROPERTY_CHANGED(STATE_CALLMANAGER_PROPERTY_CHANGED),
        CALLMANAGER_BARRING_ACTIVE(STATE_CALLMANAGER_BARRING_ACTIVE),
        CALLMANAGER_FORWARDED(STATE_CALLMANAGER_FORWARDED);
    }
}
