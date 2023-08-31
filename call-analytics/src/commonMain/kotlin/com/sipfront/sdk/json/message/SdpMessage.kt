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
 * Message containing SDP
 */
@Serializable
@SerialName("SdpMessage")
data class SdpMessage internal constructor(
    @SerialName(JsonKeys.param) val message: String,
    @SerialName(JsonKeys.Message.type) override val type: MessageType.Sdp,
    @SerialName(JsonKeys.Message.clazz) override val clazz: MessageClass = MessageClass.TRACE,
    @SerialName(JsonKeys.Message.timestamp) override val timestamp: Double = currentTimeMillisFormatted()
) : BaseMessage() {
    @OptIn(ExperimentalObjCName::class)
    class Builder : ProguardKeep {
        private var message: String? = null
        private var type: MessageType.Sdp? = null

        /**
         * The sent or received SDP message, mandatory property
         */
        fun message(@ObjCName("_") message: String) = apply { this.message = message }


        /**
         * The [MessageType], must be either [MessageType.Sdp.INCOMING] or [MessageType.Sdp.OUTGOING]
         */
        fun type(@ObjCName("_") type: MessageType.Sdp) = apply { this.type = type }

        /**
         * Builds the [SdpMessage]
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
