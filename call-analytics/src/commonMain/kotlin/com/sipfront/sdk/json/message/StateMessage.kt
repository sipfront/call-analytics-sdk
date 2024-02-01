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
    @SerialName(JsonKeys.Message.timestamp)
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
                    clazz = when (type) {
                        MessageType.State.CALL_RTP_ESTABLISHED -> MessageClass.OTHER
                        MessageType.State.CREATE -> MessageClass.CREATE
                        MessageType.State.REGISTER -> MessageClass.REGISTER
                        MessageType.State.REGISTERING -> MessageClass.REGISTERING
                        MessageType.State.UNREGISTERING -> MessageClass.UNREGISTERING
                        MessageType.State.SHUTDOWN -> MessageClass.SHUTDOWN
                        MessageType.State.EXIT -> MessageClass.EXIT
                        else -> MessageClass.CALL
                    },
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
    }
}
