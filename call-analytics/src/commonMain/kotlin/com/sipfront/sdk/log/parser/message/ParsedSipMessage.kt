package com.sipfront.sdk.log.parser.message

import com.sipfront.sdk.json.message.enums.MessageType

internal data class ParsedSipMessage(
    val sipPacket: String,
    val sdpPacket: String?,
    val status: String,
    val to: String,
    val from: String,
    val callId: String,
    val commandSequence: String,
    val contentLength: String,
    val messageType: MessageType.Sip
)
