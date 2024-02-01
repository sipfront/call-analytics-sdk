package com.sipfront.sdk.json.enums

import com.sipfront.sdk.interfaces.EnumValue
import com.sipfront.sdk.json.serializer.MediaDirectionSerializer
import kotlinx.serialization.Serializable
import kotlin.experimental.ExperimentalObjCName
import kotlin.native.ObjCName

/**
 * Represents the possible media directions for a call.
 *
 * This enum defines the directionality of media streams in calls, such as whether the stream is sending, receiving, both, or inactive.
 *
 * @property value The [String] representation of the media direction.
 */
@OptIn(ExperimentalObjCName::class)
@Serializable(with = MediaDirectionSerializer::class)
@ObjCName("Media")
enum class MediaDirection(override val value: String) : EnumValue {
    /**
     * Represents a bidirectional media stream, where both sending and receiving are active.
     */
    SEND_RECEIVE(Value.sendrecv),

    /**
     * Represents a unidirectional media stream where only receiving is active.
     */
    RECEIVE_ONLY(Value.recvonly),

    /**
     * Represents a unidirectional media stream where only sending is active.
     */
    SEND_ONLY(Value.sendonly),

    /**
     * Represents a media stream that is currently inactive, neither sending nor receiving.
     */
    INACTIVE(Value.inactive);

    internal object Value {
        const val sendrecv: String = "sendrecv"
        const val recvonly: String = "recvonly"
        const val sendonly: String = "sendonly"
        const val inactive: String = "inactive"
    }

    internal object Type {
        const val none: String = "none"
        const val audiodir: String = "audiodir"
        const val videodir: String = "videodir"
        const val remoteaudiodir: String = "remoteaudiodir"
        const val remotevideodir: String = "remotevideodir"
    }

    /**
     * Converts the current media direction to its remote counterpart.
     *
     * For example, if the current direction is [SEND_ONLY], the remote counterpart would be [RECEIVE_ONLY].
     *
     * @return The [MediaDirection] representing the remote counterpart.
     */
    internal fun toRemote(): MediaDirection = when (this) {
        SEND_RECEIVE -> SEND_RECEIVE
        RECEIVE_ONLY -> SEND_ONLY
        SEND_ONLY -> RECEIVE_ONLY
        INACTIVE -> INACTIVE
    }
}