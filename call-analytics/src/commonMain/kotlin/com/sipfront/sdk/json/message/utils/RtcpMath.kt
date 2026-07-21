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

    /**
     * Creates the interface statistics exported with an RTCP message.
     *
     * @param currentMsg current RTCP measurement used to populate interval values and calculate cumulative values
     * @return a list containing the interface statistics derived from [currentMsg]
     */
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
        val lostTxPerSecond: Long = calculateRate(currentMsg.txLost, previousMsg?.txLost, elapsedTimeSeconds)
        val mos: Double = calculateMeanOpinionScore(currentMsg)
        val txJitter: Double = validOrNull(currentMsg.txJitter)
        val rxJitter: Double = validOrNull(currentMsg.rxJitter)
        val txJitterAverage: Double = calculateCumulativeAverage(currentMsg.txJitter) { it.txJitter }
        val rxJitterAverage: Double = calculateCumulativeAverage(currentMsg.rxJitter) { it.rxJitter }

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
                    bytes = currentMsg.rxBytes,
                    packetsLost = currentMsg.rxLost,
                    jitter = rxJitter
                ),
                egress = Egress(
                    packets = currentMsg.txPackets,
                    bytes = currentMsg.txBytes,
                    packetsLost = currentMsg.txLost,
                    jitter = txJitter
                ),
                ingressRate = IngressRate(
                    packets = packetsRxPerSecond,
                    bytes = bytesRxPerSecond,
                    packetsLost = lostRxPerSecond
                ),
                egressRate = EgressRate(
                    packets = packetsTxPerSecond,
                    bytes = bytesTxPerSecond,
                    packetsLost = lostTxPerSecond
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
                    jitterAverage = txJitterAverage,
                    jitterMeasuredAverage = rxJitterAverage,
                    /**
                     * converting round-trip-time (rtt) to microsecond because that's what Sipfront Web API
                     * currently expects, but still keeping Sipfront Mobile SDK consistent by expecting
                     * millisecond across all values
                     */
                    rttDscAverage = validOrNull(currentMsg.rtt * 1000),
                    packetLossTotal = currentMsg.rxLost
                ),
                voipMetricsInterval = VoipMetricsInterval(
                    jitter = txJitter,
                    jitterMeasured = rxJitter
                ),
            )
        )
    }

    /**
     * Calculates the cumulative average of the current value and all valid matching values in the RTCP cache.
     *
     * @param currentValue value from the current RTCP measurement
     * @param valueSelector selects the value to average from a cached RTCP measurement
     * @return the cumulative average, or `0.0` when no valid values are available
     */
    private fun calculateCumulativeAverage(
        currentValue: Double,
        valueSelector: (RtcpMessage) -> Double
    ): Double {
        var sum = 0.0
        var count = 0L

        if (isValid(currentValue)) {
            sum += currentValue
            count++
        }

        CallAnalytics.rtcpCache.forEach { message ->
            val value = valueSelector(message)
            if (isValid(value)) {
                sum += value
                count++
            }
        }

        return if (count > 0L) sum / count else 0.0
    }

    /**
     * Calculates a per-second rate from two cumulative counter values.
     *
     * @param currentVal current cumulative counter value
     * @param previousVal previous cumulative counter value, or `null` when no previous measurement is available
     * @param elapsedTimeSeconds elapsed time between the current and previous measurements, in seconds
     * @return the rounded per-second rate, or `0` when the rate cannot be calculated or did not increase
     */
    private fun calculateRate(currentVal: Long, previousVal: Long?, elapsedTimeSeconds: Double): Long {
        if (previousVal == null || elapsedTimeSeconds <= 0 || (currentVal - previousVal) <= 0L) return 0L
        return validOrNull((currentVal - previousVal) / elapsedTimeSeconds).roundToLong()
    }

    /**
     * Calculates the estimated mean opinion score from the supplied RTCP measurement.
     *
     * @param rtcp RTCP measurement containing RTT, packet loss, and locally measured jitter
     * @return the calculated mean opinion score, or `0.0` when an unexpected calculation error occurs
     */
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

    /**
     * Determines whether a floating-point measurement is finite.
     *
     * @param value measurement to validate
     * @return `true` when [value] is neither `NaN` nor infinite, otherwise `false`
     */
    private fun isValid(value: Double): Boolean = !value.isNaN() && !value.isInfinite()

    /**
     * Replaces a non-finite floating-point measurement with zero.
     *
     * @param value measurement to validate
     * @return [value] when it is finite, otherwise `0.0`
     */
    private fun validOrNull(value: Double): Double = if (isValid(value)) value else 0.0
}
