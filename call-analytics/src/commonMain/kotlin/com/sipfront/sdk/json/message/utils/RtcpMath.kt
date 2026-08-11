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
        val average: Double?,
        val samples: Long?,
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
        val rxLost: CounterMeasurement?,
        val txLost: CounterMeasurement?,
    )

    private data class CounterMeasurement(
        val timestamp: Double,
        val value: Long,
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
        val lostRxPerSecond: Long? = calculateCounterRate(
            currentMsg.rxLost,
            previousMeasurement?.rxLost,
            currentMsg.timestamp
        )?.roundToLong()
        val lostTxPerSecond: Double? = calculateCounterRate(
            currentMsg.txLost,
            previousMeasurement?.txLost,
            currentMsg.timestamp
        )
        val mos: Double? = calculateMeanOpinionScore(currentMsg)
        val txJitter: Double? = finiteOrNull(currentMsg.txJitter)
        val rxJitter: Double? = finiteOrNull(currentMsg.rxJitter)
        val rtt: Double? = finiteOrNull(currentMsg.rtt)
        val txJitterSummary: MeasurementSummary = calculateCumulativeMeasurement(currentMsg.txJitter, callState.txJitter)
        val rxJitterSummary: MeasurementSummary = calculateCumulativeMeasurement(currentMsg.rxJitter, callState.rxJitter)
        val rttSummary: MeasurementSummary = calculateCumulativeMeasurement(currentMsg.rtt, callState.rtt)
        val txJitterSamples: Long? = txJitter?.let { 1L }
        val rxJitterSamples: Long? = rxJitter?.let { 1L }
        val rttSamples: Long? = rtt?.let { 1L }
        val txPacketLossSamples: Long? = lostTxPerSecond?.let { 1L }
        val ingressPacketsLost = currentMsg.rxLost ?: previousMeasurement?.rxLost?.value
        val egressPacketsLost = currentMsg.txLost ?: previousMeasurement?.txLost?.value

        return listOf(
            RtcpInterface(
                rate = Rate(
                    packetsLost = lostRxPerSecond
                ),
                ingress = Ingress(
                    packets = currentMsg.rxPackets,
                    bytes = currentMsg.rxBytes,
                    packetsLost = ingressPacketsLost,
                    jitterAverageMs = rxJitterSummary.average,
                    jitterSamples = rxJitterSummary.samples
                ),
                egress = Egress(
                    packets = currentMsg.txPackets,
                    bytes = currentMsg.txBytes,
                    packetsLost = egressPacketsLost,
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
                    audioLevel = finiteOrZero(currentMsg.txAudioLevel),
                    totalAudioEnergy = finiteOrZero(currentMsg.txTotalAudioEnergy)
                ),
                mediaInbound = MediaStats(
                    audioLevel = finiteOrZero(currentMsg.rxAudioLevel),
                    totalAudioEnergy = finiteOrZero(currentMsg.rxTotalAudioEnergy)
                ),
                voipMetrics = VoipMetrics(
                    mosAverage = mos,
                    jitterAverage = txJitterSummary.average,
                    jitterMeasuredAverage = rxJitterSummary.average,
                    /**
                     * converting round-trip-time (rtt) to microsecond because that's what Sipfront Web API
                     * currently expects, but still keeping Sipfront Mobile SDK consistent by expecting
                     * millisecond across all values
                     */
                    rttDscAverage = rtt?.times(1000),
                    packetLossTotal = ingressPacketsLost
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
            val previousMeasurement = currentState.previousMeasurement
            states[message.callId] = currentState.copy(
                previousMeasurement = PreviousRtcpMeasurement(
                    timestamp = message.timestamp,
                    rxPackets = message.rxPackets,
                    txPackets = message.txPackets,
                    rxBytes = message.rxBytes,
                    txBytes = message.txBytes,
                    rxLost = message.rxLost?.let {
                        CounterMeasurement(timestamp = message.timestamp, value = it)
                    } ?: previousMeasurement?.rxLost,
                    txLost = message.txLost?.let {
                        CounterMeasurement(timestamp = message.timestamp, value = it)
                    } ?: previousMeasurement?.txLost
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
        currentValue: Double?,
        accumulator: MeasurementAccumulator
    ): MeasurementSummary {
        val accumulated = accumulateMeasurement(accumulator, currentValue)

        return MeasurementSummary(
            average = if (accumulated.samples > 0L) accumulated.sum / accumulated.samples else null,
            samples = accumulated.samples.takeIf { it > 0L }
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
        value: Double?
    ): MeasurementAccumulator {
        val finiteValue = finiteOrNull(value) ?: return accumulator
        return MeasurementAccumulator(
            sum = accumulator.sum + finiteValue,
            samples = accumulator.samples + 1L
        )
    }

    /**
     * Calculates a per-second rate between two available samples of the same cumulative counter.
     *
     * @param currentValue current cumulative counter value, or `null` when no new sample is available
     * @param previousMeasurement previous non-null counter value and its timestamp, or `null` without a baseline
     * @param currentTimestamp timestamp of [currentValue], in seconds
     * @return the per-second counter increase, including `0.0` for a valid zero delta, or `null` when unavailable
     */
    private fun calculateCounterRate(
        currentValue: Long?,
        previousMeasurement: CounterMeasurement?,
        currentTimestamp: Double,
    ): Double? {
        if (currentValue == null || previousMeasurement == null) return null
        val elapsedTimeSeconds = currentTimestamp - previousMeasurement.timestamp
        val delta = currentValue - previousMeasurement.value
        if (elapsedTimeSeconds <= 0.0 || delta < 0L) return null
        return finiteOrNull(delta / elapsedTimeSeconds)
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
        return finiteOrZero((currentVal - previousVal) / elapsedTimeSeconds)
    }

    /**
     * Calculates the estimated mean opinion score from the supplied RTCP measurement.
     *
     * @param rtcp RTCP measurement containing remotely reported egress jitter and packet loss plus RTCP RTT
     * @return the calculated mean opinion score, or `null` when any required value is unavailable or invalid
     */
    private fun calculateMeanOpinionScore(rtcp: RtcpMessage): Double? {
        val jitter = finiteOrNull(rtcp.txJitter) ?: return null
        val packetsLost = rtcp.txLost ?: return null
        val rtt = finiteOrNull(rtcp.rtt) ?: return null

        return try {
            val jitterWeightDenominator = rtt + packetsLost
            val jitterImpact = if (jitterWeightDenominator == 0.0) {
                0.0
            } else {
                JITTER_IMPACT_FACTOR * (rtt / jitterWeightDenominator) * jitter
            }
            val rFactor =
                R_FACTOR_BASE - (DELAY_IMPACT_FACTOR * rtt) - jitterImpact
            finiteOrNull(
                MOS_FACTOR_BASE + (R_FACTOR_IMPACT_IN_MOS) * rFactor +
                    (R_FACTOR_IMPACT_ON_QUALITY) * rFactor * (rFactor - R_FACTOR_LOWER_BOUND) *
                    (R_FACTOR_UPPER_BOUND - rFactor)
            )
        } catch (e: ArithmeticException) {
            throw ArithmeticException("Could not calculate MOS due to ArithmeticException")
        } catch (e: Exception) {
            Log.release().e("Failed to calculate MOS", e)
            null
        }
    }

    /**
     * Determines whether a floating-point measurement is finite.
     *
     * @param value measurement to validate, or `null` when it is unavailable
     * @return `true` when [value] is non-null and neither `NaN` nor infinite, otherwise `false`
     */
    private fun isValid(value: Double?): Boolean = value != null && !value.isNaN() && !value.isInfinite()

    /**
     * Returns a finite floating-point measurement and rejects missing or non-finite values.
     *
     * @param value measurement to validate, or `null` when it is unavailable
     * @return [value] when it is non-null and finite, otherwise `null`
     */
    private fun finiteOrNull(value: Double?): Double? = value?.takeIf { isValid(it) }

    /**
     * Returns a finite floating-point value and replaces a non-finite value with zero.
     *
     * @param value value to validate
     * @return [value] when it is finite, otherwise `0.0`
     */
    private fun finiteOrZero(value: Double): Double = finiteOrNull(value) ?: 0.0
}
