package com.sipfront.sdk.json.enums

import com.sipfront.sdk.interfaces.EnumValue
import com.sipfront.sdk.json.serializer.MediaStreamKindSerializer
import kotlinx.serialization.Serializable
import kotlin.experimental.ExperimentalObjCName
import kotlin.native.ObjCName

/**
 * Represents the possible media kinds for an individual [MediaStream].
 *
 * This enum defines the kind of individual media streams, such as whether the stream is audio or video.
 *
 * @property value The [String] representation of the media streams kind.
 *
 * @since 1.0.7
 * @author Dominik Ridjic
 */
@OptIn(ExperimentalObjCName::class)
@Serializable(with = MediaStreamKindSerializer::class)
@ObjCName("MediaStreamDirection")
enum class MediaStreamKind(override val value: String) : EnumValue {
    /**
     * Represents an audio stream
     */
    AUDIO(Value.audio),

    /**
     * Represents a video stream
     */
    VIDEO(Value.video),

    /**
     * Represents a media stream without a kind
     */
    NONE(Value.none);

    internal object Value {
        const val audio: String = "audio"
        const val video: String = "video"
        const val none: String = "none"
    }
}