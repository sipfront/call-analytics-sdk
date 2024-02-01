package com.sipfront.sdk.json.enums

import com.sipfront.sdk.interfaces.EnumValue
import com.sipfront.sdk.json.serializer.MediaStreamDirectionSerializer
import kotlinx.serialization.Serializable
import kotlin.experimental.ExperimentalObjCName
import kotlin.native.ObjCName

/**
 * Represents the possible media directions for an individual [com.sipfront.sdk.json.media.MediaStream].
 *
 * This enum defines the directionality of individual media streams, such as whether the stream is incoming or outgoing.
 *
 * @property value The [String] representation of the media streams direction.
 *
 * @since 1.0.7
 * @author Dominik Ridjic
 */
@OptIn(ExperimentalObjCName::class)
@Serializable(with = MediaStreamDirectionSerializer::class)
@ObjCName("MediaStreamDirection")
enum class MediaStreamDirection(override val value: String) : EnumValue {
    /**
     * Represents a media stream that is outgoing.
     */
    OUTGOING(Value.outgoing),

    /**
     * Represents a media stream that is incoming.
     */
    INCOMING(Value.incoming);

    internal object Value {
        const val outgoing: String = "outgoing"
        const val incoming: String = "incoming"
    }

    /**
     * Inverts the current [MediaStreamDirection].
     *
     * For example, if the current direction is [OUTGOING], the inversion would be [INCOMING].
     *
     * @return The inverts [MediaStreamDirection].
     */
    internal fun invert(): MediaStreamDirection = when (this) {
        OUTGOING -> INCOMING
        INCOMING -> OUTGOING
    }

    internal fun toType(): String = when (this) {
        OUTGOING -> "encoding"
        INCOMING -> "decoding"
    }

    internal fun toTypeAbbreviated(): String = when (this) {
        OUTGOING -> "enc"
        INCOMING -> "dec"
    }
}