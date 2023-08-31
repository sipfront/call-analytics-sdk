package com.sipfront.sdk.log.parser.packet

import com.sipfront.sdk.json.message.enums.MessageType
import com.sipfront.sdk.log.parser.message.ParsedSipMessage

internal class SipParser {
    companion object Regex {
        private const val SIP_PACKET =
            "(SIP|OPTIONS|REGISTER|SUBSCRIBE|NOTIFY|PUBLISH|INVITE|ACK|BYE|CANCEL|UPDATE|PRACK|MESSAGE|REFER)(\\ssip|/\\d\\.\\d\\s\\d{3})([\\S\\s]+(?=(From:|To:|Call-ID))){3}[\\S\\s]+Content-Length:.*"
        private const val FROM_ADDRESS = "(?<=From:\\s?<?sips?:)[.[^>;]]+"
        private const val TO_ADDRESS = "(?<=To:\\s?<?sips?:)[.[^>;]]+"
        private const val CALL_ID = "(?<=Call-ID:\\s).+"
        private const val RECEIVED = "received="
    }

    private val regexSipPacket = Regex(SIP_PACKET)
    private val regexFromAddress = Regex(FROM_ADDRESS)
    private val regexToAddress = Regex(TO_ADDRESS)
    private val regexCallId = Regex(CALL_ID)
    private val regexReceived = Regex(RECEIVED)
    private var localAddress: String? = null
    private var caller: String? = null
    private var callee: String? = null
    private var callIdRegister: String? = null
    private var callIdCall: String? = null
    private val sdpParser: SdpParser = SdpParser()

    fun parse(message: String): ParsedSipMessage? {
        getSipPacket(message)?.let { sipPacket ->
            parseProperties(sipPacket)
            return ParsedSipMessage(
                sipPacket = sipPacket,
                sdpPacket = getSdpPacket(message),
                localAdr = localAddress,
                caller = caller,
                callee = callee,
                callIdRegister = callIdRegister,
                callIdInvite = callIdCall,
                messageType = getMessageType(sipPacket)
            )
        } ?: run {
            return null
        }
    }

    private fun parseProperties(message: String) {
        if (isRegisterMessage(message)) {
            if (localAddress.isNullOrEmpty())
                localAddress = getFromAddress(message)
            if (callIdRegister.isNullOrEmpty())
                callIdRegister = getCallId(message)
            if (callIdRegister.isNullOrEmpty())
                callIdRegister = getCallId(message)
        } else if (isInviteMessage(message)) {
            if (caller.isNullOrEmpty())
                caller = getFromAddress(message)
            if (callee.isNullOrEmpty())
                callee = getToAddress(message)
            if (callIdCall.isNullOrEmpty())
                callIdCall = getCallId(message)
        }
    }

    private fun getSdpPacket(message: String): String? {
        return sdpParser.parse(message)?.sdpPacket ?: run { null }
    }

    private fun getSipPacket(message: String): String? {
        return regexSipPacket.find(message)?.value ?: run { null }
    }

    private fun getMessageType(message: String): MessageType.Sip {
        return regexReceived.find(message)?.let {
            MessageType.Sip.INCOMING
        } ?: run {
            MessageType.Sip.OUTGOING
        }
    }

    private fun getFromAddress(message: String): String? {
        return regexFromAddress.find(message)?.value ?: run { null }
    }

    private fun getToAddress(message: String): String? {
        return regexToAddress.find(message)?.value ?: run { null }
    }

    private fun getCallId(message: String): String? {
        return regexCallId.find(message)?.value ?: run { null }
    }

    private fun isRegisterMessage(message: String): Boolean {
        return message.startsWith("REGISTER")
    }

    private fun isInviteMessage(message: String): Boolean {
        return message.startsWith("INVITE")
    }
}