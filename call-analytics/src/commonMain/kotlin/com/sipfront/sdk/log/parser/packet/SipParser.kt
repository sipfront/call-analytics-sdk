package com.sipfront.sdk.log.parser.packet

import com.sipfront.sdk.json.message.enums.MessageType
import com.sipfront.sdk.log.Log
import com.sipfront.sdk.log.parser.message.ParsedSipMessage

internal class SipParser {
    companion object Regex {
        // All SIP methods we match
        private const val METHODS =
            """OPTIONS|REGISTER|SUBSCRIBE|NOTIFY|PUBLISH|INVITE|ACK|BYE|CANCEL|UPDATE|PRACK|MESSAGE|REFER"""

        // Various repeating substrings in the Regex
        private const val TYPE = """sips?|tel"""
        private const val ANY = """[\S\s]"""
        private const val SIP_VERSION = """SIP/\d\.\d"""

        // Positive lookaheads, all of those must be found in the message to be a valid SIP packet
        private const val STATUS =
            """(?=$ANY*((?:$METHODS)\s(?:sips?|tel:)\S*\s$SIP_VERSION|$SIP_VERSION\s\d{3}\s\S+))"""
        private const val FROM = """(?=$ANY*\n(?:From|f):.*(?:$TYPE):([^>\s;]*))"""
        private const val TO = """(?=$ANY*\n(?:To|t):.*(?:$TYPE):([^>\s;]*))"""
        private const val CALL_ID = """(?=$ANY*\n(?:Call-ID|i):\s(\S*))"""
        private const val CSEQ = """(?=$ANY*\nCSeq:\s(\d*\s[A-Z]+))"""
        private const val CLEN = """(?=$ANY*\n(?:Content-Length|l):\s(\d+))"""
        private const val POSITIVE_LOOKAHEADS = STATUS + FROM + TO + CALL_ID + CSEQ + CLEN

        // What we want to match, everything after the first found lookahead (usually STATUS)
        private const val MATCH = """$ANY+"""

        // The complete Regex for matching a SIP packet
        private const val SIP_PACKET = POSITIVE_LOOKAHEADS + MATCH

        // Used to determine if the SIP paket is incoming or outgoing
        private const val RECEIVED = "received="
    }

    private val regexSipPacket = Regex(SIP_PACKET)
    private val regexReceived = Regex(RECEIVED)
    private val sdpParser: SdpParser = SdpParser()

    fun parse(message: String): ParsedSipMessage? =
        try {
            regexSipPacket.find(message)?.let { matchResult ->
                val sipPacket = matchResult.value
                ParsedSipMessage(
                    sipPacket = sipPacket,
                    sdpPacket = getSdpPacket(sipPacket),
                    status = matchResult.groupValues[1],
                    from = matchResult.groupValues[2],
                    to = matchResult.groupValues[3],
                    callId = matchResult.groupValues[4],
                    commandSequence = matchResult.groupValues[5],
                    contentLength = matchResult.groupValues[6],
                    messageType = getMessageType(sipPacket)
                )
            }
        } catch (ex: Exception) {
            Log.release().e("Failed to parse SIP packet:\n$message", ex)
            null
        }

    private fun getSdpPacket(message: String): String? = sdpParser.parse(message)?.sdpPacket ?: run { null }

    private fun getMessageType(message: String): MessageType.Sip =
        regexReceived.find(message)?.let {
            MessageType.Sip.INCOMING
        } ?: run {
            MessageType.Sip.OUTGOING
        }
}