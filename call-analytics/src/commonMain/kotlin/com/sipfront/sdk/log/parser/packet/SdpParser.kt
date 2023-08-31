package com.sipfront.sdk.log.parser.packet

import com.sipfront.sdk.log.parser.message.ParsedSdpMessage

internal class SdpParser {
    companion object Regex {
        private const val SDP_PACKET = "v=.*\\so=.*\\ss=.*\\s([iuecpbzkatrm]=.*\\s)+"
    }

    private val regexSdpPacket = Regex(SDP_PACKET)

    fun parse(message: String): ParsedSdpMessage? {
        getSdpPacket(message)?.let { sdpPacket ->
            return ParsedSdpMessage(
                sdpPacket = sdpPacket
            )
        } ?: run {
            return null
        }
    }

    private fun getSdpPacket(message: String): String? {
        regexSdpPacket.find(message)?.let {
            return it.value
        } ?: run {
            return null
        }
    }
}