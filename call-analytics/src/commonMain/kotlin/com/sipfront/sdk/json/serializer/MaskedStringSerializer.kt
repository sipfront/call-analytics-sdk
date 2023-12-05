package com.sipfront.sdk.json.serializer

import com.sipfront.sdk.utils.MaskedString
import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

// Custom serializer for MaskedString
object MaskedStringSerializer : KSerializer<MaskedString> {
    override val descriptor: SerialDescriptor = PrimitiveSerialDescriptor("MaskedString", PrimitiveKind.STRING)

    override fun serialize(encoder: Encoder, value: MaskedString) {
        encoder.encodeString(value.getOriginal())
    }

    override fun deserialize(decoder: Decoder): MaskedString {
        return MaskedString(decoder.decodeString())
    }
}