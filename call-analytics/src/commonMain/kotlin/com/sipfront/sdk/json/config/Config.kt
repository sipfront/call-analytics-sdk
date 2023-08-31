package com.sipfront.sdk.json.config

import com.sipfront.sdk.interfaces.ProguardKeep
import com.sipfront.sdk.utils.Platform
import com.sipfront.sdk.CallAnalytics
import kotlinx.serialization.Serializable
import kotlin.experimental.ExperimentalObjCName
import kotlin.experimental.ExperimentalObjCRefinement
import kotlin.native.HiddenFromObjC
import kotlin.native.ObjCName

/**
 * Configuration for [CallAnalytics]
 */
@OptIn(ExperimentalObjCName::class)
@Suppress("DataClassPrivateConstructor")
@Serializable
data class Config private constructor(
    internal val enablePjsua: Boolean,
    val enableLogParser: Boolean,
    val enableDebugLogs: Boolean,
    val trustAllCerts: Boolean
) : ProguardKeep {
    @OptIn(ExperimentalObjCRefinement::class)
    class Builder : ProguardKeep {
        private var enablePjsua: Boolean = false
        private var enableLogParser: Boolean = false
        private var enableDebugLogs: Boolean = Platform.isDebug()
        private var trustAllCerts: Boolean = Platform.isDebug()

        @HiddenFromObjC
        private fun enablePjsua(@ObjCName("_") enable: Boolean) = apply { this.enablePjsua = enable }

        /**
         * Enables [com.sipfront.sdk.log.parser.LogParser] that will parse SIP/SDP messages from Android
         * logs and send them to Sipfront
         */
        @HiddenFromObjC
        fun enableLogParser(@ObjCName("_") enable: Boolean) = apply { this.enableLogParser = enable }

        /**
         * Enables debug logging
         */
        fun enableDebugLogs(@ObjCName("_") enable: Boolean) = apply { this.enableDebugLogs = enable }

        /**
         * If true library will trust all certs in HTTP requests
         */
        fun trustAllCerts(@ObjCName("_") trustAllCerts: Boolean) = apply { this.trustAllCerts = trustAllCerts }

        fun build(): Config {
            return Config(enablePjsua, enableLogParser, enableDebugLogs, trustAllCerts)
        }
    }
}