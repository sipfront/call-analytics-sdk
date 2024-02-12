package com.sipfront.sdk.json.enums

import com.sipfront.sdk.interfaces.ProguardKeep
import com.sipfront.sdk.json.JsonKeys
import com.sipfront.sdk.json.enums.MimeType.*
import com.sipfront.sdk.json.serializer.MimeTypeSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Represents the possible MIME-types for an individual [com.sipfront.sdk.json.media.MediaStream].
 *
 * @property raw The [String] representation of the MIME-type
 * @property mediaType The [MediaType] of the MIME-type
 * @property codec The [Codec] of the MIME-type
 * @property extension The [Extension] of the MIME-type
 *
 * @since 1.0.8
 * @author Dominik Ridjic
 */
@Suppress("SpellCheckingInspection")
@Serializable(with = MimeTypeSerializer::class)
@SerialName("MimeType")
internal enum class MimeType(
    @SerialName(JsonKeys.Media.Stream.MimeType.raw) val raw: String,
    @SerialName(JsonKeys.Media.Stream.MimeType.mediaType) val mediaType: MediaType,
    @SerialName(JsonKeys.Media.Stream.MimeType.extension) val extension: Extension,
    @SerialName(JsonKeys.Media.Stream.MimeType.codec) val codec: Codec? = null
) : ProguardKeep {
    OPUS(Value.AUDIO_OPUS, MediaType.AUDIO, Extension.WEBM, Codec.OPUS),
    PCMU(Value.AUDIO_PCMU, MediaType.AUDIO, Extension.WEBM, Codec.PCMU),
    PCMA(Value.AUDIO_PCMA, MediaType.AUDIO, Extension.WEBM, Codec.PCMA),
    ISAC(Value.AUDIO_ISAC, MediaType.AUDIO, Extension.WEBM, Codec.ISAC),
    G722(Value.AUDIO_G722, MediaType.AUDIO, Extension.WEBM, Codec.G722),
    VP9(Value.VIDEO_VP9, MediaType.VIDEO, Extension.WEBM, Codec.VP9),
    VP8(Value.VIDEO_VP8, MediaType.VIDEO, Extension.WEBM, Codec.VP8),
    HEV1(Value.VIDEO_HEV1, MediaType.VIDEO, Extension.MP4, Codec.H265),
    HVC1(Value.VIDEO_HVC1, MediaType.VIDEO, Extension.MP4, Codec.H265),
    AVC1(Value.VIDEO_AVC1, MediaType.VIDEO, Extension.MP4, Codec.H264),
    AV1(Value.VIDEO_AV1, MediaType.VIDEO, Extension.WEBM, Codec.AV1),
    AV01(Value.VIDEO_AV01, MediaType.VIDEO, Extension.MP4, Codec.AV1),
    AUDIO_UNKNOWN_WEBM(Value.AUDIO_UNKNOWN_WEBM, MediaType.AUDIO, Extension.WEBM),
    VIDEO_UNKNOWN_WEBM(Value.VIDEO_UNKNOWN_WEBM, MediaType.VIDEO, Extension.WEBM),
    VIDEO_UNKNOWN_MP4(Value.VIDEO_UNKNOWN_MP4, MediaType.VIDEO, Extension.MP4);

    internal object Value {
        const val AUDIO_OPUS = "audio/webm; codecs=opus"
        const val AUDIO_PCMU = "audio/webm; codecs=pcmu"
        const val AUDIO_PCMA = "audio/webm; codecs=pcma"
        const val AUDIO_ISAC = "audio/webm; codecs=isac"
        const val AUDIO_G722 = "audio/webm; codecs=g722"
        const val VIDEO_VP9 = "video/webm; codecs=vp9"
        const val VIDEO_VP8 = "video/webm; codecs=vp8"
        const val VIDEO_HEV1 = "video/mp4; codecs=hev1"
        const val VIDEO_HVC1 = "video/mp4; codecs=hvc1"
        const val VIDEO_AVC1 = "video/mp4; codecs=avc1"
        const val VIDEO_AV1 = "video/webm; codecs=av1"
        const val VIDEO_AV01 = "video/mp4; codecs=av01"
        const val AUDIO_UNKNOWN_WEBM = "audio/webm"
        const val VIDEO_UNKNOWN_WEBM = "video/webm"
        const val VIDEO_UNKNOWN_MP4 = "video/mp4"
    }

    companion object {
        internal fun parse(input: String): MimeType? = entries.find { it.raw == input }
    }

    @Serializable
    @SerialName("Codec")
    internal enum class Codec(
        @Suppress("unused")
        @SerialName(JsonKeys.Media.Stream.MimeType.Codec.displayName) val displayName: String
    ) : ProguardKeep {
        OPUS(DisplayName.OPUS),
        PCMU(DisplayName.PCMU),
        PCMA(DisplayName.PCMA),
        ISAC(DisplayName.ISAC),
        G722(DisplayName.G722),
        VP9(DisplayName.VP9),
        VP8(DisplayName.VP8),
        H265(DisplayName.H265),
        H264(DisplayName.H264),
        AV1(DisplayName.AV1);

        internal object DisplayName {
            const val OPUS = "Opus"
            const val PCMU = "G711 μ-law"
            const val PCMA = "G711 A-law"
            const val ISAC = "iSAC"
            const val G722 = "G.722"
            const val VP9 = "VP9"
            const val VP8 = "VP8"
            const val H265 = "H.265"
            const val H264 = "H.264"
            const val AV1 = "AV1"
        }
    }

    @Serializable
    internal enum class MediaType : ProguardKeep {
        AUDIO,
        VIDEO;
    }

    @Serializable
    internal enum class Extension : ProguardKeep {
        WEBM,
        MP4;
    }
}