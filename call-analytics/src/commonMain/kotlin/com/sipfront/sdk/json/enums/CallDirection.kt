package com.sipfront.sdk.json.enums

import com.sipfront.sdk.interfaces.EnumValue
import com.sipfront.sdk.json.serializer.CallDirectionSerializer
import kotlinx.serialization.Serializable
import kotlin.experimental.ExperimentalObjCName
import kotlin.native.ObjCName

/**
 * Represents the possible directions of a call.
 *
 * This enum defines the directionality of a call, indicating if it's an incoming call, an outgoing call, or if there's no specific direction.
 *
 * @property value The [String] representation of the call direction.
 */
@OptIn(ExperimentalObjCName::class)
@Serializable(with = CallDirectionSerializer::class)
@ObjCName("Call")
enum class CallDirection(override val value: String) : EnumValue {
    /**
     * Represents an incoming call.
     */
    INCOMING(Value.incoming),

    /**
     * Represents an outgoing call.
     */
    OUTGOING(Value.outgoing),

    /**
     * Represents a call with no specific direction.
     */
    NONE(Value.none);

    internal object Value {
        const val incoming: String = "incoming"
        const val outgoing: String = "outgoing"
        const val none: String = "none"
    }

    /**
     * Inverts the current call direction.
     *
     * For instance, if the current direction is [INCOMING], the inverted direction would be [OUTGOING].
     *
     * @return The [CallDirection] representing the inverted direction.
     */
    @Suppress("unused")
    internal fun invert(): CallDirection = when (this) {
        INCOMING -> OUTGOING
        OUTGOING -> INCOMING
        NONE -> NONE
    }

    /**
     * Converts the [CallDirection] to a [Role].
     *
     * For instance, if we converted [CallDirection.OUTGOING] the method would return [Role.CALLER].
     *
     * @return The [Role] representing the [CallDirection].
     */
    @Suppress("unused")
    internal fun convert(): Role = when (this) {
        INCOMING -> Role.CALLEE
        OUTGOING -> Role.CALLER
        NONE -> Role.NONE
    }
}