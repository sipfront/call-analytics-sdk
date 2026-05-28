package com.sipfront.sdk.json.message

import com.sipfront.sdk.interfaces.ProguardKeep
import com.sipfront.sdk.json.JsonKeys
import com.sipfront.sdk.json.enums.CallDirection
import com.sipfront.sdk.json.enums.MediaDirection
import com.sipfront.sdk.json.enums.MessageClass
import com.sipfront.sdk.json.enums.MessageType
import com.sipfront.sdk.json.message.StateMessage.Builder
import com.sipfront.sdk.json.message.base.BaseMessage
import com.sipfront.sdk.utils.currentTimeMillisFormatted
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.experimental.ExperimentalObjCName
import kotlin.js.ExperimentalJsExport
import kotlin.js.JsExport
import kotlin.native.ObjCName

/**
 * Represents a message describing the current call state.
 *
 * This data class encapsulates various parameters related to the call state, including call ID, local and remote addresses, call and media directions, and more.
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
 * @property type The type of the message, typically representing the call state.
 * @property clazz The class of the message.
 * @property timestamp The timestamp when the message was created or received.
 *
 * @throws IllegalStateException If [type] is missing before calling [Builder.build]
 *
 * @since 1.0.0
 * @author Dominik Ridjic
 */
@Suppress("NON_EXPORTABLE_TYPE")
@OptIn(ExperimentalJsExport::class)
@Serializable
@SerialName("StateMessage")
@JsExport
data class StateMessage internal constructor(
    @SerialName(JsonKeys.Call.id)
    val callId: String? = null,
    @SerialName(JsonKeys.Address.local)
    val addressLocal: String? = null,
    @SerialName(JsonKeys.Address.remote)
    val addressRemote: String? = null,
    @SerialName(JsonKeys.Address.remoteDisplayName)
    val addressRemoteDisplayName: String? = null,
    @SerialName(JsonKeys.Call.direction)
    val callDirection: CallDirection? = CallDirection.NONE,
    @SerialName(MediaDirection.Type.audiodir)
    val audioDirection: MediaDirection = MediaDirection.INACTIVE,
    @SerialName(MediaDirection.Type.videodir)
    val videoDirection: MediaDirection = MediaDirection.INACTIVE,
    @SerialName(MediaDirection.Type.remoteaudiodir)
    val audioRemoteDirection: MediaDirection = audioDirection.toRemote(),
    @SerialName(MediaDirection.Type.remotevideodir)
    val videoRemoteDirection: MediaDirection = videoDirection.toRemote(),
    @SerialName(JsonKeys.Message.type)
    override val type: MessageType.State,
    @SerialName(JsonKeys.Message.clazz)
    override val clazz: MessageClass,
    @SerialName(JsonKeys.timestamp)
    override val timestamp: Double = currentTimeMillisFormatted()
) : BaseMessage() {
    /**
     * Builder class for [StateMessage].
     *
     * Provides a fluent API to set various properties for the [StateMessage] and then build it.
     */
    @Suppress("unused")
    @OptIn(ExperimentalObjCName::class)
    class Builder : ProguardKeep {
        private var callId: String? = null
        private var addressLocal: String? = null
        private var addressRemote: String? = null
        private var addressRemoteDisplayName: String? = null
        private var callDirection: CallDirection? = null
        private var type: MessageType.State? = null
        private var audioDirection: MediaDirection = MediaDirection.INACTIVE
        private var videoDirection: MediaDirection = MediaDirection.INACTIVE

        /**
         * Set the [StateMessage.callId] for the [StateMessage].
         *
         * @param id The unique identifier for the call.
         */
        @ObjCName("call")
        fun callId(id: String) = apply { this.callId = id }

        /**
         * Set the [StateMessage.addressLocal] for the [StateMessage].
         *
         * @param address The local address associated with the call.
         */
        @ObjCName("address")
        fun addressLocal(@ObjCName("local") address: String) = apply { this.addressLocal = address }

        /**
         * Set the [StateMessage.addressRemote] for the [StateMessage].
         *
         * @param address The remote address associated with the call.
         */
        @ObjCName("address")
        fun addressRemote(@ObjCName("remote") address: String) =
            apply { this.addressRemote = address }

        /**
         * Set the [StateMessage.addressRemoteDisplayName] for the [StateMessage].
         *
         * @param displayName The display name associated with the remote address.
         */
        @ObjCName("displayName")
        fun displayNameRemote(@ObjCName("remote") displayName: String) =
            apply { this.addressRemoteDisplayName = displayName }

        /**
         * Set the [StateMessage.type] for the [StateMessage].
         *
         * @param type The type of the message, typically representing the call state.
         */
        fun type(@ObjCName("_") type: MessageType.State) =
            apply { this.type = type }

        /**
         * Set the [StateMessage.callDirection] for the [StateMessage].
         *
         * @param direction The direction of the call.
         */
        @ObjCName("call")
        fun callDirection(direction: CallDirection) =
            apply { this.callDirection = direction }

        /**
         * Set the [StateMessage.audioDirection] for the [StateMessage].
         *
         * @param direction The direction of the audio media.
         */
        @ObjCName("audio")
        fun audioDirection(direction: MediaDirection) =
            apply { this.audioDirection = direction }

        /**
         * Set the [StateMessage.videoDirection] for the [StateMessage].
         *
         * @param direction The direction of the video media.
         */
        @ObjCName("video")
        fun videoDirection(direction: MediaDirection) =
            apply { this.videoDirection = direction }

        /**
         * Constructs the [StateMessage] based on the provided properties.
         *
         * @throws IllegalStateException If the configuration for [StateMessage] is invalid.
         * @return An instance of [StateMessage].
         */
        @Throws(IllegalStateException::class)
        fun build(): StateMessage {
            type?.let { type ->
                return@build StateMessage(
                    type = type,
                    clazz = type.toMessageClass(),
                    callId = callId,
                    addressLocal = addressLocal,
                    addressRemote = addressRemote,
                    addressRemoteDisplayName = addressRemoteDisplayName,
                    callDirection = callDirection,
                    audioDirection = audioDirection,
                    videoDirection = videoDirection
                )
            }
            throw IllegalStateException("Invalid configuration for StateMessage")
        }

        private fun MessageType.State.toMessageClass(): MessageClass =
            when (this) {
                MessageType.State.CREATE,
                MessageType.State.SHUTDOWN,
                MessageType.State.EXIT -> MessageClass.APPLICATION

                MessageType.State.REGISTER,
                MessageType.State.REGISTER_FAILED,
                MessageType.State.FALLBACK_OK,
                MessageType.State.FALLBACK_FAILED,
                MessageType.State.REGISTERING,
                MessageType.State.UNREGISTERING -> MessageClass.REGISTER

                MessageType.State.MWI_NOTIFY -> MessageClass.MWI
                MessageType.State.VU_TX,
                MessageType.State.VU_RX -> MessageClass.VU_REPORT
                MessageType.State.AUDIO_LATENCY_OUTGOING,
                MessageType.State.AUDIO_LATENCY_INCOMING -> MessageClass.AUDIO_LATENCY
                MessageType.State.FAX_SUCCESS,
                MessageType.State.FAX_FAILED,
                MessageType.State.FAXMODE_AUDIO,
                MessageType.State.FAXMODE_T38 -> MessageClass.ASTERISK_FAX

                MessageType.State.SIP_SESSION_CONNECTED,
                MessageType.State.PHONE_ATTACHED,
                MessageType.State.PHONE_DETACHED,
                MessageType.State.PHONE_SELECTED,
                MessageType.State.PHONE_PROPERTY_CHANGED,
                MessageType.State.HANDSFREE_PROPERTY_CHANGED,
                MessageType.State.CALLVOLUME_CHANGED,
                MessageType.State.CALLMANAGER_PROPERTY_CHANGED,
                MessageType.State.CALLMANAGER_BARRING_ACTIVE,
                MessageType.State.CALLMANAGER_FORWARDED -> MessageClass.OTHER

                MessageType.State.CALL_POST_DIAL_DELAY,
                MessageType.State.CALL_INCOMING,
                MessageType.State.CALL_OUTGOING,
                MessageType.State.CALL_RINGING,
                MessageType.State.CALL_PROGRESS,
                MessageType.State.CALL_ANSWERED,
                MessageType.State.CALL_ANSWERING,
                MessageType.State.CALL_ANSWER_DELAY,
                MessageType.State.CALL_ESTABLISHED,
                MessageType.State.CALL_RTP_ESTABLISHED,
                MessageType.State.CALL_LOCAL_SDP,
                MessageType.State.CALL_REMOTE_SDP,
                MessageType.State.CALL_ENDED_LOCAL,
                MessageType.State.CALL_ENDED_REMOTE,
                MessageType.State.CALL_REJECTED,
                MessageType.State.CALL_FAILED,
                MessageType.State.CALL_BUSY_HERE,
                MessageType.State.CALL_TEMPORARILY_UNAVAILABLE,
                MessageType.State.CALL_FORBIDDEN,
                MessageType.State.CALL_NOT_ACCEPTABLE,
                MessageType.State.CALL_NOT_FOUND,
                MessageType.State.CALL_DECLINE,
                MessageType.State.CALL_CANCEL,
                MessageType.State.CALL_UNAUTHORIZED,
                MessageType.State.CALL_PROXY_AUTHENTICATION_REQUIRED,
                MessageType.State.CALL_CLOSED,
                MessageType.State.CALL_IN_PROGRESS,
                MessageType.State.CALL_HOLD,
                MessageType.State.CALL_RESUME,
                MessageType.State.CALL_HOLD_LOCAL,
                MessageType.State.CALL_RESUME_LOCAL,
                MessageType.State.CALL_TRANSFER,
                MessageType.State.CALL_TRANSFER_FAILED,
                MessageType.State.CALL_REDIRECT,
                MessageType.State.CALL_DTMF_START,
                MessageType.State.CALL_DTMF_0,
                MessageType.State.CALL_DTMF_1,
                MessageType.State.CALL_DTMF_2,
                MessageType.State.CALL_DTMF_3,
                MessageType.State.CALL_DTMF_4,
                MessageType.State.CALL_DTMF_5,
                MessageType.State.CALL_DTMF_6,
                MessageType.State.CALL_DTMF_7,
                MessageType.State.CALL_DTMF_8,
                MessageType.State.CALL_DTMF_9,
                MessageType.State.CALL_DTMF_A,
                MessageType.State.CALL_DTMF_B,
                MessageType.State.CALL_DTMF_C,
                MessageType.State.CALL_DTMF_D,
                MessageType.State.CALL_DTMF_ASTERISK,
                MessageType.State.CALL_DTMF_POUND,
                MessageType.State.CALL_DTMF_END,
                MessageType.State.CALL_SEND_DTMF_START,
                MessageType.State.CALL_SEND_DTMF_0,
                MessageType.State.CALL_SEND_DTMF_1,
                MessageType.State.CALL_SEND_DTMF_2,
                MessageType.State.CALL_SEND_DTMF_3,
                MessageType.State.CALL_SEND_DTMF_4,
                MessageType.State.CALL_SEND_DTMF_5,
                MessageType.State.CALL_SEND_DTMF_6,
                MessageType.State.CALL_SEND_DTMF_7,
                MessageType.State.CALL_SEND_DTMF_8,
                MessageType.State.CALL_SEND_DTMF_9,
                MessageType.State.CALL_SEND_DTMF_A,
                MessageType.State.CALL_SEND_DTMF_B,
                MessageType.State.CALL_SEND_DTMF_C,
                MessageType.State.CALL_SEND_DTMF_D,
                MessageType.State.CALL_SEND_DTMF_ASTERISK,
                MessageType.State.CALL_SEND_DTMF_POUND,
                MessageType.State.CALL_SEND_DTMF_END,
                MessageType.State.CALL_MENC,
                MessageType.State.AUDIO_ERROR,
                MessageType.State.CALL_REMOVED,
                MessageType.State.CALL_HELD,
                MessageType.State.CALL_WAITING,
                MessageType.State.CALL_STATE_CHANGED,
                MessageType.State.CALL_PROPERTY_CHANGED,
                MessageType.State.CALL_DISCONNECTED -> MessageClass.CALL
            }
    }
}
