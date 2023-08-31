package com.sipfront.sdk.json.message.enums

import com.sipfront.sdk.interfaces.EnumValue
import com.sipfront.sdk.json.serializer.MediaDirectionSerializer
import kotlinx.serialization.Serializable
import kotlin.experimental.ExperimentalObjCName
import kotlin.native.ObjCName

@OptIn(ExperimentalObjCName::class)
@Serializable(with = MediaDirectionSerializer::class)
@ObjCName("Media")
enum class MediaDirection(override val value: String) : EnumValue {
    SEND_RECEIVE(Value.sendrecv),
    RECEIVE_ONLY(Value.recvonly),
    SEND_ONLY(Value.sendonly),
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

    fun toRemote(): MediaDirection = when (this) {
        SEND_RECEIVE -> SEND_RECEIVE
        RECEIVE_ONLY -> SEND_ONLY
        SEND_ONLY -> RECEIVE_ONLY
        INACTIVE -> INACTIVE
    }
}