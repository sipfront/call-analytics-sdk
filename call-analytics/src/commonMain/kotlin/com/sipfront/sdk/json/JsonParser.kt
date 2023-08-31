package com.sipfront.sdk.json

import com.sipfront.sdk.json.message.RtcpMessage
import com.sipfront.sdk.json.message.SdpMessage
import com.sipfront.sdk.json.message.SipMessage
import com.sipfront.sdk.json.message.StateMessage
import com.sipfront.sdk.json.message.base.BaseMessage
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.SerializationException
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.modules.SerializersModule
import kotlinx.serialization.modules.polymorphic
import kotlinx.serialization.modules.subclass

internal object JsonParser {
    @OptIn(ExperimentalSerializationApi::class)
    internal val json = Json {
        serializersModule = SerializersModule {
            polymorphic(BaseMessage::class) {
                subclass(RtcpMessage::class)
                subclass(SipMessage::class)
                subclass(SdpMessage::class)
                subclass(StateMessage::class)
            }
        }
        classDiscriminator = "internal"
        ignoreUnknownKeys = true
        encodeDefaults = true
        explicitNulls = false
        isLenient = true
        prettyPrint = true
    }
    @Throws(SerializationException::class, IllegalArgumentException::class)
    inline fun <reified T> toString(value: T): String {
        return json.encodeToString(value)
    }

    @Throws(SerializationException::class, IllegalArgumentException::class)
    inline fun <reified T> toObject(json: String): T {
        return this.json.decodeFromString<T>(json)
    }
}