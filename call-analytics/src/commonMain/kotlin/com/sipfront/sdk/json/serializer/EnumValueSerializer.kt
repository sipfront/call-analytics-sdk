package com.sipfront.sdk.json.serializer

import com.sipfront.sdk.interfaces.EnumValue
import com.sipfront.sdk.interfaces.ProguardKeep
import com.sipfront.sdk.json.message.enums.*
import kotlinx.serialization.KSerializer
import kotlinx.serialization.SerializationException
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

internal abstract class EnumValueSerializer<T : EnumValue>(private val enumValues: Array<T>) : KSerializer<T>, ProguardKeep {
    override val descriptor: SerialDescriptor = PrimitiveSerialDescriptor(EnumValue::class.simpleName!!, PrimitiveKind.STRING)

    override fun serialize(encoder: Encoder, value: T) {
        encoder.encodeString(value.value)
    }

    override fun deserialize(decoder: Decoder): T {
        val value = decoder.decodeString()
        return enumValues.find { it.value == value }
            ?: throw SerializationException("$value is not a valid enum value.")
    }
}

internal class MessageClassSerializer : EnumValueSerializer<MessageClass>(MessageClass.entries.toTypedArray())
internal class CallDirectionSerializer : EnumValueSerializer<CallDirection>(CallDirection.entries.toTypedArray())
internal class MediaDirectionSerializer : EnumValueSerializer<MediaDirection>(MediaDirection.entries.toTypedArray())
internal class RtcpSerializer : EnumValueSerializer<MessageType.Rtcp>(MessageType.Rtcp.entries.toTypedArray())
internal class SipSerializer : EnumValueSerializer<MessageType.Sip>(MessageType.Sip.entries.toTypedArray())
internal class SdpSerializer : EnumValueSerializer<MessageType.Sdp>(MessageType.Sdp.entries.toTypedArray())
internal class StateSerializer : EnumValueSerializer<MessageType.State>(MessageType.State.entries.toTypedArray())
