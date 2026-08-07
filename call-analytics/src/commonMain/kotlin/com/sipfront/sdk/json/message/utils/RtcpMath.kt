package com.sipfront.sdk.json.message.utils

import co.touchlab.stately.collections.ConcurrentMutableMap
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

    private data class MeasurementSummary(
        val average: Double,
        val samples: Long,
    )

    private data class MeasurementAccumulator(
        val sum: Double = 0.0,
        val samples: Long = 0L,
    )

    private data class PreviousRtcpMeasurement(
        val timestamp: Double,
        val rxPackets: Long,
        val txPackets: Long,
        val rxBytes: Long,
        val txBytes: Long,
        val rxLost: Long,
        val txLost: Long,
    )

    private data class RtcpCallState(
        val previousMeasurement: PreviousRtcpMeasurement? = null,
        val txJitter: MeasurementAccumulator = MeasurementAccumulator(),
        val rxJitter: MeasurementAccumulator = MeasurementAccumulator(),
        val rtt: MeasurementAccumulator = MeasurementAccumulator(),
    )

    private val callStates = ConcurrentMutableMap<String, RtcpCallState>()

    /**
     * Creates the interface statistics exported with an RTCP message.
     *
     * @param currentMsg current RTCP measurement used to populate interval values and calculate cumulative values
     * @return a list containing the interface statistics derived from [currentMsg]
    */
    internal fun createRtcpInterface(currentMsg: RtcpMessage): List<RtcpInterface> {
        val callState = callStates[currentMsg.callId] ?: RtcpCallState()
        val previousMeasurement = callState.previousMeasurement
        val elapsedTimeSeconds: Double = previousMeasurement?.let {
            currentMsg.timestamp - it.timestamp
        } ?: 0.0

        val packetsRxPerSecond: Long = calculateRate(
            currentMsg.rxPackets,
            previousMeasurement?.rxPackets,
            elapsedTimeSeconds
        )
        val packetsTxPerSecond: Long = calculateRate(
            currentMsg.txPackets,
            previousMeasurement?.txPackets,
            elapsedTimeSeconds
        )
        val bytesRxPerSecond: Long = calculateRate(
            currentMsg.rxBytes,
            previousMeasurement?.rxBytes,
            elapsedTimeSeconds
        )
        val bytesTxPerSecond: Long = calculateRate(
            currentMsg.txBytes,
            previousMeasurement?.txBytes,
            elapsedTimeSeconds
        )
        val lostRxPerSecond: Long = calculateRate(
            currentMsg.rxLost,
            previousMeasurement?.rxLost,
            elapsedTimeSeconds
        )
        val lostTxPerSecond: Double = calculateFractionalRate(
            currentMsg.txLost,
            previousMeasurement?.txLost,
            elapsedTimeSeconds
        )
        val mos: Double = calculateMeanOpinionScore(currentMsg)
        val txJitter: Double = validOrNull(currentMsg.txJitter)
        val rxJitter: Double = validOrNull(currentMsg.rxJitter)
        val rtt: Double = validOrNull(currentMsg.rtt)
        val txJitterSummary: MeasurementSummary = calculateCumulativeMeasurement(currentMsg.txJitter, callState.txJitter)
        val rxJitterSummary: MeasurementSummary = calculateCumulativeMeasurement(currentMsg.rxJitter, callState.rxJitter)
        val rttSummary: MeasurementSummary = calculateCumulativeMeasurement(currentMsg.rtt, callState.rtt)
        val txJitterSamples: Long = if (isValid(currentMsg.txJitter)) 1L else 0L
        val rxJitterSamples: Long = if (isValid(currentMsg.rxJitter)) 1L else 0L
        val rttSamples: Long = if (isValid(currentMsg.rtt)) 1L else 0L
        val txPacketLossSamples: Long = if (
            previousMeasurement != null &&
            elapsedTimeSeconds > 0.0 &&
            currentMsg.txLost >= previousMeasurement.txLost
        ) {
            1L
        } else {
            0L
        }

        return listOf(
            RtcpInterface(
                rate = Rate(
                    packetsLost = lostRxPerSecond
                ),
                ingress = Ingress(
                    packets = currentMsg.rxPackets,
                    bytes = currentMsg.rxBytes,
                    packetsLost = currentMsg.rxLost,
                    jitterAverageMs = rxJitterSummary.average,
                    jitterSamples = rxJitterSummary.samples
                ),
                egress = Egress(
                    packets = currentMsg.txPackets,
                    bytes = currentMsg.txBytes,
                    packetsLost = currentMsg.txLost,
                    jitterAverageMs = txJitterSummary.average,
                    jitterSamples = txJitterSummary.samples,
                    rttAverageMs = rttSummary.average,
                    rttSamples = rttSummary.samples
                ),
                ingressRate = IngressRate(
                    packets = packetsRxPerSecond,
                    bytes = bytesRxPerSecond,
                    packetsLost = lostRxPerSecond,
                    jitterMs = rxJitter,
                    jitterSamples = rxJitterSamples
                ),
                egressRate = EgressRate(
                    packets = packetsTxPerSecond,
                    bytes = bytesTxPerSecond,
                    packetsLost = lostTxPerSecond,
                    packetsLostSamples = txPacketLossSamples,
                    jitterMs = txJitter,
                    jitterSamples = txJitterSamples,
                    rttMs = rtt,
                    rttSamples = rttSamples
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
                    jitterAverage = txJitterSummary.average,
                    jitterMeasuredAverage = rxJitterSummary.average,
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
     * Records one sent RTCP measurement in the running state for its call.
     *
     * @param message sent RTCP message whose counters become the rate baseline and whose finite measurements are
     * added to the cumulative aggregates
     * @return Unit after the state for [message]'s call has been updated
     */
    internal fun recordRtcpMessage(message: RtcpMessage) {
        callStates.block { states ->
            val currentState = states[message.callId] ?: RtcpCallState()
            states[message.callId] = currentState.copy(
                previousMeasurement = PreviousRtcpMeasurement(
                    timestamp = message.timestamp,
                    rxPackets = message.rxPackets,
                    txPackets = message.txPackets,
                    rxBytes = message.rxBytes,
                    txBytes = message.txBytes,
                    rxLost = message.rxLost,
                    txLost = message.txLost
                ),
                txJitter = accumulateMeasurement(currentState.txJitter, message.txJitter),
                rxJitter = accumulateMeasurement(currentState.rxJitter, message.rxJitter),
                rtt = accumulateMeasurement(currentState.rtt, message.rtt)
            )
        }
    }

    /**
     * Calculates a cumulative summary by adding the current value to a call's existing aggregate.
     *
     * @param currentValue value from the current RTCP measurement
     * @param accumulator running sum and sample count from previously sent messages for the same call
     * @return cumulative average and sample count including [currentValue] when it is finite
     */
    private fun calculateCumulativeMeasurement(
        currentValue: Double,
        accumulator: MeasurementAccumulator
    ): MeasurementSummary {
        val accumulated = accumulateMeasurement(accumulator, currentValue)

        return MeasurementSummary(
            average = if (accumulated.samples > 0L) accumulated.sum / accumulated.samples else 0.0,
            samples = accumulated.samples
        )
    }

    /**
     * Adds one finite measurement to an immutable running accumulator.
     *
     * @param accumulator running sum and sample count to update
     * @param value measurement to add when finite
     * @return an updated accumulator, or [accumulator] unchanged when [value] is not finite
     */
    private fun accumulateMeasurement(
        accumulator: MeasurementAccumulator,
        value: Double
    ): MeasurementAccumulator {
        if (!isValid(value)) return accumulator
        return MeasurementAccumulator(
            sum = accumulator.sum + value,
            samples = accumulator.samples + 1L
        )
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
        return calculateFractionalRate(currentVal, previousVal, elapsedTimeSeconds).roundToLong()
    }

    /**
     * Calculates a fractional per-second rate from two cumulative counter values.
     *
     * @param currentVal current cumulative counter value
     * @param previousVal previous cumulative counter value, or `null` when no previous measurement is available
     * @param elapsedTimeSeconds elapsed time between the current and previous measurements, in seconds
     * @return the per-second rate, or `0.0` when the rate cannot be calculated or did not increase
     */
    private fun calculateFractionalRate(
        currentVal: Long,
        previousVal: Long?,
        elapsedTimeSeconds: Double
    ): Double {
        if (previousVal == null || elapsedTimeSeconds <= 0 || (currentVal - previousVal) <= 0L) return 0.0
        return validOrNull((currentVal - previousVal) / elapsedTimeSeconds)
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
