package com.sipfront.sdk.json.enums

/**
 * This is a JavaScript wrapper for [MediaStreamKind]
 *
 * Required because KMM cannot yet convert Enums to JavaScript code
 *
 * @since 1.0.7
 * @author Dominik Ridjic
 */
@Suppress("NON_EXPORTABLE_TYPE")
@OptIn(ExperimentalJsExport::class)
@JsExport
object MediaStreamKindJs {
    val AUDIO = MediaStreamKind.AUDIO
    val VIDEO = MediaStreamKind.VIDEO
    val NONE = MediaStreamKind.NONE
}