package com.sipfront.sdk.json.message

import com.sipfront.sdk.interfaces.ProguardKeep
import com.sipfront.sdk.json.JsonKeys
import com.sipfront.sdk.json.message.SipMessage.Builder
import com.sipfront.sdk.json.message.base.BaseMessage
import com.sipfront.sdk.json.enums.MessageClass
import com.sipfront.sdk.json.enums.MessageType
import com.sipfront.sdk.utils.KotlinHelper
import com.sipfront.sdk.utils.currentTimeMillisFormatted
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.experimental.ExperimentalObjCName
import kotlin.js.ExperimentalJsExport
import kotlin.js.JsExport
import kotlin.native.ObjCName

/**
 * Represents a message containing Session Initiation Protocol (SIP) data.
 *
 * This data class encapsulates SIP-related parameters including the actual SIP message, its type, and associated timestamp.
 *
 * @property message The actual SIP message content.
 * @property type The type of the SIP message, either incoming or outgoing.
 * @property timestamp The timestamp when the message was created or received.
 *
 * @throws IllegalStateException If [message] or [type] is missing before calling [Builder.build]
 *
 * @since 1.0.0
 * @author Dominik Ridjic
 */
@Suppress("NON_EXPORTABLE_TYPE")
@OptIn(ExperimentalJsExport::class)
@Serializable
@SerialName("SipMessage")
@JsExport
data class SipMessage internal constructor(
    @SerialName(JsonKeys.param)
    val message: String,
    @SerialName(JsonKeys.Message.type)
    override val type: MessageType.Sip,
    @SerialName(JsonKeys.Message.clazz)
    override val clazz: MessageClass,
    @SerialName(JsonKeys.timestamp)
    override val timestamp: Double = currentTimeMillisFormatted()
) : BaseMessage() {
    /**
     * Builder class for [SipMessage].
     *
     * Provides a fluent API to set various properties for the [SipMessage] and then build it.
     */
    @OptIn(ExperimentalObjCName::class)
    class Builder : ProguardKeep {
        private var message: String? = null
        private var type: MessageType.Sip? = null
        private val clazz: MessageClass = MessageClass.TRACE

        /**
         * Sent or received SIP message, mandatory property
         */
        fun message(@ObjCName("_") message: String) = apply { this.message = message }

        /**
         * The [MessageType], must be either [MessageType.Sip.INCOMING] or [MessageType.Sip.OUTGOING]
         */
        fun type(@ObjCName("_") type: MessageType.Sip) = apply { this.type = type }

        /**
         * Constructs the [SipMessage] based on the provided properties.
         *
         * @throws IllegalStateException If the configuration for [SipMessage] is invalid.
         * @return An instance of [SipMessage].
         */
        @Throws(IllegalStateException::class)
        fun build(): SipMessage {
            KotlinHelper.multiLet(message, type) { (message, type) ->
                return@build SipMessage(
                    type = type as MessageType.Sip,
                    clazz = clazz,
                    message = message as String
                )
            }
            throw IllegalStateException("Invalid configuration for SipMessage")
        }
    }
}
