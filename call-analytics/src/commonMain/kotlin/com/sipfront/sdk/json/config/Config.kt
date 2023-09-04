package com.sipfront.sdk.json.config

import com.sipfront.sdk.CallAnalytics
import com.sipfront.sdk.interfaces.ProguardKeep
import com.sipfront.sdk.utils.Platform
import kotlinx.serialization.Serializable
import kotlin.experimental.ExperimentalObjCName
import kotlin.experimental.ExperimentalObjCRefinement
import kotlin.native.HiddenFromObjC
import kotlin.native.ObjCName

/**
 * Represents the configuration settings for [CallAnalytics].
 *
 * Encapsulates various configuration options such as enabling PJSUA, log parsing, debug logs, and certificate trust settings.
 *
 * @property enableLogParser Indicates if the log parser should be enabled to automatically parse and send SIP/SDP messages from logs
 * @property enableDebugLogs Indicates if debug logging should be enabled.
 * @property trustAllCerts If set to true, the library will trust all certificates in HTTP requests.
 *
 * @since 1.0.0
 * @author Dominik Ridjic
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
    /**
     * Builder class for [Config].
     *
     * Provides a fluent API to set various properties for the [Config] and then build it.
     */
    @OptIn(ExperimentalObjCRefinement::class)
    class Builder : ProguardKeep {
        private var enablePjsua: Boolean = false
        private var enableLogParser: Boolean = false
        private var enableDebugLogs: Boolean = Platform.isDebug()
        private var trustAllCerts: Boolean = Platform.isDebug()

        @HiddenFromObjC
        private fun enablePjsua(@ObjCName("_") enable: Boolean) = apply { this.enablePjsua = enable }

        /**
         * Enables the [com.sipfront.sdk.log.parser.LogParser] to automatically parse and SIP/SDP messages from logs.
         *
         * @param enable Boolean flag to enable or disable the log parser.
         */
        @HiddenFromObjC
        fun enableLogParser(@ObjCName("_") enable: Boolean) = apply { this.enableLogParser = enable }

        /**
         * Enables or disables debug logging.
         *
         * @param enable Boolean flag to enable or disable debug logs.
         */
        fun enableDebugLogs(@ObjCName("_") enable: Boolean) = apply { this.enableDebugLogs = enable }

        /**
         * Sets the library to trust all certificates in HTTP requests.
         *
         * @param trustAllCerts Boolean flag to trust or not trust all certificates.
         */
        fun trustAllCerts(@ObjCName("_") trustAllCerts: Boolean) = apply { this.trustAllCerts = trustAllCerts }

        /**
         * Constructs the [Config] based on the provided properties.
         *
         * @return An instance of [Config].
         */
        fun build(): Config {
            return Config(enablePjsua, enableLogParser, enableDebugLogs, trustAllCerts)
        }
    }
}