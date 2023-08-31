package com.sipfront.sdk.json.message

import com.sipfront.sdk.interfaces.ProguardKeep
import com.sipfront.sdk.json.JsonKeys
import com.sipfront.sdk.json.message.base.BaseMessage
import com.sipfront.sdk.json.message.enums.*
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.experimental.ExperimentalObjCName
import kotlin.native.ObjCName

/**
 * Message describing the current call state
 */
@Serializable
@SerialName("StateMessage")
data class StateMessage internal constructor(
    @SerialName(JsonKeys.Call.id)
    val callId: String? = null,
    @SerialName(JsonKeys.Address.local)
    val addresslocal: String? = null,
    @SerialName(JsonKeys.Address.remote)
    val addressremote: String? = null,
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
    @OptIn(ExperimentalObjCName::class)
    class Builder : ProguardKeep {
        private var callId: String? = null
        private var localAddress: String? = null
        private var remoteAddress: String? = null
        private var remoteDisplayName: String? = null
        private var callDirection: CallDirection? = null
        private var type: MessageType.State? = null
        private var audioDirection: MediaDirection = MediaDirection.INACTIVE
        private var videoDirection: MediaDirection = MediaDirection.INACTIVE

        /**
         * The Call-Id of a call
         */
        @ObjCName("call")
        fun callId(id: String) = apply { this.callId = id }

        /**
         * The local address (this device) of a call
         */
        @ObjCName("address")
        fun addressLocal(@ObjCName("local") address: String) = apply { this.localAddress = address }

        /**
         * The remote address of a call
         */
        @ObjCName("address")
        fun addressRemote(@ObjCName("remote") address: String) =
            apply { this.remoteAddress = address }

        /**
         * The display name of a call
         */
        @ObjCName("displayName")
        fun displayNameRemote(@ObjCName("remote") displayName: String) =
            apply { this.remoteDisplayName = displayName }

        /**
         * The [MessageType.State] describing the current call state
         */
        fun type(@ObjCName("_") type: MessageType.State) =
            apply { this.type = type }

        /**
         * The [CallDirection] of a call
         */
        @ObjCName("call")
        fun callDirection(direction: CallDirection) =
            apply { this.callDirection = direction }

        /**
         * The audio [MediaDirection] of a call
         */
        @ObjCName("audio")
        fun audioDirection(direction: MediaDirection) =
            apply { this.audioDirection = direction }

        /**
         * The video [MediaDirection] of a call
         */
        @ObjCName("video")
        fun videoDirection(direction: MediaDirection) =
            apply { this.videoDirection = direction }

        /**
         * Builds the [StateMessage]
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
                    addresslocal = localAddress,
                    addressremote = remoteAddress,
                    addressRemoteDisplayName = remoteDisplayName,
                    callDirection = callDirection,
                    audioDirection = audioDirection,
                    videoDirection = videoDirection
                )
            }
            throw IllegalStateException("Invalid configuration for StateMessage")
        }
    }
}
