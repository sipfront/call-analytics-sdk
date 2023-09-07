package com.sipfront.sdk.json.message.utils

import com.sipfront.sdk.CallAnalytics
import com.sipfront.sdk.json.message.*
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
        // we need the previous RtcpMessage in order to calculate averages if we cannot find any we return null
        val previousMsg = runCatching { CallAnalytics.rtcpCache.last() }.getOrNull()
        val elapsedTimeSeconds: Double = previousMsg?.let { (currentMsg.timestamp - previousMsg.timestamp) } ?: 0.0

        val packetsRxPerSecond: Long = calculateRate(currentMsg.rxPackets, previousMsg?.rxPackets, elapsedTimeSeconds)
        val packetsTxPerSecond: Long = calculateRate(currentMsg.txPackets, previousMsg?.txPackets, elapsedTimeSeconds)
        val bytesRxPerSecond: Long = calculateRate(currentMsg.rxBytes, previousMsg?.rxBytes, elapsedTimeSeconds)
        val bytesTxPerSecond: Long = calculateRate(currentMsg.txBytes, previousMsg?.txBytes, elapsedTimeSeconds)
        val lostRxPerSecond: Long = calculateRate(currentMsg.rxLost, previousMsg?.rxLost, elapsedTimeSeconds)
        val mos: Double = calculateMeanOpinionScore(currentMsg)

        /**
         * Some elements require a previous RtcpMessage to be available from whom to calculate averages.
         * These elements may be null in which case they are not encoded in the JSON
         */
        return listOf(
            RtcpInterface(
                rate = Rate(
                    packetsLost = lostRxPerSecond
                ),
                ingress = Ingress(
                    packets = currentMsg.rxPackets,
                    bytes = currentMsg.rxBytes
                ),
                egress = Egress(
                    packets = currentMsg.txPackets,
                    bytes = currentMsg.txBytes
                ),
                ingressRate = IngressRate(
                    packets = packetsRxPerSecond,
                    bytes = bytesRxPerSecond
                ),
                egressRate = EgressRate(
                    packets = packetsTxPerSecond,
                    bytes = bytesTxPerSecond
                ),
                mediaOutbound = MediaStats(
                    audioLevel = validOrNull(currentMsg.txAudioLevel),
                    totalAudioEnergy = validOrNull(currentMsg.txTotalAudioEnergy)
                ),
                mediaInbound = MediaStats(
                    audioLevel = validOrNull(currentMsg.rxAudioLevel),
                    totalAudioEnergy = validOrNull(currentMsg.rxTotalAudioEnergy)
                ),
                voipMetrics = VoipMetrics(
                    mosAverage = validOrNull(mos),
                    jitterAverage = validOrNull(currentMsg.rxJitter),
                    /**
                     * converting round-trip-time (rtt) to microsecond because that's what Sipfront Web API
                     * currently expects, but still keeping Sipfront Mobile SDK consistent by expecting
                     * millisecond across all values
                     */
                    rttDscAverage = validOrNull(currentMsg.rtt * 1000),
                    packetLossTotal = currentMsg.rxLost
                ),
            )
        )
    }

    private fun calculateRate(currentVal: Long, previousVal: Long?, elapsedTimeSeconds: Double): Long {
        if (previousVal == null || elapsedTimeSeconds <= 0 || (currentVal - previousVal) == 0L) return 0L
        return validOrNull((currentVal - previousVal) / elapsedTimeSeconds).roundToLong()
    }

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

    private fun isValid(value: Double): Boolean = !value.isNaN() && !value.isInfinite()

    private fun validOrNull(value: Double): Double = if (isValid(value)) value else 0.0
}