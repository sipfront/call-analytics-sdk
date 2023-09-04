package com.sipfront.sdk.log.parser

import com.sipfront.sdk.CallAnalytics
import com.sipfront.sdk.json.message.SdpMessage
import com.sipfront.sdk.json.message.SipMessage
import com.sipfront.sdk.json.message.enums.MessageType
import com.sipfront.sdk.log.Log
import com.sipfront.sdk.log.parser.message.ParsedSdpMessage
import com.sipfront.sdk.log.parser.message.ParsedSipMessage
import com.sipfront.sdk.log.parser.packet.SdpParser
import com.sipfront.sdk.log.parser.packet.SipParser
import com.sipfront.sdk.utils.DispatcherProvider
import kotlinx.coroutines.*

internal class LogParser {
    companion object {
        private const val DEBUG_LOG_PREFIX: String = "Parsed Sip/Sdp Message:"
        private const val REGEX_TIMESTAMP: String = "^\\[\\s\\d{2}-\\d{2}\\s\\d{2}:\\d{2}:\\d{2}\\.\\d{3}.*"
    }

    private val regexTimestamp: Regex = Regex(REGEX_TIMESTAMP)
    private val sipParser: SipParser = SipParser()
    private val sdpParser: SdpParser = SdpParser()

    // Custom scope for collecting logs on IO threads.
    private val scope = CoroutineScope(Job() + DispatcherProvider.IO)
    private var job: Job? = null
    private val buffer: StringBuilder = StringBuilder()
    private val sipCache: LinkedHashMap<Int, ParsedSipMessage> = LinkedHashMap()
    private val sdpCache: LinkedHashMap<Int, ParsedSdpMessage> = LinkedHashMap()


    fun start() {
        try {
            Log.debug()?.i("Start reading SIP traces using Logcat")
            job = scope.launch(DispatcherProvider.IO) {
                processLogs { line ->
                    // Check whether this job is cancelled, since a coroutine must
                    // cooperate to be cancellable.
                    ensureActive()
                    // If line starts with a timestamp we know that a new line has been printed.
                    // Now we can check the buffer for SIP/SDP messages and afterwards clear
                    // the buffer and continue with the next iteration
                    if (line.matches(regexTimestamp)) {
                        val logLine = buffer.toString()
                        if (!parseSip(logLine)) parseSdp(logLine)
                        clearBuffer()
                    } else {
                        buffer.append("$line\n")
                    }
                }
            }
        } catch (cancellation: CancellationException) {
            Log.debug()?.i("LogParser stopped regularly")
        } catch (exception: Exception) {
            Log.release().e("Failed to start LogParser", exception)
        }
    }

    fun stop() {
        Log.debug()?.i("Stop reading SIP traces using Logcat")
        MainScope().launch {
            // Cancel the job and wait for its completion on main thread.
            job?.cancelAndJoin()
            job = null
            sipCache.clear()
            sdpCache.clear()
            clearBuffer()
        }
    }

    fun isRunning(): Boolean {
        return job?.isActive ?: false
    }

    private fun parseSip(logLine: String): Boolean {
        sipParser.parse(logLine)?.let { parsed: ParsedSipMessage ->
            if (isDuplicate(parsed)) {
                return false
            } else {
                cache(parsed)
            }
            Log.debug()
                ?.v("$DEBUG_LOG_PREFIX ${parsed.getSipMessage()}\n\nLocal: ${parsed.localAdr}\nCaller: ${parsed.caller}\nCallee: ${parsed.callee}\nCall-ID Register: ${parsed.callIdRegister}\nCall-ID Call: ${parsed.callIdInvite}")
            CallAnalytics.sendSip(
                msg = SipMessage.Builder().message(parsed.getSipMessage()).type(parsed.messageType).build()
            )
            return true
        }
        return false
    }

    private fun parseSdp(logLine: String): Boolean {
        sdpParser.parse(logLine)?.let { parsed: ParsedSdpMessage ->
            if (isDuplicate(parsed)) {
                return false
            } else {
                cache(parsed)
            }
            Log.debug()?.v("$DEBUG_LOG_PREFIX ${parsed.sdpPacket}")
            CallAnalytics.sendSdp(
                msg = SdpMessage.Builder().message(parsed.sdpPacket)
                    /**
                     * We have no info in SDP packets where they are coming from, therefore to prevent
                     * an Exception when building the SdpMessage we set messageType as OUTGOING
                     */
                    .type(MessageType.Sdp.OUTGOING).build()
            )
            return true
        }
        return false
    }

    private fun cache(message: Any) {
        when (message) {
            is ParsedSipMessage -> {
                sipCache[message.hashCode()] = message
                // If SIP contains SDP caching SIP alone is not sufficient because the SDP parser will still
                // detect SDP that hasn't been cached if we print the SIP message to Log. Therefore we
                // additionally store the SDP message in cache
                message.sdpPacket?.let { sdpPacket ->
                    cache(ParsedSdpMessage(sdpPacket))
                }
            }

            is ParsedSdpMessage -> {
                sdpCache[message.hashCode()] = message
            }
        }
    }

    private fun isDuplicate(message: Any): Boolean {
        return when (message) {
            is ParsedSipMessage -> {
                sipCache.containsKey(message.hashCode())
            }

            is ParsedSdpMessage -> {
                sdpCache.containsKey(message.hashCode())
            }

            else -> {
                throw IllegalArgumentException("Message is not of type SIP/SDP")
            }
        }
    }

    private fun clearBuffer() {
        buffer.clear()
    }
}

internal expect fun processLogs(processLogLine: (String) -> Unit)