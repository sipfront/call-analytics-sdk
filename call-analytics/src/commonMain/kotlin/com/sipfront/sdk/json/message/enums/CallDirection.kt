package com.sipfront.sdk.json.message.enums

import com.sipfront.sdk.interfaces.EnumValue
import com.sipfront.sdk.json.serializer.CallDirectionSerializer
import kotlinx.serialization.Serializable
import kotlin.experimental.ExperimentalObjCName
import kotlin.native.ObjCName

@OptIn(ExperimentalObjCName::class)
@Serializable(with = CallDirectionSerializer::class)
@ObjCName("Call")
enum class CallDirection(override val value: String): EnumValue {
    INCOMING(Value.incoming),
    OUTGOING(Value.outgoing),
    NONE(Value.none);

    internal object Value {
        const val incoming: String = "incoming"
        const val outgoing: String = "outgoing"
        const val none: String = "none"
    }

    fun invert(): CallDirection = when (this) {
        INCOMING -> OUTGOING
        OUTGOING -> INCOMING
        NONE -> NONE
    }
}