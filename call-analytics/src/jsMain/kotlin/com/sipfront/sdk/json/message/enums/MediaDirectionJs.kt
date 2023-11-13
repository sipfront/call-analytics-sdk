package com.sipfront.sdk.json.message.enums

/**
 * This is a JavaScript wrapper for [MediaDirection]
 *
 * Required because KMM cannot yet convert Enums to JavaScript code
 *
 * @since 1.0.6
 * @author Dominik Ridjic
 */
@Suppress("NON_EXPORTABLE_TYPE")
@OptIn(ExperimentalJsExport::class)
@JsExport
object MediaDirectionJs {
    val SEND_RECEIVE = MediaDirection.SEND_RECEIVE
    val RECEIVE_ONLY = MediaDirection.RECEIVE_ONLY
    val SEND_ONLY = MediaDirection.SEND_ONLY
    val INACTIVE = MediaDirection.INACTIVE
}