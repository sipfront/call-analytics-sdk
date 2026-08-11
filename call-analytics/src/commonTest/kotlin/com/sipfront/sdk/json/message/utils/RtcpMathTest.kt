package com.sipfront.sdk.json.message.utils

import com.sipfront.sdk.json.JsonParser
import com.sipfront.sdk.json.enums.CallDirection
import com.sipfront.sdk.json.enums.MediaDirection
import com.sipfront.sdk.json.message.RtcpMessage
import kotlinx.serialization.json.jsonArray
import kotlinx.serialization.json.jsonObject
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertNotNull
import kotlin.test.assertNull

class RtcpMathTest {
    /**
     * Verifies that running per-call aggregates retain cumulative averages and rate calculations.
     *
     * @return Unit after all cumulative and interval values have been verified
     */
    @Test
    fun calculatesRunningAggregatesAndRates() {
        val firstMessage = createMessage(
            callId = "running-aggregates",
            timestamp = 1_000.0,
            rxPackets = 100L,
            txPackets = 200L,
            rxBytes = 1_000L,
            txBytes = 2_000L,
            rxLost = 5L,
            txLost = 8L,
            rxJitter = 10.0,
            txJitter = 20.0,
            rtt = 30.0
        )
        RtcpMath.recordRtcpMessage(firstMessage)

        val secondInterface = createMessage(
            callId = "running-aggregates",
            timestamp = 1_002.0,
            rxPackets = 140L,
            txPackets = 250L,
            rxBytes = 1_800L,
            txBytes = 3_000L,
            rxLost = 7L,
            txLost = 10L,
            rxJitter = 14.0,
            txJitter = 24.0,
            rtt = 34.0
        ).interfaces.single()
        val ingressRate = assertNotNull(secondInterface.ingressRate)
        val egressRate = assertNotNull(secondInterface.egressRate)

        assertEquals(12.0, secondInterface.ingress.jitterAverageMs)
        assertEquals(2L, secondInterface.ingress.jitterSamples)
        assertEquals(22.0, secondInterface.egress.jitterAverageMs)
        assertEquals(2L, secondInterface.egress.jitterSamples)
        assertEquals(32.0, secondInterface.egress.rttAverageMs)
        assertEquals(2L, secondInterface.egress.rttSamples)
        assertEquals(20L, ingressRate.packets)
        assertEquals(400L, ingressRate.bytes)
        assertEquals(1L, ingressRate.packetsLost)
        assertEquals(25L, egressRate.packets)
        assertEquals(500L, egressRate.bytes)
        assertEquals(1.0, egressRate.packetsLost)
        assertEquals(1L, egressRate.packetsLostSamples)
    }

    /**
     * Verifies that a new call does not use another call's counters or cumulative measurements.
     *
     * @return Unit after per-call isolation has been verified
     */
    @Test
    fun isolatesMeasurementStateByCallId() {
        val firstCallMessage = createMessage(
            callId = "first-call",
            timestamp = 2_000.0,
            rxPackets = 500L,
            txPackets = 600L,
            rxBytes = 5_000L,
            txBytes = 6_000L,
            rxLost = 10L,
            txLost = 12L,
            rxJitter = 50.0,
            txJitter = 60.0,
            rtt = 70.0
        )
        RtcpMath.recordRtcpMessage(firstCallMessage)

        val secondCallInterface = createMessage(
            callId = "second-call",
            timestamp = 2_001.0,
            rxPackets = 20L,
            txPackets = 30L,
            rxBytes = 200L,
            txBytes = 300L,
            rxLost = 1L,
            txLost = 2L,
            rxJitter = 5.0,
            txJitter = 6.0,
            rtt = 7.0
        ).interfaces.single()
        val ingressRate = assertNotNull(secondCallInterface.ingressRate)
        val egressRate = assertNotNull(secondCallInterface.egressRate)

        assertEquals(5.0, secondCallInterface.ingress.jitterAverageMs)
        assertEquals(1L, secondCallInterface.ingress.jitterSamples)
        assertEquals(6.0, secondCallInterface.egress.jitterAverageMs)
        assertEquals(1L, secondCallInterface.egress.jitterSamples)
        assertEquals(7.0, secondCallInterface.egress.rttAverageMs)
        assertEquals(1L, secondCallInterface.egress.rttSamples)
        assertEquals(0L, ingressRate.packets)
        assertNull(ingressRate.packetsLost)
        assertEquals(0L, egressRate.packets)
        assertNull(egressRate.packetsLost)
        assertNull(egressRate.packetsLostSamples)
    }

    /**
     * Verifies that unavailable RTP quality measurements are omitted instead of serialized as placeholder zeroes.
     *
     * @return Unit after all unavailable directional and legacy measurements have been verified
     */
    @Test
    fun omitsUnavailableQualityMeasurements() {
        val message = createMessage(
            callId = "unavailable-measurements",
            timestamp = 3_000.0,
            rxPackets = 0L,
            txPackets = 0L,
            rxBytes = 0L,
            txBytes = 0L,
        )
        val iface = message.interfaces.single()

        assertNull(iface.ingress.packetsLost)
        assertNull(iface.ingress.jitterAverageMs)
        assertNull(iface.egress.packetsLost)
        assertNull(iface.egress.jitterAverageMs)
        assertNull(iface.egress.rttAverageMs)
        assertNull(iface.ingressRate?.packetsLost)
        assertNull(iface.ingressRate?.jitterMs)
        assertNull(iface.egressRate?.packetsLost)
        assertNull(iface.egressRate?.jitterMs)
        assertNull(iface.egressRate?.rttMs)
        assertNull(iface.voipMetrics.mosAverage)

        val interfaceJson = JsonParser.json.parseToJsonElement(JsonParser.toString(message))
            .jsonObject.getValue("interfaces").jsonArray.single().jsonObject
        val ingressJson = interfaceJson.getValue("ingress").jsonObject
        val egressRateJson = interfaceJson.getValue("egress_rate").jsonObject
        val voipMetricsJson = interfaceJson.getValue("voip_metrics").jsonObject

        assertFalse("packets_lost" in ingressJson)
        assertFalse("jitter_average_ms" in ingressJson)
        assertFalse("packets_lost" in egressRateJson)
        assertFalse("packets_lost_samples" in egressRateJson)
        assertFalse("jitter_ms" in egressRateJson)
        assertFalse("jitter_samples" in egressRateJson)
        assertFalse("rtt_ms" in egressRateJson)
        assertFalse("rtt_samples" in egressRateJson)
        assertFalse("mos_average" in voipMetricsJson)
    }

    /**
     * Verifies that MOS requires and uses only the complete remotely reported egress RTCP measurements.
     *
     * @return Unit after egress-only MOS input selection and missing-input handling have been verified
     */
    @Test
    fun calculatesMosOnlyFromCompleteEgressRtcpMeasurements() {
        val firstMos = createMessage(
            callId = "mos-egress-first",
            timestamp = 4_000.0,
            rxPackets = 0L,
            txPackets = 0L,
            rxBytes = 0L,
            txBytes = 0L,
            rxLost = 999L,
            txLost = 3L,
            rxJitter = 999.0,
            txJitter = 20.0,
            rtt = 40.0,
        ).interfaces.single().voipMetrics.mosAverage
        val secondMos = createMessage(
            callId = "mos-egress-second",
            timestamp = 4_000.0,
            rxPackets = 0L,
            txPackets = 0L,
            rxBytes = 0L,
            txBytes = 0L,
            rxLost = 0L,
            txLost = 3L,
            rxJitter = 0.0,
            txJitter = 20.0,
            rtt = 40.0,
        ).interfaces.single().voipMetrics.mosAverage
        val missingEgressJitterMos = createMessage(
            callId = "mos-missing-egress-jitter",
            timestamp = 4_000.0,
            rxPackets = 0L,
            txPackets = 0L,
            rxBytes = 0L,
            txBytes = 0L,
            txLost = 3L,
            rtt = 40.0,
        ).interfaces.single().voipMetrics.mosAverage
        val zeroMosInputs = createMessage(
            callId = "mos-zero-inputs",
            timestamp = 4_000.0,
            rxPackets = 0L,
            txPackets = 0L,
            rxBytes = 0L,
            txBytes = 0L,
            txLost = 0L,
            txJitter = 0.0,
            rtt = 0.0,
        ).interfaces.single().voipMetrics.mosAverage

        assertNotNull(firstMos)
        assertEquals(firstMos, secondMos)
        assertNull(missingEgressJitterMos)
        assertNotNull(zeroMosInputs)
    }

    /**
     * Verifies that a repeated zero loss counter is a valid new sample even after an unavailable interval.
     *
     * @return Unit after the zero loss rate and its sample marker have been verified
     */
    @Test
    fun treatsRepeatedZeroPacketLossAsAValidSample() {
        val firstMessage = createMessage(
            callId = "zero-packet-loss",
            timestamp = 5_000.0,
            rxPackets = 0L,
            txPackets = 0L,
            rxBytes = 0L,
            txBytes = 0L,
            rxLost = 0L,
            txLost = 0L,
        )
        RtcpMath.recordRtcpMessage(firstMessage)

        val unavailableMessage = createMessage(
            callId = "zero-packet-loss",
            timestamp = 5_001.0,
            rxPackets = 0L,
            txPackets = 0L,
            rxBytes = 0L,
            txBytes = 0L,
        )
        RtcpMath.recordRtcpMessage(unavailableMessage)

        val egressRate = assertNotNull(
            createMessage(
                callId = "zero-packet-loss",
                timestamp = 5_002.0,
                rxPackets = 0L,
                txPackets = 0L,
                rxBytes = 0L,
                txBytes = 0L,
                rxLost = 0L,
                txLost = 0L,
            ).interfaces.single().egressRate
        )

        assertEquals(0.0, egressRate.packetsLost)
        assertEquals(1L, egressRate.packetsLostSamples)
    }

    /**
     * Creates an RTCP message with deterministic counters and measurements for a test call.
     *
     * @param callId unique call identifier used to select the running state
     * @param timestamp measurement timestamp in seconds
     * @param rxPackets cumulative received packet count
     * @param txPackets cumulative sent packet count
     * @param rxBytes cumulative received byte count
     * @param txBytes cumulative sent byte count
     * @param rxLost cumulative locally measured ingress packet-loss count, or `null` when unavailable
     * @param txLost cumulative remotely reported egress packet-loss count, or `null` when unavailable
     * @param rxJitter locally measured ingress jitter in milliseconds, or `null` when unavailable
     * @param txJitter remotely reported egress jitter in milliseconds, or `null` when unavailable
     * @param rtt remotely measured round-trip time in milliseconds, or `null` when unavailable
     * @return an RTCP message whose directional interface values are calculated from the supplied measurements
     */
    private fun createMessage(
        callId: String,
        timestamp: Double,
        rxPackets: Long,
        txPackets: Long,
        rxBytes: Long,
        txBytes: Long,
        rxLost: Long? = null,
        txLost: Long? = null,
        rxJitter: Double? = null,
        txJitter: Double? = null,
        rtt: Double? = null,
    ): RtcpMessage {
        return RtcpMessage(
            callId = callId,
            addressLocal = "local",
            addressRemote = "remote",
            addressRemoteDisplayName = "remote",
            callDirection = CallDirection.OUTGOING,
            audioDirection = MediaDirection.SEND_RECEIVE,
            videoDirection = MediaDirection.INACTIVE,
            rxPackets = rxPackets,
            txPackets = txPackets,
            rxBytes = rxBytes,
            txBytes = txBytes,
            rxLost = rxLost,
            txLost = txLost,
            rxJitter = rxJitter,
            txJitter = txJitter,
            rtt = rtt,
            timestamp = timestamp
        )
    }
}
