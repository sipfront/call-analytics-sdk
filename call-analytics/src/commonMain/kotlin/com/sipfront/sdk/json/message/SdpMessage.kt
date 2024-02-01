package com.sipfront.sdk.json.message

import com.sipfront.sdk.interfaces.ProguardKeep
import com.sipfront.sdk.json.JsonKeys
import com.sipfront.sdk.json.message.SdpMessage.Builder
import com.sipfront.sdk.json.message.base.BaseMessage
import com.sipfront.sdk.json.enums.MessageClass
import com.sipfront.sdk.json.enums.MessageType
import com.sipfront.sdk.utils.KotlinHelper
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.experimental.ExperimentalObjCName
import kotlin.js.ExperimentalJsExport
import kotlin.js.JsExport
import kotlin.native.ObjCName

/**
 * Represents a message containing Session Description Protocol (SDP) data.
 *
 * This data class encapsulates SDP-related parameters, including the actual SDP message, its type, and an associated timestamp.
 *
 * @property message The actual SDP message content.
 * @property type The type of the SDP message, either incoming or outgoing.
 * @property timestamp The timestamp when the message was created or received.
 *
 * @throws IllegalStateException If [message] or [type] is missing before calling [Builder.build]
 *
 * @since 1.0.0
 * @author Dominik Ridjic
 */
@OptIn(ExperimentalJsExport::class)
@Suppress("NON_EXPORTABLE_TYPE")
@Serializable
@SerialName("SdpMessage")
@JsExport
data class SdpMessage internal constructor(
    @SerialName(JsonKeys.param) val message: String,
    @SerialName(JsonKeys.Message.type) override val type: MessageType.Sdp,
    @SerialName(JsonKeys.Message.clazz) override val clazz: MessageClass = MessageClass.TRACE,
    @SerialName(JsonKeys.Message.timestamp) override val timestamp: Double = currentTimeMillisFormatted()
) : BaseMessage() {
    /**
     * Builder class for [SdpMessage].
     *
     * Provides a fluent API to set various properties for the [SdpMessage] and then build it.
     */
    @OptIn(ExperimentalObjCName::class)
    class Builder : ProguardKeep {
        private var message: String? = null
        private var type: MessageType.Sdp? = null

        /**
         * Sent or received SDP message, mandatory property
         */
        fun message(@ObjCName("_") message: String) = apply { this.message = message }


        /**
         * The [MessageType], must be either [MessageType.Sdp.INCOMING] or [MessageType.Sdp.OUTGOING]
         */
        fun type(@ObjCName("_") type: MessageType.Sdp) = apply { this.type = type }

        /**
         * Constructs the [SdpMessage] based on the provided properties.
         *
         * @throws IllegalStateException If the configuration for [SdpMessage] is invalid.
         * @return An instance of [SdpMessage].
         */
        @Throws(IllegalStateException::class)
        fun build(): SdpMessage {
            KotlinHelper.multiLet(message, type) { (message, type) ->
                return@build SdpMessage(
                    message = message as String,
                    type = type as MessageType.Sdp
                )
            }
            throw IllegalStateException("Invalid configuration for SdpMessage")
        }
    }
}
