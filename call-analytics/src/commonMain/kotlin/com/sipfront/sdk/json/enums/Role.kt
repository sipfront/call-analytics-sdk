package com.sipfront.sdk.json.enums

import com.sipfront.sdk.interfaces.EnumValue
import com.sipfront.sdk.json.serializer.RoleSerializer
import kotlinx.serialization.Serializable
import kotlin.experimental.ExperimentalObjCName
import kotlin.native.ObjCName

/**
 * Represents the possible roles in a call.
 *
 * This enum defines the role of a call, indicating if it's a [CALLER], a [CALLEE], or if there's no defined role ([NONE]).
 *
 * @property value The [String] representation of the role.
 *
 * @since 1.0.7
 * @author Dominik Ridjic
 */
@OptIn(ExperimentalObjCName::class)
@Serializable(with = RoleSerializer::class)
@ObjCName("Role")
enum class Role(override val value: String) : EnumValue {
    /**
     * Represents a caller.
     */
    CALLER(Value.caller),

    /**
     * Represents a callee.
     */
    CALLEE(Value.callee),

    /**
     * Represents an undefined role.
     */
    NONE(Value.none);

    internal object Value {
        const val caller: String = "caller"
        const val callee: String = "callee"
        const val none: String = "none"
    }

    /**
     * Inverts the current role.
     *
     * For instance, if the role is [CALLER], the inverted role would be [CALLEE].
     *
     * @return The [Role] representing the inverted role.
     */
    @Suppress("unused")
    internal fun invert(): Role = when (this) {
        CALLER -> CALLEE
        CALLEE -> CALLER
        NONE -> NONE
    }

    /**
     * Converts the [Role] to a [CallDirection].
     *
     * For instance, if we converted [Role.CALLER] the method would return [CallDirection.OUTGOING].
     *
     * @return The [CallDirection] representing the [Role].
     */
    @Suppress("unused")
    internal fun convert(): CallDirection = when (this) {
        CALLER -> CallDirection.OUTGOING
        CALLEE -> CallDirection.INCOMING
        NONE -> CallDirection.NONE
    }
}