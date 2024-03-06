package com.sipfront.sdk.json.config

import com.sipfront.sdk.CallAnalytics
import com.sipfront.sdk.interfaces.ProguardKeep
import com.sipfront.sdk.utils.Platform
import kotlinx.serialization.Serializable
import kotlin.experimental.ExperimentalObjCName
import kotlin.experimental.ExperimentalObjCRefinement
import kotlin.js.ExperimentalJsExport
import kotlin.js.JsExport
import kotlin.native.HiddenFromObjC
import kotlin.native.ObjCName

/**
 * Represents the configuration settings for [CallAnalytics].
 *
 * Encapsulates various configuration options such as enabling PJSUA, log parsing, debug logs, and certificate trust settings.
 *
 * @property logParser Indicates if the log parser should be enabled to automatically parse and send SIP/SDP messages from logs
 * @property debugLogs Indicates if debug logging should be enabled.
 * @property debugHttpLogs Indicates if debug HTTP logging should be enabled.
 * @property trustAllCerts If set to true, the library will trust all certificates in HTTP requests.
 *
 * @since 1.0.0
 * @author Dominik Ridjic
 */
@OptIn(ExperimentalObjCName::class, ExperimentalJsExport::class)
@Suppress("DataClassPrivateConstructor")
@Serializable
@JsExport
data class SdkConfig private constructor(
    internal val enablePjsua: Boolean,
    val logParser: Boolean,
    val debugLogs: Boolean,
    val debugHttpLogs: Boolean,
    val trustAllCerts: Boolean
) : ProguardKeep {
    /**
     * Builder class for [SdkConfig].
     *
     * Provides a fluent API to set various properties for the [SdkConfig] and then build it.
     */
    @Suppress("unused")
    @OptIn(ExperimentalObjCRefinement::class)
    class Builder : ProguardKeep {
        private var pjsua: Boolean = false
        private var logParser: Boolean = false
        private var debugLogs: Boolean = Platform.isDebug()
        private var debugHttpLogs: Boolean = Platform.isDebug()
        private var trustAllCerts: Boolean = Platform.isDebug()

        @HiddenFromObjC
        @ObjCName("enablePjsua")
        private fun pjsua(@ObjCName("_") enable: Boolean) = apply { this.pjsua = enable }

        /**
         * Enables the [com.sipfront.sdk.log.parser.LogParser] to automatically parse and SIP/SDP messages from logs.
         *
         * @param enable Boolean flag to enable or disable the log parser.
         */
        @HiddenFromObjC
        @ObjCName("enableLogParser")
        fun logParser(@ObjCName("_") enable: Boolean) = apply { this.logParser = enable }

        /**
         * Enables or disables debug logging.
         *
         * @param enable Boolean flag to enable or disable debug logs.
         */
        @ObjCName("enableDebugLogs")
        fun debugLogs(@ObjCName("_") enable: Boolean) = apply { this.debugLogs = enable }

        /**
         * Enables or disables HTTP debug logging.
         *
         * @param enable Boolean flag to enable or disable HTTP debug logs.
         */
        @ObjCName("enableDebugHttpLogs")
        fun debugHttpLogs(@ObjCName("_") enable: Boolean) = apply { this.debugHttpLogs = enable }

        /**
         * Sets the library to trust all certificates in HTTP requests.
         *
         * @param trustAllCerts Boolean flag to trust or not trust all certificates.
         */
        fun trustAllCerts(@ObjCName("_") trustAllCerts: Boolean) = apply { this.trustAllCerts = trustAllCerts }

        /**
         * Constructs the [SdkConfig] based on the provided properties.
         *
         * @return An instance of [SdkConfig].
         */
        fun build(): SdkConfig {
            return SdkConfig(pjsua, logParser, debugLogs, debugHttpLogs, trustAllCerts)
        }
    }
}