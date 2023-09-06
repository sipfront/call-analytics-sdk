package com.sipfront.sdk.json.message

import com.sipfront.sdk.json.JsonKeys
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class RtcpInterface(
    @SerialName(JsonKeys.Rtcp.Interface.name) val name: String = "external",
    @SerialName(JsonKeys.Rtcp.Interface.rate) val rate: Rate?,
    @SerialName(JsonKeys.Rtcp.Interface.ingress) val ingress: Ingress,
    @SerialName(JsonKeys.Rtcp.Interface.egress) val egress: Egress,
    @SerialName(JsonKeys.Rtcp.Interface.ingressRate) val ingressRate: IngressRate?,
    @SerialName(JsonKeys.Rtcp.Interface.egressRate) val egressRate: EgressRate?,
    @SerialName(JsonKeys.Rtcp.Interface.voipMetrics) val voipMetrics: VoipMetrics,
    @SerialName(JsonKeys.Rtcp.Interface.mediaOutbound) val mediaOutbound: MediaStats,
    @SerialName(JsonKeys.Rtcp.Interface.mediaInbound) val mediaInbound: MediaStats,
)

@Serializable
internal data class Rate(
    /**
     * Packets per second lost since the last measurement interval
     */
    @SerialName(JsonKeys.Rtcp.Interface.Rate.packetsLost) val packetsLost: Long
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
)

@Serializable
internal data class VoipMetrics(
    /**
     * Measures audio quality with a value between 1.0 and 5.0, where 1 is the lowest and 5 the highest quality
     */
    @SerialName(JsonKeys.Rtcp.Interface.VoipMetrics.mosAverage) val mosAverage: Double,
    /**
     * Measures jitter average in milliseconds. (positive number starting at 0.0)
     */
    @SerialName(JsonKeys.Rtcp.Interface.VoipMetrics.jitterAverage) val jitterAverage: Double,
    /**
     * Measures current (last) packet round-trip-time (RTT) in microseconds (positive number starting at 0.0)
     * Note: Mobile SDK API accepts this value in milliseconds and will thus be converted before stored here
     */
    @SerialName(JsonKeys.Rtcp.Interface.VoipMetrics.rttDscAverage) val rttDscAverage: Double,
    /**
     * Total number of lost packets (positive number starting at 0)
     */
    @SerialName(JsonKeys.Rtcp.Interface.VoipMetrics.packetLossTotal) val packetLossTotal: Long,
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