package com.sipfront.sdk.json.message

import com.sipfront.sdk.interfaces.ProguardKeep
import com.sipfront.sdk.json.JsonKeys
import com.sipfront.sdk.json.message.RtcpMessage.Builder
import com.sipfront.sdk.json.message.base.BaseMessage
import com.sipfront.sdk.json.enums.CallDirection
import com.sipfront.sdk.json.enums.MediaDirection
import com.sipfront.sdk.json.enums.MessageClass
import com.sipfront.sdk.json.enums.MessageType
import com.sipfront.sdk.json.message.utils.RtcpMath
import com.sipfront.sdk.utils.KotlinHelper
import com.sipfront.sdk.utils.currentTimeMillisFormatted
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.Transient
import kotlin.experimental.ExperimentalObjCName
import kotlin.native.ObjCName

/**
 * Represents a message containing RTCP data.
 *
 * This data class encapsulates various RTCP parameters including call information,
 * media directions, jitter, packet count, and more.
 *
 * @property callId The unique identifier for the call.
 * @property addressLocal The local address associated with the call.
 * @property addressRemote The remote address associated with the call.
 * @property addressRemoteDisplayName The display name associated with the remote address.
 * @property callDirection The direction of the call.
 * @property audioDirection The direction of the audio media.
 * @property videoDirection The direction of the video media.
 * @property audioRemoteDirection The remote direction of the audio media.
 * @property videoRemoteDirection The remote direction of the video media.
 * @property rxJitter Current locally measured RFC 3550 interarrival jitter for RTP packets received by the local
 * endpoint during this reporting interval, in milliseconds, or `null` when no new measurement is available.
 * @property txJitter Latest jitter reported by the remote endpoint for RTP packets transmitted by the local endpoint,
 * normally obtained from an RTCP receiver report, in milliseconds, or `null` when no new report is available.
 * @property rxPackets The total number of received RTP packets.
 * @property rxLost The total number of RTP packets lost during reception, or `null` when no new measurement is
 * available.
 * @property rxBytes The total number of received RTP bytes.
 * @property rxAudioLevel The audio level of incoming media.
 * @property rxTotalAudioEnergy The total audio energy of incoming media over the lifetime of the call.
 * @property txPackets The total number of sent RTP packets.
 * @property txLost The total number of RTP packets lost during transmission according to the remote endpoint, or
 * `null` when no new RTCP report is available.
 * @property txBytes The total number of sent RTP bytes.
 * @property txAudioLevel The audio level of outgoing media.
 * @property txTotalAudioEnergy The total audio energy of outgoing media over the lifetime of the call.
 * @property rtt The current RTCP round trip time in milliseconds, or `null` when no new measurement is available.
 *
 * @throws IllegalStateException If [callId], [addressLocal], [addressRemote], [addressRemoteDisplayName] or [callDirection]
 * is missing before calling [Builder.build]
 *
 * @since 1.0.0
 * @author Dominik Ridjic
 */
@Serializable
@SerialName("RtcpMessage")
data class RtcpMessage internal constructor(
    @SerialName(JsonKeys.Call.id) val callId: String,
    @SerialName(JsonKeys.Address.local) val addressLocal: String,
    @SerialName(JsonKeys.Address.remote) val addressRemote: String,
    @SerialName(JsonKeys.Address.remoteDisplayName) val addressRemoteDisplayName: String,
    @SerialName(JsonKeys.Call.direction) val callDirection: CallDirection,
    @SerialName(MediaDirection.Type.audiodir) val audioDirection: MediaDirection,
    @SerialName(MediaDirection.Type.videodir) val videoDirection: MediaDirection,
    @SerialName(MediaDirection.Type.remoteaudiodir) val audioRemoteDirection: MediaDirection = audioDirection.toRemote(),
    @SerialName(MediaDirection.Type.remotevideodir) val videoRemoteDirection: MediaDirection = videoDirection.toRemote(),
    @SerialName(JsonKeys.param) val param: String = "audio",
    @SerialName(JsonKeys.Rtcp.localJitterEnabled) val localJitterEnabled: Boolean = true,
    @SerialName(JsonKeys.Rtcp.producer) internal val producer: RtcpProducer = RtcpProducer(),
    @Transient val rxJitter: Double? = null,
    @Transient val txJitter: Double? = null,
    @Transient val rxPackets: Long = 0L,
    @Transient val rxLost: Long? = null,
    @Transient val rxBytes: Long = 0L,
    @Transient val rxAudioLevel: Double = 0.0,
    @Transient val rxTotalAudioEnergy: Double = 0.0,
    @Transient val txPackets: Long = 0L,
    @Transient val txLost: Long? = null,
    @Transient val txBytes: Long = 0L,
    @Transient val txAudioLevel: Double = 0.0,
    @Transient val txTotalAudioEnergy: Double = 0.0,
    @Transient val rtt: Double? = null,
    @SerialName(JsonKeys.Message.type) override val type: MessageType.Rtcp = MessageType.Rtcp.RTCP,
    @SerialName(JsonKeys.Message.clazz) override val clazz: MessageClass = MessageClass.CALL,
    @SerialName(JsonKeys.timestamp) override val timestamp: Double = currentTimeMillisFormatted()
) : BaseMessage() {
    @SerialName(JsonKeys.Rtcp.interfaces)
    internal val interfaces: List<RtcpInterface> = RtcpMath.createRtcpInterface(this)

    /**
     * Builder class for [RtcpMessage].
     *
     * Provides a fluent API to set various properties for the [RtcpMessage] and then build it.
     */
    @Suppress("unused")
    @OptIn(ExperimentalObjCName::class)
    class Builder : ProguardKeep {
        private var callId: String? = null
        private var addressLocal: String? = null
        private var addressRemote: String? = null
        private var displayNameRemote: String? = null
        private var callDirection: CallDirection? = null
        private var audioDirection: MediaDirection = MediaDirection.INACTIVE
        private var videoDirection: MediaDirection = MediaDirection.INACTIVE
        private var rxJitter: Double? = null
        private var txJitter: Double? = null
        private var rxPackets: Long = 0L
        private var rxLost: Long? = null
        private var rxBytes: Long = 0L
        private var rxAudioLevel: Double = 0.0
        private var rxTotalAudioEnergy: Double = 0.0
        private var txPackets: Long = 0L
        private var txLost: Long? = null
        private var txBytes: Long = 0L
        private var txAudioLevel: Double = 0.0
        private var txTotalAudioEnergy: Double = 0.0
        private var rtt: Double? = null

        /**
         * The Call-Id of a call, mandatory property
         */
        @ObjCName("call")
        fun callId(id: String) = apply { this.callId = id }

        /**
         * The local address (this device) of a call, mandatory property
         */
        @ObjCName("address")
        fun addressLocal(@ObjCName("local") address: String) = apply { this.addressLocal = address }

        /**
         * The remote address of a call, mandatory property
         */
        @ObjCName("address")
        fun addressRemote(@ObjCName("remote") address: String) = apply { this.addressRemote = address }

        /**
         * The display name of a call, mandatory property
         */
        @ObjCName("displayName")
        fun displayNameRemote(@ObjCName("remote") displayName: String) = apply { this.displayNameRemote = displayName }

        /**
         * The [CallDirection] of a call, mandatory property
         */
        @ObjCName("call")
        fun callDirection(direction: CallDirection) = apply { this.callDirection = direction }

        /**
         * The audio [MediaDirection] of a call
         */
        @ObjCName("audio")
        fun audioDirection(direction: MediaDirection) = apply { this.audioDirection = direction }


        /**
         * The video [MediaDirection] of a call
         */
        @ObjCName("video")
        fun videoDirection(direction: MediaDirection) = apply { this.videoDirection = direction }

        /**
         * Total number of TX (transmitted) RTP packets
         */
        @ObjCName("tx")
        fun txPackets(packets: Long) = apply { this.txPackets = packets }

        /**
         * Sets the cumulative number of transmitted RTP packets reported lost by the remote endpoint.
         *
         * @param lost cumulative remotely reported egress packet-loss counter; zero is a valid measurement
         * @return this builder after storing [lost]
         */
        @ObjCName("tx")
        fun txLost(lost: Long) = apply { this.txLost = lost }

        /**
         * Total number of TX (transmitted) RTP bytes
         */
        @ObjCName("tx")
        fun txBytes(bytes: Long) = apply { this.txBytes = bytes }

        /**
         * Sets the latest jitter reported by the remote endpoint for RTP packets transmitted by the local endpoint.
         *
         * @param jitter latest non-negative, finite RTCP-reported egress jitter, in milliseconds
         * @return this builder after storing [jitter]
         */
        @ObjCName("tx")
        fun txJitter(jitter: Double) = apply { this.txJitter = jitter }

        /**
         * This WebRTC property represents the audio level of the media source (outgoing).
         *
         * @since 1.0.4
         *
         * See [WebRTC documentation](https://developer.mozilla.org/en-US/docs/Web/API/RTCAudioSourceStats/audioLevel)
         */
        @ObjCName("tx")
        fun txAudioLevel(audioLevel: Double) = apply { this.txAudioLevel = audioLevel }

        /**
         * This WebRTC property represents the total audio energy of the media source over the lifetime of a call. (outgoing)
         *
         * @since 1.0.4
         *
         * See [WebRTC documentation](https://developer.mozilla.org/en-US/docs/Web/API/RTCAudioSourceStats/totalAudioEnergy)
         */
        @ObjCName("tx")
        fun txTotalAudioEnergy(totalAudioEnergy: Double) =
            apply { this.txTotalAudioEnergy = totalAudioEnergy }

        /**
         * Total number of RX (received) RTP packets
         */
        @ObjCName("rx")
        fun rxPackets(packets: Long) = apply { this.rxPackets = packets }

        /**
         * Total number of RX (received) RTP bytes
         */
        @ObjCName("rx")
        fun rxBytes(bytes: Long) = apply { this.rxBytes = bytes }

        /**
         * Sets the current locally measured RFC 3550 interarrival jitter for received RTP packets.
         *
         * @param jitter current non-negative, finite locally measured ingress jitter for this reporting interval, in
         * milliseconds
         * @return this builder after storing [jitter]
         */
        @ObjCName("rx")
        fun rxJitter(jitter: Double) = apply { this.rxJitter = jitter }

        /**
         * Sets the cumulative number of RTP packets lost during local reception.
         *
         * @param lost cumulative locally measured ingress packet-loss counter; zero is a valid measurement
         * @return this builder after storing [lost]
         */
        @ObjCName("rx")
        fun rxLost(lost: Long) = apply { this.rxLost = lost }

        /**
         * This WebRTC property represents the audio level of the media source (incoming).
         *
         * @since 1.0.4
         *
         * See [WebRTC documentation](https://developer.mozilla.org/en-US/docs/Web/API/RTCAudioSourceStats/audioLevel)
         */
        @ObjCName("rx")
        fun rxAudioLevel(audioLevel: Double) = apply { this.rxAudioLevel = audioLevel }

        /**
         * This WebRTC property represents the total audio energy of the media source over the lifetime of a call. (incoming)
         *
         * @since 1.0.4
         *
         * See [WebRTC documentation](https://developer.mozilla.org/en-US/docs/Web/API/RTCAudioSourceStats/totalAudioEnergy)
         */
        @ObjCName("rx")
        fun rxTotalAudioEnergy(totalAudioEnergy: Double) =
            apply { this.rxTotalAudioEnergy = totalAudioEnergy }

        /**
         * Sets the current RTCP round-trip time.
         *
         * @param rtt current non-negative, finite RTCP round-trip time in milliseconds; zero is a valid measurement
         * @return this builder after storing [rtt]
         */
        fun rtt(@ObjCName("_") rtt: Double) = apply { this.rtt = rtt }

        /**
         * Constructs the [RtcpMessage] based on the provided properties.
         *
         * @throws IllegalStateException If the configuration for [RtcpMessage] is invalid.
         * @return An instance of [RtcpMessage].
         */
        @Throws(IllegalStateException::class)
        fun build(): RtcpMessage {
            KotlinHelper.multiLet(
                callId, addressLocal, addressRemote, displayNameRemote, callDirection
            ) { (callId, addressLocal, addressRemote, displayNameRemote, callDirection) ->
                return@build RtcpMessage(
                    callId = callId as String,
                    addressLocal = addressLocal as String,
                    addressRemote = addressRemote as String,
                    addressRemoteDisplayName = displayNameRemote as String,
                    callDirection = callDirection as CallDirection,
                    audioDirection = audioDirection,
                    videoDirection = videoDirection,
                    rxJitter = rxJitter,
                    txJitter = txJitter,
                    rxPackets = rxPackets,
                    rxLost = rxLost,
                    rxBytes = rxBytes,
                    rxAudioLevel = rxAudioLevel,
                    rxTotalAudioEnergy = rxTotalAudioEnergy,
                    txPackets = txPackets,
                    txLost = txLost,
                    txBytes = txBytes,
                    txAudioLevel = txAudioLevel,
                    txTotalAudioEnergy = txTotalAudioEnergy,
                    rtt = rtt
                )
            }
            throw IllegalStateException("Invalid configuration for RtcpMessage")
        }
    }
}
