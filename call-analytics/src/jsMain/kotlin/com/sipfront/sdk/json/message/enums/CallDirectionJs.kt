package com.sipfront.sdk.json.message.enums

/**
 * This is a JavaScript wrapper for [CallDirection]
 *
 * Required because KMM cannot yet convert Enums to JavaScript code
 *
 * @since 1.0.6
 * @author Dominik Ridjic
 */
@Suppress("NON_EXPORTABLE_TYPE")
@OptIn(ExperimentalJsExport::class)
@JsExport
object CallDirectionJs {
    val INCOMING = CallDirection.INCOMING
    val OUTGOING = CallDirection.OUTGOING
    val NONE = CallDirection.NONE
}