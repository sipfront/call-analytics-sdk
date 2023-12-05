package com.sipfront.sdk.utils

import com.sipfront.sdk.json.serializer.MaskedStringSerializer
import kotlinx.serialization.Serializable

@Serializable(with = MaskedStringSerializer::class)
class MaskedString(
    private val original: String,
    private val position: Int = 3
) {

    fun getOriginal() = original

    override fun toString(): String {
        return maskString(original, position)
    }

    /**
     * Masks a [String] with "*" after given index
     *
     * @param [String] input to mask
     * @param [Int] position after which input shall be masked
     * @param [String] masked output
     */
    private fun maskString(input: String, position: Int): String {
        return input.mapIndexed { index, c -> if (index < position) c else '*' }.joinToString("")
    }
}