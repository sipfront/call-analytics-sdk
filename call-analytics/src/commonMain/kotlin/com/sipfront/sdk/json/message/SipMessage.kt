package com.sipfront.sdk.json.message

import com.sipfront.sdk.interfaces.ProguardKeep
import com.sipfront.sdk.json.JsonKeys
import com.sipfront.sdk.json.message.base.BaseMessage
import com.sipfront.sdk.json.message.enums.MessageClass
import com.sipfront.sdk.json.message.enums.MessageType
import com.sipfront.sdk.utils.KotlinHelper
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.experimental.ExperimentalObjCName
import kotlin.native.ObjCName

/**
 * Message containing a SIP message
 */
@Serializable
@SerialName("SipMessage")
data class SipMessage internal constructor(
    @SerialName(JsonKeys.param)
    val message: String,
    @SerialName(JsonKeys.Message.type)
    override val type: MessageType.Sip,
    @SerialName(JsonKeys.Message.clazz)
    override val clazz: MessageClass,
    @SerialName(JsonKeys.Message.timestamp)
    override val timestamp: Double = currentTimeMillisFormatted()
) : BaseMessage() {
    @OptIn(ExperimentalObjCName::class)
    class Builder : ProguardKeep {
        private var message: String? = null
        private var type: MessageType.Sip? = null
        private val clazz: MessageClass = MessageClass.TRACE

        /**
         * The sent or received SIP message, mandatory property
         */
        fun message(@ObjCName("_") message: String) = apply { this.message = message }

        /**
         * The [MessageType], must be either [MessageType.Sip.INCOMING] or [MessageType.Sip.OUTGOING]
         */
        fun type(@ObjCName("_") type: MessageType.Sip) = apply { this.type = type }

        /**
         * Builds the [SipMessage]
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
