package com.sipfront.sdk.json.message.utils

import com.sipfront.sdk.CallAnalytics
import com.sipfront.sdk.json.message.*
import com.sipfront.sdk.json.message.Egress
import com.sipfront.sdk.json.message.EgressRate
import com.sipfront.sdk.json.message.Ingress
import com.sipfront.sdk.json.message.IngressRate
import com.sipfront.sdk.json.message.MediaStats
import com.sipfront.sdk.json.message.Rate
import com.sipfront.sdk.json.message.RtcpInterface
import com.sipfront.sdk.json.message.VoipMetrics
import com.sipfront.sdk.log.Log
import kotlin.math.roundToLong

/**
 * Here we calculate RTCP measurements based on the current and previous RTCP packets
 */
internal object RtcpMath {
    private const val R_FACTOR_BASE = 93.2
    private const val R_FACTOR_IMPACT_IN_MOS = 0.035
    private const val R_FACTOR_IMPACT_ON_QUALITY = 0.000007
    private const val R_FACTOR_LOWER_BOUND = 60.0
    private const val R_FACTOR_UPPER_BOUND = 100.0
    private const val MOS_FACTOR_BASE = 1.0
    private const val DELAY_IMPACT_FACTOR = 0.024
    private const val JITTER_IMPACT_FACTOR = 0.11

    @Throws(NoSuchElementException::class)
    internal fun createRtcpInterface(currentMsg: RtcpMessage): List<RtcpInterface> {
        // we need the previous RtcpMessage in order to calculate averages, if we cannot find any we return null
        val previousMsg = runCatching { CallAnalytics.rtcpCache.last() }.getOrNull()
        val elapsedTimeSeconds: Double = previousMsg?.let { (currentMsg.timestamp - previousMsg.timestamp) } ?: 0.0

        val packetsRxPerSecond: Double = calculateRate(currentMsg.rxPackets, previousMsg?.rxPackets, elapsedTimeSeconds)
        val packetsTxPerSecond: Double = calculateRate(currentMsg.txPackets, previousMsg?.txPackets, elapsedTimeSeconds)
        val bytesRxPerSecond: Double = calculateRate(currentMsg.rxBytes, previousMsg?.rxBytes, elapsedTimeSeconds)
        val bytesTxPerSecond: Double = calculateRate(currentMsg.txBytes, previousMsg?.txBytes, elapsedTimeSeconds)
        val lostRxPerSecond: Double = calculateRate(currentMsg.rxLost, previousMsg?.rxLost, elapsedTimeSeconds)
        val mos: Double = calculateMeanOpinionScore(currentMsg)

        /**
         * Some elements require a previous RtcpMessage to be available from whom to calculate averages.
         * These elements may be null in which case they are not encoded in the JSON
         */
        return listOf(
            RtcpInterface(
                rate = previousMsg?.let {
                    Rate(
                        packetsLost = lostRxPerSecond.roundToLong()
                    )
                },
                ingress = Ingress(
                    packets = currentMsg.rxPackets, bytes = currentMsg.rxBytes
                ),
                egress = Egress(
                    packets = currentMsg.txPackets, bytes = currentMsg.txBytes
                ),
                ingressRate = previousMsg?.let {
                    IngressRate(
                        packets = packetsRxPerSecond.roundToLong(),
                        bytes = bytesRxPerSecond.roundToLong()
                    )
                },
                egressRate = previousMsg?.let {
                    EgressRate(
                        packets = packetsTxPerSecond.roundToLong(),
                        bytes = bytesTxPerSecond.roundToLong()
                    )
                },
                mediaOutbound = MediaStats(
                    audioLevel = currentMsg.txAudioLevel,
                    totalAudioEnergy = currentMsg.txTotalAudioEnergy
                ),
                mediaInbound = MediaStats(
                    audioLevel = currentMsg.rxAudioLevel,
                    totalAudioEnergy = currentMsg.rxTotalAudioEnergy
                ),
                voipMetrics = VoipMetrics(
                    mosAverage = if (mos.isValid(VoipMetrics::mosAverage.name)) mos else 0.0,
                    jitterAverage = if (currentMsg.rxJitter.isValid(VoipMetrics::jitterAverage.name)) currentMsg.rxJitter else 0.0,
                    /**
                     * converting round-trip-time (rtt) to microsecond because that's what Sipfront Web API
                     * currently expects, but still keeping Sipfront Mobile SDK consistent by expecting
                     * millisecond across all values
                     */
                    rttDscAverage = if (currentMsg.rtt.isValid(VoipMetrics::rttDscAverage.name)) (currentMsg.rtt * 1000) else 0.0,
                    packetLossTotal = currentMsg.rxLost
                ),
            )
        )
    }

    private fun calculateRate(currentMsg: Long, previousMsg: Long?, elapsedTimeSeconds: Double): Double =
        previousMsg?.let { (currentMsg - it) / elapsedTimeSeconds } ?: 0.0

    private fun calculateMeanOpinionScore(rtcp: RtcpMessage): Double {
        return try {
            val rFactor =
                R_FACTOR_BASE - (DELAY_IMPACT_FACTOR * rtcp.rtt) - (JITTER_IMPACT_FACTOR * (rtcp.rtt / (rtcp.rtt + rtcp.rxLost)) * rtcp.rxJitter)
            MOS_FACTOR_BASE + (R_FACTOR_IMPACT_IN_MOS) * rFactor + (R_FACTOR_IMPACT_ON_QUALITY) * rFactor * (rFactor - R_FACTOR_LOWER_BOUND) * (R_FACTOR_UPPER_BOUND - rFactor)
        } catch (e: ArithmeticException) {
            throw ArithmeticException("Could not calculate MOS due to ArithmeticException")
        } catch (e: Exception) {
            Log.release().e("Failed to calculate MOS", e)
            0.0
        }
    }

    private fun Double.isValid(name: String): Boolean = if (this.isNaN()) {
        Log.release().e("Error: $name is Not-a-Number (NaN)!")
        false
    } else if (this.isInfinite()) {
        Log.release().e("Error: $name is Infinite!")
        false
    } else true
}