package com.sipfront.sdk.json.message.utils

import com.sipfront.sdk.json.enums.CallDirection
import com.sipfront.sdk.json.enums.MediaDirection
import com.sipfront.sdk.json.message.RtcpMessage
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotNull

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
        assertEquals(0L, ingressRate.packetsLost)
        assertEquals(0L, egressRate.packets)
        assertEquals(0.0, egressRate.packetsLost)
        assertEquals(0L, egressRate.packetsLostSamples)
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
     * @param rxLost cumulative locally measured ingress packet-loss count
     * @param txLost cumulative remotely reported egress packet-loss count
     * @param rxJitter locally measured ingress jitter in milliseconds
     * @param txJitter remotely reported egress jitter in milliseconds
     * @param rtt remotely measured round-trip time in milliseconds
     * @return an RTCP message whose directional interface values are calculated from the supplied measurements
     */
    private fun createMessage(
        callId: String,
        timestamp: Double,
        rxPackets: Long,
        txPackets: Long,
        rxBytes: Long,
        txBytes: Long,
        rxLost: Long,
        txLost: Long,
        rxJitter: Double,
        txJitter: Double,
        rtt: Double,
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
