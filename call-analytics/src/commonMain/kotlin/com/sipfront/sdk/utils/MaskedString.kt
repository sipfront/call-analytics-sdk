package com.sipfront.sdk.utils

import com.sipfront.sdk.json.serializer.MaskedStringSerializer
import kotlinx.serialization.Serializable

/**
 * Implementation of [String] that will mask its [data] with [MASK] char after defined index when [toString] is called,
 * while still maintaining data during JSON serialization/deserialization.
 * Useful for preventing leaking of sensitive [data] like credentials when logging objects that contain these.
 *
 * @param data [String] that needs to be masked
 * @param index [Int] of [data] after which it should be masked, if not provided [DEFAULT_INDEX] is used as default
 *
 * @since 1.0.6
 * @author Dominik Ridjic
 */
@Serializable(with = MaskedStringSerializer::class)
class MaskedString(
    private val data: String,
    private val index: Int = DEFAULT_INDEX
) {
    companion object {
        /**
         * [Char] that will be used to mask sensitive data
         *
         * Value: '*'
         */
        private const val MASK: Char = '*'

        /**
         * Default index after which masking of sensitive data will start.
         *
         * Value: 3
         */
        private const val DEFAULT_INDEX: Int = 3
    }

    /**
     * Returns unmasked data [String]
     *
     * @return data [String] unmasked
     */
    fun unmasked() = data

    /**
     * Masks a [String] with [MASK] after given index
     *
     * @param data [String] to mask
     * @param index [Int] after which input shall be masked
     * @param data [String] masked
     */
    @Suppress("MemberVisibilityCanBePrivate")
    fun mask(data: String, index: Int): String {
        return data.mapIndexed { i, char -> if (i < index) char else MASK }.joinToString("")
    }

    /**
     * Function is overridden to prevent leaking of sensitive data when logging an object that contains this [MaskedString]
     */
    override fun toString(): String {
        return mask(data, index)
    }
}