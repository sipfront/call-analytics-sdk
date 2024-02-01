package com.sipfront.sdk.utils

internal object KotlinHelper {

    /**
     * ### Perform let operation on dynamic number of variables
     *
     * Example:
     *
     * ```
     * // will print
     * KotlinHelper.multiLet("Hello", "A", 9) {
     *  (first, second, third) ->
     *  println("$first $second $third")
     * }
     * ```
     *
     * ```
     * // wont print
     * KotlinHelper.multiLet("Hello", null, 9) {
     *  (first, second, third) ->
     *  println("$first $second $third")
     * }
     * ```
     *
     * Warning: Do not pass ByteArrays to this method, data will be erased.
     * Confirmed on JavaScript
     */
    inline fun <T: Any> multiLet(vararg elements: T?, closure: (List<T>) -> Unit) {
        if (elements.all { it != null }) {
            closure(elements.filterNotNull())
        }
    }

    /**
     * ### Perform Swift style guard operation on dynamic number of variables
     *
     * Example:
     *
     * ```
     * // will return
     * KotlinHelper.guardLet("Hello", "A", 9) { return }
     * println("Hello")
     * ```
     *
     * ```
     * // will print
     * KotlinHelper.guardLet("Hello", null, 9) { return }
     * println("Hello")
     * ```
     *
     * Warning: Do not pass ByteArrays to this method, data will be erased.
     * Confirmed on JavaScript
     */
    inline fun <T: Any> guardLet(vararg elements: T?, closure: () -> Nothing): List<T> {
        return if (elements.all { it != null }) {
            elements.filterNotNull()
        } else {
            closure()
        }
    }
}