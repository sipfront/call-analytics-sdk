package com.sipfront.sdk.log.parser.message

import com.sipfront.sdk.json.message.enums.MessageType
import com.sipfront.sdk.utils.KotlinHelper

internal data class ParsedSipMessage(
    val sipPacket: String,
    val sdpPacket: String?,
    val localAdr: String?,
    val caller: String?,
    val callee: String?,
    val callIdRegister: String?,
    val callIdInvite: String?,
    val messageType: MessageType.Sip
) {
    fun getSipMessage(): String {
        KotlinHelper.multiLet(sipPacket, sdpPacket) { (sipPacket, sdpPacket) ->
            return "$sipPacket\n\n$sdpPacket"
        }
        return sipPacket
    }
}
