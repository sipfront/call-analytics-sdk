package com.sipfront.sdk.json.message

import com.sipfront.sdk.json.message.enums.CallDirection
import com.sipfront.sdk.json.message.enums.MediaDirection

/**
 * This is a JavaScript wrapper for [RtcpMessage]
 *
 * Required because KMM cannot export Long to Javascript
 *
 * Avoiding this issue by taking these parameters in String format
 * and then within the library converting it to Long
 *
 * @since 1.0.6
 * @author Dominik Ridjic
 */
@Suppress("unused")
@OptIn(ExperimentalJsExport::class)
@JsExport
class RtcpMessageJs {

    companion object {
        private const val UNAVAILABLE: String = "unavailable"
    }

    // Creating a default RtcpMessage.Builder with defaults for data which we can't extract from WebRTC
    private val builder: RtcpMessage.Builder =
        RtcpMessage.Builder()
            .callDirection(CallDirection.NONE)

    /**
     * @see [RtcpMessage.Builder.addressLocal]
     */
    fun addressLocal(address: String) = apply {
        builder.addressLocal(address)
        return@apply
    }

    /**
     * @see [RtcpMessage.Builder.addressRemote]
     */
    fun addressRemote(address: String) = apply {
        builder.addressRemote(address)
        return@apply
    }

    /**
     * @see [RtcpMessage.Builder.displayNameRemote]
     */
    fun displayNameRemote(displayName: String) = apply {
        builder.displayNameRemote(displayName)
        return@apply
    }

    /**
     * @see [RtcpMessage.Builder.txPackets]
     */
    fun txPackets(packets: String) = apply {
        builder.txPackets(packets.toLong())
        return@apply
    }

    /**
     * @see [RtcpMessage.Builder.txBytes]
     */
    fun txBytes(bytes: String) = apply {
        builder.txBytes(bytes.toLong())
        return@apply
    }

    /**
     * @see [RtcpMessage.Builder.rxPackets]
     */
    fun rxPackets(packets: String) = apply {
        builder.rxPackets(packets.toLong())
        return@apply
    }

    /**
     * @see [RtcpMessage.Builder.rxBytes]ø
     */
    fun rxBytes(bytes: String) = apply {
        builder.rxBytes(bytes.toLong())
        return@apply
    }

    /**
     * @see [RtcpMessage.Builder.rxLost]
     */
    fun rxLost(lost: String) = apply {
        builder.rxLost(lost.toLong())
        return@apply
    }

    /**
     * @see [RtcpMessage.Builder.txAudioLevel]
     */
    fun txAudioLevel(audioLevel: Double) = apply {
        builder.txAudioLevel(audioLevel)
        return@apply
    }

    /**
     * @see [RtcpMessage.Builder.txTotalAudioEnergy]
     */
    fun txTotalAudioEnergy(totalAudioEnergy: Double) = apply {
        builder.txTotalAudioEnergy(totalAudioEnergy)
        return@apply
    }

    /**
     * @see [RtcpMessage.Builder.rxJitter]
     */
    fun rxJitter(jitter: Double) = apply {
        builder.rxJitter(jitter)
        return@apply
    }

    /**
     * @see [RtcpMessage.Builder.rxAudioLevel]
     */
    fun rxAudioLevel(audioLevel: Double) = apply {
        builder.rxAudioLevel(audioLevel)
        return@apply
    }

    /**
     * @see [RtcpMessage.Builder.rxTotalAudioEnergy]
     */
    fun rxTotalAudioEnergy(totalAudioEnergy: Double) = apply {
        builder.rxTotalAudioEnergy(totalAudioEnergy)
        return@apply
    }

    /**
     * @see [RtcpMessage.Builder.rtt]
     */
    fun rtt(rtt: Double) = apply {
        builder.rtt(rtt)
        return@apply
    }

    /**
     * @see [RtcpMessage.Builder.audioDirection]
     */
    @Suppress("NON_EXPORTABLE_TYPE")
    fun audioDirection(direction: MediaDirection) = apply {
        builder.audioDirection(direction)
        return@apply
    }


    /**
     * @see [RtcpMessage.Builder.videoDirection]
     */
    @Suppress("NON_EXPORTABLE_TYPE")
    fun videoDirection(direction: MediaDirection) = apply {
        builder.videoDirection(direction)
        return@apply
    }

    /**
     * @see [RtcpMessage.Builder.callId]
     */
    fun callId(id: String) = apply {
        builder.callId(id)
        return@apply
    }

    /**
     * @see [RtcpMessage.Builder.build]
     */
    @Suppress("NON_EXPORTABLE_TYPE")
    fun build(): RtcpMessage {
        return builder.build()
    }
}