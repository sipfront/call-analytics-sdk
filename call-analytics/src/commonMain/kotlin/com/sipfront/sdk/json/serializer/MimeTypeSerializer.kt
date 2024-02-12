package com.sipfront.sdk.json.serializer

import com.sipfront.sdk.json.enums.MimeType
import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.descriptors.buildClassSerialDescriptor
import kotlinx.serialization.descriptors.element
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder


/**
 * Custom [KSerializer] for [MimeType]
 *
 * @since 1.0.8
 * @author Dominik Ridjic
 */
internal object MimeTypeSerializer : KSerializer<MimeType> {
    override val descriptor: SerialDescriptor = buildClassSerialDescriptor("MimeType") {
        element<String>("raw")
        element<String>("mediaType")
        element<String>("extension")
        element<String>("codec", isOptional = true) // Codec can be null
    }

    override fun serialize(encoder: Encoder, value: MimeType) {
        val compositeOutput = encoder.beginStructure(descriptor)
        compositeOutput.encodeStringElement(descriptor, 0, value.raw)
        compositeOutput.encodeStringElement(descriptor, 1, value.mediaType.name)
        compositeOutput.encodeStringElement(descriptor, 2, value.extension.name)
        value.codec?.let { codec ->
            compositeOutput.encodeStringElement(descriptor, 3, codec.name)
        }
        compositeOutput.endStructure(descriptor)
    }

    override fun deserialize(decoder: Decoder): MimeType {
        throw UnsupportedOperationException("Deserialization not supported for MimeType")
    }
}