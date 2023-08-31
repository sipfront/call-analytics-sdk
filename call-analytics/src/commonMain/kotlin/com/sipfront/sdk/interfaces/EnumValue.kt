package com.sipfront.sdk.interfaces

/**
 * [Enum]s that are serialised with [com.sipfront.sdk.json.adapter.EnumJsonAdapter] must implement
 * this interface
 */
interface EnumValue : ProguardKeep {
    val value: String
}