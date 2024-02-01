package com.sipfront.sdk.pjsip.pjsua2

import com.sipfront.sdk.json.message.RtcpMessage
import com.sipfront.sdk.json.message.SipMessage
import com.sipfront.sdk.json.enums.MessageType
import com.sipfront.sdk.log.Log
import com.sipfront.sdk.pjsip.pjsua2.enums.PjMediaDir
import com.sipfront.sdk.pjsip.pjsua2.enums.PjMediaType
import com.sipfront.sdk.pjsip.pjsua2.enums.PjSipRole
import com.sipfront.sdk.pjsip.pjsua2.enums.PjsipEventIdE
import com.sipfront.sdk.pjsip.pjsua2.reflection.Call
import com.sipfront.sdk.pjsip.pjsua2.reflection.CallInfo
import com.sipfront.sdk.pjsip.pjsua2.reflection.CallMediaInfo
import com.sipfront.sdk.pjsip.pjsua2.reflection.CallMediaInfoVector
import com.sipfront.sdk.pjsip.pjsua2.reflection.MathStat
import com.sipfront.sdk.pjsip.pjsua2.reflection.OnCallTsxStateParam
import com.sipfront.sdk.pjsip.pjsua2.reflection.RtcpStat
import com.sipfront.sdk.pjsip.pjsua2.reflection.RtcpStreamStat
import com.sipfront.sdk.pjsip.pjsua2.reflection.SipEvent
import com.sipfront.sdk.pjsip.pjsua2.reflection.SipEventBody
import com.sipfront.sdk.pjsip.pjsua2.reflection.SipRxData
import com.sipfront.sdk.pjsip.pjsua2.reflection.SipTxData
import com.sipfront.sdk.pjsip.pjsua2.reflection.StreamStat
import com.sipfront.sdk.pjsip.pjsua2.reflection.TsxStateEvent
import com.sipfront.sdk.pjsip.pjsua2.reflection.TsxStateEventSrc
import com.sipfront.sdk.pjsip.pjsua2.utils.ReflectionHelper.getClass

internal object PjSipObjectParser {

    fun isCallActive(org_pjsip_pjsua2_Call: Any): Boolean {
        try {
            if (getClass(org_pjsip_pjsua2_Call, Call.className()) != null) {
                return Call.isActive(org_pjsip_pjsua2_Call)
            }
        } catch (ex: Exception) {
            Log.release().e("Failed to determine if Call is active", ex)
        }
        return false
    }

    fun getRtcpMessage(org_pjsip_pjsua2_Call: Any): RtcpMessage? {
        try {
            if (getClass(org_pjsip_pjsua2_Call, Call.className()) == null) {
                return null
            }
            if (Call.isActive(org_pjsip_pjsua2_Call)) {
                val callInfo = Call.getInfo(org_pjsip_pjsua2_Call)
                val callId: String = CallInfo.getCallIdString(callInfo)
                val sipAddress: String = CallInfo.getLocalUri(callInfo)
                val sipAddressRemote: String = CallInfo.getRemoteUri(callInfo)
                val role: PjSipRole = CallInfo.getRole(callInfo)

                val builder = RtcpMessage.Builder()
                builder.callId(callId)
                builder.addressLocal(sipAddress)
                builder.addressRemote(sipAddressRemote)
                builder.callDirection(role.toCallDirection())

                if (Call.hasMedia(org_pjsip_pjsua2_Call)) {
                    val callMediaInfoVector: Any = CallInfo.getCallMediaInfoVector(callInfo)
                    val size: Long = CallMediaInfoVector.getCallMediaInfoSize(callMediaInfoVector)
                    for (index in 0 until size) {
                        val callMediaInfo: Any =
                            CallMediaInfoVector.getCallMediaInfo(callMediaInfoVector, index.toInt())
                        val type: PjMediaType = CallMediaInfo.getCallMediaInfoType(callMediaInfo)
                        val dir: PjMediaDir = CallMediaInfo.getCallMediaInfoDir(callMediaInfo)
                        when (type) {
                            PjMediaType.PJMEDIA_TYPE_NONE -> {}
                            PjMediaType.PJMEDIA_TYPE_AUDIO -> builder.audioDirection(dir.toMediaDirection())
                            PjMediaType.PJMEDIA_TYPE_VIDEO -> builder.videoDirection(dir.toMediaDirection())
                        }
                    }

                    val streamStat = Call.getStreamStat(org_pjsip_pjsua2_Call, 0)
                    val rtcpStat = StreamStat.getRtcp(streamStat)
                    val rxRtcpStreamStat = RtcpStat.getRxStat(rtcpStat)
                    val rxJitterStat = RtcpStreamStat.getJitterUsec(rxRtcpStreamStat)
                    val rxJitter: Long = MathStat.getLast(rxJitterStat)
                    val rxReceived: Long = RtcpStreamStat.getPkt(rxRtcpStreamStat)
                    val rxLost: Long = RtcpStreamStat.getLoss(rxRtcpStreamStat)

                    builder.rxJitter(jitter = rxJitter.toDouble() / 1000)
                    builder.rxLost(lost = rxLost)
                    builder.rxPackets(packets = rxReceived)

                    val txRtcpStreamStat = RtcpStat.getTxStat(rtcpStat)
                    val txSent: Long = RtcpStreamStat.getPkt(txRtcpStreamStat)

                    builder.txPackets(packets = txSent)

                    val rttStat = RtcpStat.getRttUsec(rtcpStat)
                    val rtt: Long = MathStat.getLast(rttStat)

                    builder.rtt(rtt = rtt.toDouble() / 1000)
                }
                //Timber.e("Reflection: ${builder.build().toJson()}")
                return builder.build()
            }
        } catch (ex: Exception) {
            Log.release().e("Failed to get RtcpMessage", ex)
        }
        return null
    }

    fun getSipMessage(org_pjsip_pjsua2_OnCallTsxStateParam: Any): SipMessage? {
        try {
            if (getClass(
                    org_pjsip_pjsua2_OnCallTsxStateParam, OnCallTsxStateParam.className()
                ) == null
            ) {
                return null
            }
            val sipEvent = OnCallTsxStateParam.getE(org_pjsip_pjsua2_OnCallTsxStateParam)
            val sipEventBody = SipEvent.getBody(sipEvent)
            val tsxStateEvent = SipEventBody.getTsxState(sipEventBody)
            val pjsipEventIdE = PjsipEventIdE.valueOf(TsxStateEvent.getType(tsxStateEvent))
            val tsxStateEventSrc = TsxStateEvent.getSrc(tsxStateEvent)
            when (pjsipEventIdE) {
                PjsipEventIdE.PJSIP_EVENT_TX_MSG -> {
                    val tData = TsxStateEventSrc.getTdata(tsxStateEventSrc)
                    val sipMessage = SipTxData.getWholeMsg(tData)

                    return SipMessage.Builder().message(sipMessage).type(MessageType.Sip.OUTGOING).build()
                }

                PjsipEventIdE.PJSIP_EVENT_RX_MSG -> {
                    val rData = TsxStateEventSrc.getRdata(tsxStateEventSrc)
                    val sipMessage = SipRxData.getWholeMsg(rData)

                    return SipMessage.Builder().message(sipMessage).type(MessageType.Sip.INCOMING).build()
                }

                else -> return null
            }
        } catch (ex: Exception) {
            Log.release().e("Failed to get SipMessage", ex)
        }
        return null
    }
}