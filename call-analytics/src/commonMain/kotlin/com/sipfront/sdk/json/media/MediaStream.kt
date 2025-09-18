package com.sipfront.sdk.json.media

import com.sipfront.sdk.interfaces.ProguardKeep
import com.sipfront.sdk.json.JsonKeys
import com.sipfront.sdk.json.enums.MediaStreamDirection
import com.sipfront.sdk.json.enums.MimeType
import com.sipfront.sdk.json.media.MediaStream.Builder
import com.sipfront.sdk.utils.currentTimeMillisFormatted
import kotlinx.datetime.Clock
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.Transient
import kotlin.experimental.ExperimentalObjCName
import kotlin.js.ExperimentalJsExport
import kotlin.js.JsExport
import kotlin.native.ObjCName

/**
 * Represents a media stream containing the stream recording, kind and direction.
 *
 * @property data The media stream raw data.
 * @property direction the media stream, either outgoing or incoming
 * @property mimeType the media stream mime-type, for example, "audio/webm" or "audio/webm; codecs=opus"
 * @property fileName the file name generated for this media stream
 * @property timestamp The timestamp when the message was created or received.
 *
 * @throws IllegalStateException If [data], [direction] or [mimeType] is missing before calling [Builder.build]
 *
 * @since 1.0.7
 * @author Dominik Ridjic
 */
@OptIn(ExperimentalJsExport::class)
@Suppress("NON_EXPORTABLE_TYPE")
@Serializable
@SerialName("MediaStream")
@JsExport
data class MediaStream internal constructor(
    @Transient val data: ByteArray = ByteArray(0),
    @SerialName(JsonKeys.Media.Stream.direction) val direction: MediaStreamDirection,
    @SerialName(JsonKeys.Media.Stream.mimeType) val mimeType: MimeType,
    @SerialName(JsonKeys.Media.Stream.fileName) val fileName: String,
    @SerialName(JsonKeys.timestamp) val timestamp: Double = currentTimeMillisFormatted()
) : ProguardKeep {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || this::class != other::class) return false

        other as MediaStream

        if (!data.contentEquals(other.data)) return false
        if (direction != other.direction) return false
        if (mimeType != other.mimeType) return false
        if (fileName != other.fileName) return false
        if (timestamp != other.timestamp) return false

        return true
    }

    override fun hashCode(): Int {
        var result = data.contentHashCode()
        result = 31 * result + direction.hashCode()
        result = 31 * result + mimeType.hashCode()
        result = 31 * result + fileName.hashCode()
        result = 31 * result + timestamp.hashCode()
        return result
    }

    /**
     * Builder class for [MediaStream].
     *
     * Provides a fluent API to set various properties for the [MediaStream] and then build it.
     */
    @Suppress("unused")
    @OptIn(ExperimentalObjCName::class)
    class Builder : ProguardKeep {
        private var data: ByteArray? = null
        private var direction: MediaStreamDirection? = null
        private var mimeType: MimeType? = null
        private var fileName: String? = null

        /**
         * The audio or video data of the [MediaStream] as [ByteArray]
         */
        fun data(@ObjCName("_") data: ByteArray) = apply { this.data = data }

        /**
         * The [MediaStreamDirection]
         */
        fun direction(@ObjCName("_") direction: MediaStreamDirection) = apply { this.direction = direction }

        /**
         * The [MimeType]
         */
        fun mimeType(@ObjCName("_") mimeType: String) = apply { this.mimeType = MimeType.find(mimeType) }

        /**
         * The file name for this media stream.
         */
        fun fileName(@ObjCName("_") fileName: String) = apply { this.fileName = fileName }

        /**
         * Constructs the [MediaStream] based on the provided properties.
         *
         * @throws IllegalStateException If the configuration for [MediaStream] is invalid.
         * @return An instance of [MediaStream].
         */
        @Throws(IllegalStateException::class)
        fun build(): MediaStream {
            // Checking data separately because ByteArrays passed to multiLet will become null
            // Also MimeType and MediaStreamDirection cause issues when using in muliLet
            // This is confirmed when using this lib with JavaScript and probably a Kotlin bug
            data?.let { data ->
                mimeType?.let { mimeType ->
                    direction?.let { direction ->
                        fileName?.let { fileName ->
                            return@build MediaStream(
                                data = data,
                                direction = direction,
                                mimeType = mimeType,
                                fileName = fileName
                            )
                        }
                    }
                }
            }
            throw IllegalStateException("Invalid configuration for MediaStream")
        }
    }
}
