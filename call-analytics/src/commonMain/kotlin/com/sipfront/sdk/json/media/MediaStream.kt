package com.sipfront.sdk.json.media

import com.sipfront.sdk.interfaces.ProguardKeep
import com.sipfront.sdk.json.JsonKeys
import com.sipfront.sdk.json.enums.MediaStreamDirection
import com.sipfront.sdk.json.enums.MediaStreamKind
import com.sipfront.sdk.json.media.MediaStream.Builder
import com.sipfront.sdk.utils.KotlinHelper
import com.sipfront.sdk.utils.currentTimeMillisFormatted
import kotlinx.datetime.Clock
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.experimental.ExperimentalObjCName
import kotlin.js.ExperimentalJsExport
import kotlin.js.JsExport
import kotlin.native.ObjCName

/**
 * Represents a media stream containing the stream recording, kind and direction.
 *
 * @property data The media stream raw data.
 * @property kind The type of the media stream, either audio or video.
 * @property direction the media stream, either outgoing or incoming
 * @property mimeType the media stream mime-type, for example, "audio/webm" or "audio/webm; codecs=opus"
 * @property mimeTypeBase the media stream bas mime-type without optional codec element, for example, "audio/webm"
 * @property codec the optional mime-type codec element, for example, "opus"
 * @property fileName the file name generated for this media stream
 * @property timestamp The timestamp when the message was created or received.
 *
 * @throws IllegalStateException If [data], [kind], [direction] or [mimeType] is missing before calling [Builder.build]
 *
 * @since 1.0.7
 * @author Dominik Ridjic
 */
@Suppress("NON_EXPORTABLE_TYPE")
@OptIn(ExperimentalJsExport::class)
@Serializable
@SerialName("MediaStream")
@JsExport
data class MediaStream internal constructor(
    @SerialName(JsonKeys.Media.Stream.data) val data: ByteArray,
    @SerialName(JsonKeys.Media.Stream.kind) val kind: MediaStreamKind,
    @SerialName(JsonKeys.Media.Stream.direction) val direction: MediaStreamDirection,
    @SerialName(JsonKeys.Media.Stream.mimeType) val mimeType: String,
    @SerialName(JsonKeys.Media.Stream.mimeTypeBase) val mimeTypeBase: String,
    @SerialName(JsonKeys.Media.Stream.codec) val codec: String?,
    @SerialName(JsonKeys.Media.Stream.fileName) val fileName: String,
    @SerialName(JsonKeys.timestamp) val timestamp: Double = currentTimeMillisFormatted(),
) {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || this::class != other::class) return false

        other as MediaStream

        if (!data.contentEquals(other.data)) return false
        if (kind != other.kind) return false
        if (direction != other.direction) return false
        if (mimeType != other.mimeType) return false
        if (mimeTypeBase != other.mimeTypeBase) return false
        if (codec != other.codec) return false
        if (fileName != other.fileName) return false
        if (timestamp != other.timestamp) return false

        return true
    }

    override fun hashCode(): Int {
        var result = data.contentHashCode()
        result = 31 * result + kind.hashCode()
        result = 31 * result + direction.hashCode()
        result = 31 * result + mimeType.hashCode()
        result = 31 * result + mimeTypeBase.hashCode()
        result = 31 * result + (codec?.hashCode() ?: 0)
        result = 31 * result + fileName.hashCode()
        result = 31 * result + timestamp.hashCode()
        return result
    }

    /**
     * Builder class for [MediaStream].
     *
     * Provides a fluent API to set various properties for the [MediaStream] and then build it.
     */
    @OptIn(ExperimentalObjCName::class)
    class Builder : ProguardKeep {
        private var data: ByteArray? = null
        private var kind: MediaStreamKind? = null
        private var direction: MediaStreamDirection? = null
        private var mimeType: String? = null

        /**
         * The audio or video data of the [MediaStream] as [ByteArray]
         */
        fun data(@ObjCName("_") data: ByteArray) = apply { this.data = data }

        /**
         * The [MediaStreamKind]
         */
        fun kind(@ObjCName("_") kind: MediaStreamKind) = apply { this.kind = kind }

        /**
         * The [MediaStreamDirection]
         */
        fun direction(@ObjCName("_") direction: MediaStreamDirection) = apply { this.direction = direction }

        /**
         * The mime-type
         */
        fun mimeType(@ObjCName("_") mimeType: String) = apply { this.mimeType = mimeType }


        private fun getBaseMimeType(mimeType: String): String = mimeType.substringBefore(delimiter = ";")

        private fun getCodec(mimeType: String): String? =
            mimeType.substringAfter(delimiter = "; ", missingDelimiterValue = "").substringAfter("=").let {
                it.ifEmpty { null }
            }

        private fun getExtension(mimeType: String): String = getBaseMimeType(mimeType).substringAfter(delimiter = "/")

        private fun getFileName(mimeType: String, mediaStreamDirection: MediaStreamDirection): String {
            val date = getFormattedTimestamp()
            val direction = mediaStreamDirection.toTypeAbbreviated()
            val extension = getExtension(mimeType)
            return "dump-$date-$direction.$extension"
        }

        private fun getFormattedTimestamp(): String {
            val current = Clock.System.now().toLocalDateTime(TimeZone.currentSystemDefault())
            return current.toFormattedString()
        }

        private fun LocalDateTime.toFormattedString(): String {
            return "${this.year}-${this.monthNumber.toString().padStart(2, '0')}-${
                this.dayOfMonth.toString().padStart(2, '0')
            }-${this.hour.toString().padStart(2, '0')}-${this.minute.toString().padStart(2, '0')}-${
                this.second.toString().padStart(2, '0')
            }"
        }

        /**
         * Constructs the [MediaStream] based on the provided properties.
         *
         * @throws IllegalStateException If the configuration for [MediaStream] is invalid.
         * @return An instance of [MediaStream].
         */
        @Throws(IllegalStateException::class)
        fun build(): MediaStream {
            // Checking data separately because ByteArrays passed to multiLet will become null
            // This is confirmed when using this lib with JavaScript and probably a Kotlin bug
            data?.let { data ->
                KotlinHelper.multiLet(kind, direction, mimeType) { (kind, direction, mimeType) ->
                    return@build MediaStream(
                        data = data,
                        kind = kind as MediaStreamKind,
                        direction = direction as MediaStreamDirection,
                        mimeType = mimeType as String,
                        mimeTypeBase = getBaseMimeType(mimeType = mimeType),
                        codec = getCodec(mimeType = mimeType),
                        fileName = getFileName(mimeType = mimeType, mediaStreamDirection = direction)
                    )
                }
            }
            throw IllegalStateException("Invalid configuration for MediaStream")
        }
    }
}
