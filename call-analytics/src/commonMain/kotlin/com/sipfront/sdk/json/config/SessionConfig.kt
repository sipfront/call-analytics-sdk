package com.sipfront.sdk.json.config

import com.sipfront.sdk.BuildKonfig
import com.sipfront.sdk.json.JsonKeys
import com.sipfront.sdk.utils.MaskedString
import com.sipfront.sdk.utils.randomUUID
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Holds data that is required to do API/MQTT requests to Sipfront
 */
@Serializable
internal data class SessionConfig(
    /**
     * The credentials for HTTP Auth required for MQTT messages to be accepted
     */
    @SerialName(JsonKeys.SessionConfig.credentials) val credentials: Credentials,
    /**
     * The Sipfront Agents sessionId
     */
    @SerialName(JsonKeys.SessionConfig.sessionId) val sessionId: String,
    /**
     * The Sipfront Agents instanceId
     */
    @SerialName(JsonKeys.SessionConfig.instanceId) val instanceId: String,
    /**
     * The Sipfront Agents role
     */
    @SerialName(JsonKeys.SessionConfig.role) val role: String,
    /**
     * The server address
     */
    @SerialName(JsonKeys.SessionConfig.server) val server: String,
    /**
     * The URL path where RTCP messages will be sent to
     */
    @SerialName(JsonKeys.SessionConfig.mqttRtcpPath) val mqttRtcpPath: String,
    /**
     * The URL path where SIP messages will be sent to
     */
    @SerialName(JsonKeys.SessionConfig.mqttSipPath) val mqttSipPath: String,
    /**
     * The Sipfront API URL
     */
    @SerialName(JsonKeys.SessionConfig.sipfrontApi) val sipfrontApi: String,
    /**
     * The Sipfront API Token required to communicate with the API
     */
    @SerialName(JsonKeys.SessionConfig.sipfrontApiToken) val sipfrontApiToken: MaskedString
) {
    /**
     * The purpose of this block is to provide a static method that will generate debug data
     */
    internal companion object {
        @OptIn(kotlin.js.ExperimentalJsExport::class)
        private val OVERRIDE_SESSION_ID: String = randomUUID()
        @OptIn(kotlin.js.ExperimentalJsExport::class)
        private val OVERRIDE_INSTANCE_ID: String = randomUUID()
        private const val BASE_PATH: String = "/topics/\$aws/rules/data_rule/dt/agent/"
        private const val AMZN_IOT_QOS: Int = 1
        private const val AMZN_IOT_AUTH: String = "sipfront-agentpool-authorizer"
        private const val AMZN_IOT_AUTH_NAME: String = "x-amz-customauthorizer-name"
        private val OVERRIDE_MQTT_RTCP_PATH: String =
            "$BASE_PATH${BuildKonfig.SIPFRONT_API_DEBUG_USER}/$OVERRIDE_INSTANCE_ID/$OVERRIDE_SESSION_ID/caller/rtp?qos=$AMZN_IOT_QOS&$AMZN_IOT_AUTH_NAME=$AMZN_IOT_AUTH"
        private val OVERRIDE_MQTT_SIP_PATH: String =
            "$BASE_PATH${BuildKonfig.SIPFRONT_API_DEBUG_USER}/$OVERRIDE_INSTANCE_ID/$OVERRIDE_SESSION_ID/caller/baresip?qos=$AMZN_IOT_QOS&$AMZN_IOT_AUTH_NAME=$AMZN_IOT_AUTH"
        private val OVERRIDE_SIPFRONT_API_URL = BuildKonfig.SIPFRONT_API_DEBUG_URL
        private val OVERRIDE_SIPFRONT_API_TOKEN = BuildKonfig.SIPFRONT_API_DEBUG_TOKEN
        private const val OVERRIDE_ROLE = "caller"

        /**
         * Provides [SessionConfig] from hardcoded data for debug purposes
         */
        internal fun debugData(): SessionConfig {
            return SessionConfig(
                credentials = Credentials(
                    username = MaskedString(BuildKonfig.SIPFRONT_API_DEBUG_USER),
                    password = MaskedString(BuildKonfig.SIPFRONT_API_DEBUG_PASS)
                ),
                sessionId = OVERRIDE_SESSION_ID,
                instanceId = OVERRIDE_INSTANCE_ID,
                server = BuildKonfig.SIPFRONT_API_DEBUG_SERVER,
                mqttRtcpPath = OVERRIDE_MQTT_RTCP_PATH,
                mqttSipPath = OVERRIDE_MQTT_SIP_PATH,
                sipfrontApi = OVERRIDE_SIPFRONT_API_URL,
                sipfrontApiToken = MaskedString(OVERRIDE_SIPFRONT_API_TOKEN),
                role = OVERRIDE_ROLE
            )
        }
    }
}