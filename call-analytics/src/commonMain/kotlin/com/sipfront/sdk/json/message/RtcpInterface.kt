package com.sipfront.sdk.json.message

import com.sipfront.sdk.BuildKonfig
import com.sipfront.sdk.json.JsonKeys
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class RtcpProducer(
    @SerialName(JsonKeys.Rtcp.Producer.name) val name: String = "call-analytics-sdk",
    @SerialName(JsonKeys.Rtcp.Producer.version) val version: String = BuildKonfig.VERSION_CODE,
)

@Serializable
internal data class RtcpInterface(
    @SerialName(JsonKeys.Rtcp.Interface.name) val name: String = "external",
    @SerialName(JsonKeys.Rtcp.Interface.rate) val rate: Rate?,
    @SerialName(JsonKeys.Rtcp.Interface.ingress) val ingress: Ingress,
    @SerialName(JsonKeys.Rtcp.Interface.egress) val egress: Egress,
    @SerialName(JsonKeys.Rtcp.Interface.ingressRate) val ingressRate: IngressRate?,
    @SerialName(JsonKeys.Rtcp.Interface.egressRate) val egressRate: EgressRate?,
    @SerialName(JsonKeys.Rtcp.Interface.voipMetrics) val voipMetrics: VoipMetrics,
    @SerialName(JsonKeys.Rtcp.Interface.voipMetricsInterval) val voipMetricsInterval: VoipMetricsInterval,
    @SerialName(JsonKeys.Rtcp.Interface.mediaOutbound) val mediaOutbound: MediaStats,
    @SerialName(JsonKeys.Rtcp.Interface.mediaInbound) val mediaInbound: MediaStats,
)

@Serializable
internal data class Rate(
    /**
     * Packets per second lost since the last measurement interval, or `null` when no new measurement is available.
     */
    @SerialName(JsonKeys.Rtcp.Interface.Rate.packetsLost) val packetsLost: Long?
)

@Serializable
internal data class Ingress(
    /**
     * Total number of received packets
     */
    @SerialName(JsonKeys.Rtcp.Interface.Ingress.packets) val packets: Long,
    /**
     * Total number of received bytes
     */
    @SerialName(JsonKeys.Rtcp.Interface.Ingress.bytes) val bytes: Long,
    /**
     * Total number of packets lost on ingress
     */
    @SerialName(JsonKeys.Rtcp.Interface.Ingress.packetsLost) val packetsLost: Long?,
    /**
     * Cumulative average of locally measured jitter for received RTP packets, in milliseconds.
     */
    @SerialName(JsonKeys.Rtcp.Interface.Ingress.jitterAverageMs) val jitterAverageMs: Double?,
    /**
     * Total number of locally measured ingress jitter samples included in [jitterAverageMs].
     */
    @SerialName(JsonKeys.Rtcp.Interface.Ingress.jitterSamples) val jitterSamples: Long?,
)

@Serializable
internal data class Egress(
    /**
     * Total number of sent packets
     */
    @SerialName(JsonKeys.Rtcp.Interface.Egress.packets) val packets: Long,
    /**
     * Total number of sent bytes
     */
    @SerialName(JsonKeys.Rtcp.Interface.Egress.bytes) val bytes: Long,
    /**
     * Total number of packets lost on egress
     */
    @SerialName(JsonKeys.Rtcp.Interface.Egress.packetsLost) val packetsLost: Long?,
    /**
     * Cumulative average of remotely reported jitter for RTP packets sent locally, in milliseconds.
     */
    @SerialName(JsonKeys.Rtcp.Interface.Egress.jitterAverageMs) val jitterAverageMs: Double?,
    /**
     * Total number of remotely reported egress jitter samples included in [jitterAverageMs].
     */
    @SerialName(JsonKeys.Rtcp.Interface.Egress.jitterSamples) val jitterSamples: Long?,
    /**
     * Cumulative average of remotely measured round-trip-time samples, in milliseconds.
     */
    @SerialName(JsonKeys.Rtcp.Interface.Egress.rttAverageMs) val rttAverageMs: Double?,
    /**
     * Total number of egress round-trip-time samples included in [rttAverageMs].
     */
    @SerialName(JsonKeys.Rtcp.Interface.Egress.rttSamples) val rttSamples: Long?,
)

@Serializable
internal data class IngressRate(
    /**
     * Packets per second received since the last measurement interval
     */
    @SerialName(JsonKeys.Rtcp.Interface.IngressRate.packets) val packets: Long,
    /**
     * Bytes per second received since the last measurement interval
     */
    @SerialName(JsonKeys.Rtcp.Interface.IngressRate.bytes) val bytes: Long,
    /**
     * Packets per second lost on ingress since the last measurement interval
     */
    @SerialName(JsonKeys.Rtcp.Interface.IngressRate.packetsLost) val packetsLost: Long?,
    /**
     * Locally measured ingress jitter during the current reporting interval, in milliseconds.
     */
    @SerialName(JsonKeys.Rtcp.Interface.IngressRate.jitterMs) val jitterMs: Double?,
    /**
     * Number of locally measured ingress jitter samples in the current reporting interval.
     */
    @SerialName(JsonKeys.Rtcp.Interface.IngressRate.jitterSamples) val jitterSamples: Long?,
)

@Serializable
internal data class EgressRate(
    /**
     * Packets per second sent since the last measurement interval
     */
    @SerialName(JsonKeys.Rtcp.Interface.EgressRate.packets) val packets: Long,
    /**
     * Bytes per second sent since the last measurement interval
     */
    @SerialName(JsonKeys.Rtcp.Interface.EgressRate.bytes) val bytes: Long,
    /**
     * Packets per second lost on egress since the last measurement interval
     */
    @SerialName(JsonKeys.Rtcp.Interface.EgressRate.packetsLost) val packetsLost: Double?,
    /**
     * Number of remotely reported egress packet-loss samples in the current reporting interval.
     */
    @SerialName(JsonKeys.Rtcp.Interface.EgressRate.packetsLostSamples) val packetsLostSamples: Long?,
    /**
     * Remotely reported egress jitter during the current reporting interval, in milliseconds.
     */
    @SerialName(JsonKeys.Rtcp.Interface.EgressRate.jitterMs) val jitterMs: Double?,
    /**
     * Number of remotely reported egress jitter samples in the current reporting interval.
     */
    @SerialName(JsonKeys.Rtcp.Interface.EgressRate.jitterSamples) val jitterSamples: Long?,
    /**
     * Remotely measured egress round-trip time during the current reporting interval, in milliseconds.
     */
    @SerialName(JsonKeys.Rtcp.Interface.EgressRate.rttMs) val rttMs: Double?,
    /**
     * Number of remotely measured egress round-trip-time samples in the current reporting interval.
     */
    @SerialName(JsonKeys.Rtcp.Interface.EgressRate.rttSamples) val rttSamples: Long?,
)

@Serializable
internal data class VoipMetrics(
    /**
     * Cumulative average of all valid MOS measurements for the call, where 1 is the lowest and 5 the highest quality.
     */
    @SerialName(JsonKeys.Rtcp.Interface.VoipMetrics.mosAverage) val mosAverage: Double?,
    /**
     * Cumulative average of all valid remotely reported egress jitter samples, in milliseconds.
     */
    @SerialName(JsonKeys.Rtcp.Interface.VoipMetrics.jitterAverage) val jitterAverage: Double?,
    /**
     * Cumulative average of all valid locally measured ingress jitter samples, in milliseconds.
     */
    @SerialName(JsonKeys.Rtcp.Interface.VoipMetrics.jitterMeasuredAverage) val jitterMeasuredAverage: Double?,
    /**
     * Measures current (last) packet round-trip-time (RTT) in microseconds (positive number starting at 0.0)
     * Note: Mobile SDK API accepts this value in milliseconds and will thus be converted before stored here
     */
    @SerialName(JsonKeys.Rtcp.Interface.VoipMetrics.rttDscAverage) val rttDscAverage: Double?,
    /**
     * Total number of lost packets (positive number starting at 0)
     */
    @SerialName(JsonKeys.Rtcp.Interface.VoipMetrics.packetLossTotal) val packetLossTotal: Long?,
)

@Serializable
internal data class VoipMetricsInterval(
    /**
     * Estimated egress MOS for the current reporting interval, or `null` when its required inputs are unavailable.
     */
    @SerialName(JsonKeys.Rtcp.Interface.VoipMetricsInterval.mos) val mos: Double?,
    /**
     * Number of MOS measurements in the current reporting interval, or `null` when no MOS was calculated.
     */
    @SerialName(JsonKeys.Rtcp.Interface.VoipMetricsInterval.mosSamples) val mosSamples: Long?,
    /**
     * Remotely reported egress jitter for the current reporting interval, in milliseconds.
     */
    @SerialName(JsonKeys.Rtcp.Interface.VoipMetricsInterval.jitter) val jitter: Double?,
    /**
     * Locally measured ingress jitter for the current reporting interval, in milliseconds.
     */
    @SerialName(JsonKeys.Rtcp.Interface.VoipMetricsInterval.jitterMeasured) val jitterMeasured: Double?,
)

@Serializable
internal data class MediaStats(
    /**
     * This WebRTC property represents the audio level of the media source.
     *
     * It is a number between 0 and 1 (linear), where 1.0 represents 0 dBov (decibels relative to full scale),
     * 0 represents silence, and 0.5 represents approximately 6 dB SPL change in the sound pressure level from 0 dBov.
     *
     * @since 1.0.4
     *
     * See [WebRTC documentation](https://developer.mozilla.org/en-US/docs/Web/API/RTCAudioSourceStats/audioLevel)
     */
    @SerialName(JsonKeys.Rtcp.Interface.MediaStats.audioLevel) val audioLevel: Double,
    /**
     * This WebRTC property represents the total audio energy of the media source over the lifetime of a call.
     *
     * A number produced by summing the energy of every sample over the lifetime of this stats object.
     * The energy of each sample is calculated by dividing the sample's value by the highest-intensity encodable value,
     * squaring the result, and then multiplying by the duration of the sample in seconds.
     * Note that if multiple audio channels are used, the audio energy of a sample refers to the highest energy of any channel.
     *
     * @since 1.0.4
     *
     * See [WebRTC documentation](https://developer.mozilla.org/en-US/docs/Web/API/RTCAudioSourceStats/totalAudioEnergy)
     */
    @SerialName(JsonKeys.Rtcp.Interface.MediaStats.totalAudioEnergy) val totalAudioEnergy: Double,
)
