package com.sipfront.sdk.json.enums

/**
 * This is a JavaScript wrapper for [MessageType]
 *
 * Required because KMM cannot yet convert Enums to JavaScript code
 *
 * @since 1.0.6
 * @author Dominik Ridjic
 */
@Suppress("NON_EXPORTABLE_TYPE")
@OptIn(ExperimentalJsExport::class)
@JsExport
object MessageTypeJs {
    val RTCP = MessageType.Rtcp.RTCP
    val SIP_OUTGOING = MessageType.Sip.OUTGOING
    val SIP_INCOMING = MessageType.Sip.INCOMING
    val SDP_OUTGOING = MessageType.Sdp.OUTGOING
    val SDP_INCOMING = MessageType.Sdp.INCOMING
    val STATE_CREATE = MessageType.State.CREATE
    val STATE_REGISTER = MessageType.State.REGISTER
    val STATE_REGISTERING = MessageType.State.REGISTERING
    val STATE_UNREGISTERING = MessageType.State.UNREGISTERING
    val STATE_SHUTDOWN = MessageType.State.SHUTDOWN
    val STATE_EXIT = MessageType.State.EXIT
    val STATE_CALL_INCOMING = MessageType.State.CALL_INCOMING
    val STATE_CALL_OUTGOING = MessageType.State.CALL_OUTGOING
    val STATE_CALL_RINGING = MessageType.State.CALL_RINGING
    val STATE_CALL_ESTABLISHED = MessageType.State.CALL_ESTABLISHED
    val STATE_CALL_RTP_ESTABLISHED = MessageType.State.CALL_RTP_ESTABLISHED
    val STATE_CALL_ENDED_LOCAL = MessageType.State.CALL_ENDED_LOCAL
    val STATE_CALL_ENDED_REMOTE = MessageType.State.CALL_ENDED_REMOTE
    val STATE_CALL_REJECTED = MessageType.State.CALL_REJECTED
    val STATE_CALL_FAILED = MessageType.State.CALL_FAILED
    val STATE_CALL_CLOSED = MessageType.State.CALL_CLOSED
    val STATE_CALL_IN_PROGRESS = MessageType.State.CALL_IN_PROGRESS
}