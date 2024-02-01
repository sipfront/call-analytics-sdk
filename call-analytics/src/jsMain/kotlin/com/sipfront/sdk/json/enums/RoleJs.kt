package com.sipfront.sdk.json.enums

/**
 * This is a JavaScript wrapper for [Role]
 *
 * Required because KMM cannot yet convert Enums to JavaScript code
 *
 * @since 1.0.7
 * @author Dominik Ridjic
 */
@Suppress("NON_EXPORTABLE_TYPE")
@OptIn(ExperimentalJsExport::class)
@JsExport
object RoleJs {
    val CALLER = Role.CALLER
    val CALLEE = Role.CALLEE
    val NONE = Role.NONE
}