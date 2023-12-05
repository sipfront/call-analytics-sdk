package com.sipfront.sdk

import co.touchlab.stately.collections.ConcurrentMutableList
import com.sipfront.sdk.CallAnalytics.init
import com.sipfront.sdk.constants.Constants
import com.sipfront.sdk.constants.Keys
import com.sipfront.sdk.interfaces.ProguardKeep
import com.sipfront.sdk.json.JsonParser
import com.sipfront.sdk.json.config.Config
import com.sipfront.sdk.json.config.SessionConfig
import com.sipfront.sdk.json.message.RtcpMessage
import com.sipfront.sdk.json.message.SdpMessage
import com.sipfront.sdk.json.message.SipMessage
import com.sipfront.sdk.json.message.StateMessage
import com.sipfront.sdk.log.Log
import com.sipfront.sdk.log.parser.LogParser
import com.sipfront.sdk.mqtt.MqttClient
import com.sipfront.sdk.utils.Platform
import com.sipfront.sdk.utils.getUserAgent
import kotlinx.atomicfu.AtomicBoolean
import kotlinx.atomicfu.atomic
import kotlinx.atomicfu.update
import kotlinx.serialization.SerializationException
import kotlin.experimental.ExperimentalObjCName
import kotlin.js.ExperimentalJsExport
import kotlin.js.JsExport
import kotlin.js.JsName
import kotlin.jvm.JvmStatic
import kotlin.native.ObjCName

/**
 * The [CallAnalytics] singleton object provides a unified interface for
 * sending call-related data to Sipfront servers.
 *
 * Usage:
 * To use [CallAnalytics], first invoke the [init] method and after successful initialization you can
 * use the various send* methods
 *
 * Android Example:
 * ```kotlin
 * // In onCreate() of your apps Launcher Activity add this code
 * override fun onCreate(savedInstanceState: Bundle?) {
 *     if (savedInstanceState == null) {
 *         try {
 *             val initialized = CallAnalytics.init(
 *                 // custom Intent arguments provided to app by Sipfront test
 *                 SessionParams(intent),
 *                 // optional configuration
 *                 Config.Builder()
 *                     .enableDebugLogs(enable = true)
 *                     .build()
 *             )
 *             if(initialized) {
 *                 Log.i("CallAnalytics initialized")
 *             }
 *         } catch (e: Exception) {
 *             Log.e("Could not initialise CallAnalytics, cause: ${e.message}")
 *         }
 *     }
 * }
 * ```
 *
 * iOS Example:
 * ```
 * // In init() of your SwiftUI.App
 * struct MyApp: SwiftUI.App {
 *     init() {
 *         do {
 *             let initialized = try CallAnalytics.shared.initialize(
 *                 params: SessionParams(),
 *                 // optional configuration of Sdk
 *                 config: Config.Builder()
 *                     .enableDebugLogs(true)
 *                     .trustAllCerts(true)
 *                     .build()
 *             )
 *             if initialized {
 *                 Logger.info("CallAnalytics initialized")
 *             }
 *         } catch {
 *             Logger.notifications.error("CallAnalytics init error: \(error)")
 *         }
 *     }
 * }
 * ```
 *
 * Note:
 * Implementors of the library should ensure proper internet connectivity
 * and necessary permissions before invoking the methods.
 *
 * @throws IllegalStateException If any send* methods are used before [CallAnalytics] has been initialized
 * @throws IllegalArgumentException If data provided to [init] methods is invalid
 *
 * @since 1.0.0
 * @author Dominik Ridjic
 */
@Suppress("unused")
@OptIn(ExperimentalObjCName::class, ExperimentalJsExport::class)
@JsExport
object CallAnalytics : ProguardKeep {
    private val initialised: AtomicBoolean = atomic(false)
    private lateinit var config: Config
    private var logParser: LogParser? = null
    private var sessionConfig: SessionConfig? = null
    private var mqttClient: MqttClient? = null
    internal val rtcpCache: ConcurrentMutableList<RtcpMessage> = ConcurrentMutableList()

    @Suppress("MemberVisibilityCanBePrivate")
    internal val stateCache: ConcurrentMutableList<StateMessage> = ConcurrentMutableList()

    @Suppress("MemberVisibilityCanBePrivate")
    internal val sipCache: ConcurrentMutableList<SipMessage> = ConcurrentMutableList()

    @Suppress("MemberVisibilityCanBePrivate")
    internal val sdpCache: ConcurrentMutableList<SdpMessage> = ConcurrentMutableList()

    /**
     * ### Initialize [CallAnalytics] with data received at test start
     *
     * The data is received on Android as Intent and on iOS as environment variable in ProcessInfo
     *
     * The key is [Keys.INITIALIZATION] and data has the following JSON format:
     *
     * ```
     *  {
     *     "credentials": {
     *        "username":"user",
     *        "password":"pass"
     *     },
     *     "server":"server",
     *     "session_id":"sessid",
     *     "mqtt_rtcp_path":"path",
     *     "mqtt_sip_path":"path"
     *  }
     *  ```
     *
     *  **[CallAnalytics] will immediately start parsing app logs for SIP messages and transmit them if found**
     *
     *  @param sessionParams [SessionParams] contains the data required to register on Sipfront
     *  @param config [Config] optional configuration to use
     *  @return[Boolean] true if successfully initialized
     */
    @JvmStatic
    @Throws(IllegalStateException::class, IllegalArgumentException::class, SerializationException::class)
    @ObjCName("initialize")
    @JsExport.Ignore
    fun init(
        @ObjCName("params") sessionParams: SessionParams,
        @ObjCName("config") config: Config = Config.Builder().build()
    ): Boolean {
        Log.enableDebugLogs(config.enableDebugLogs)
        Log.debug()
            ?.i(
                "Starting ${getUserAgent()} initialization with Config: ${JsonParser.toString(config)}"
            )

        if (!isInitialized()) {
            return try {
                init(sessionConfig = sessionParams.parse(), config = config)
            } catch (exception: Exception) {
                if (Platform.isDebug() && Constants.DEBUG_FALLBACK_INIT_DATA) {
                    Log.debug()?.w("Initialization failed", exception)
                    Log.debug()?.i("Creating fallback SessionConfig")
                    init(sessionConfig = SessionConfig.debugData(), config = config)
                } else {
                    throw exception
                }
            }
        } else {
            throw IllegalStateException("Already previously initialized with SessionConfig: $sessionConfig")
        }
    }

    /**
     * ### Initialize [CallAnalytics] with data contained in a JSON String:
     *
     * ```
     *  {
     *     "credentials": {
     *        "username":"user",
     *        "password":"pass"
     *     },
     *     "server":"server",
     *     "session_id":"sessid",
     *     "mqtt_rtcp_path":"path",
     *     "mqtt_sip_path":"path"
     *  }
     *  ```
     *
     *  **[CallAnalytics] will immediately start parsing app logs for SIP messages and transmit them if found**
     *
     *  @param json [String] contains the data as JSON required for registering on Sipfront
     *  @param config [Config] optional configuration to use
     *  @return [Boolean] true if successfully initialized
     */
    @JvmStatic
    @Throws(IllegalStateException::class)
    @ObjCName("initialize")
    @JsName("initWithJson")
    fun init(
        json: String, config: Config = Config.Builder().build()
    ): Boolean {
        Log.enableDebugLogs(config.enableDebugLogs)
        if (!isInitialized()) {
            return init(
                sessionConfig = JsonParser.toObject(
                    json = json
                ), config = config
            )
        } else {
            throw IllegalStateException("Already previously initialized with SessionConfig: $sessionConfig")
        }
    }

    /**
     * ### Initialize [CallAnalytics] with data contained in [SessionConfig]
     *
     *  **[CallAnalytics] will immediately start parsing app logs for SIP messages and transmit them if found**
     *
     *  @param sessionConfig [SessionConfig] contains the data required to register on Sipfront
     *  @param config [Config] optional configuration to use
     *  @return[Boolean] true if successfully initialized
     */
    @JvmStatic
    @Throws(IllegalStateException::class)
    @ObjCName("initialize")
    private fun init(
        sessionConfig: SessionConfig, config: Config = Config.Builder().build()
    ): Boolean {
        if (!isInitialized()) {
            initialised.update { initMqttClient(sessionConfig, config.trustAllCerts) }
            if (initialised.value) {
                this.sessionConfig = sessionConfig
                this.config = config
                Log.debug()?.i(
                    "Successfully initialized ${getUserAgent()} with SessionConfig: $sessionConfig,  config: $config"
                )
                if (config.enableLogParser) {
                    logParser = LogParser()
                    logParser?.start()
                }
                return true
            } else {
                throw IllegalStateException("Failed creating Mqtt Client")
            }
        } else {
            throw IllegalStateException("Already previously initialized with SessionConfig: $sessionConfig")
        }
    }

    /**
     * Sends [StateMessage] to Sipfront
     * @param msg [StateMessage]
     */
    @ObjCName("send")
    @JvmStatic
    @Throws(IllegalStateException::class, IllegalArgumentException::class)
    fun sendState(@ObjCName("state") msg: StateMessage) {
        if (!isInitialized()) {
            throw IllegalStateException("${BuildKonfig.PROJECT_NAME} isn't initialised")
        }

        runCatching { stateCache.last() }.getOrNull()?.let {
            if (msg.type == it.type) {
                Log.debug()
                    ?.i("Not sending CallStateMessage because MessageType is identical with last message: ${it.type}")
                return
            }
        }
        stateCache.add(msg)

        mqttClient?.sendMessage(msg) ?: run {
            throw IllegalStateException("MqttClient hasn't been created")
        }
    }

    /**
     * Sends [RtcpMessage] to Sipfront
     * @param msg [RtcpMessage]
     */
    @ObjCName("send")
    @JvmStatic
    @Throws(IllegalStateException::class, IllegalArgumentException::class)
    fun sendRtcp(@ObjCName("rtcp") msg: RtcpMessage) {
        if (!isInitialized()) {
            throw IllegalStateException("${BuildKonfig.PROJECT_NAME} isn't initialised")
        }
        rtcpCache.add(msg)
        mqttClient?.sendMessage(msg) ?: run {
            throw IllegalStateException("MqttClient hasn't been created")
        }
    }

    /**
     * Sends [SipMessage] to Sipfront
     * @param msg [SipMessage]
     */
    @ObjCName("send")
    @JvmStatic
    @Throws(IllegalStateException::class, IllegalArgumentException::class)
    fun sendSip(@ObjCName("sip") msg: SipMessage) {
        if (!isInitialized()) {
            throw IllegalStateException("${BuildKonfig.PROJECT_NAME} isn't initialised")
        }
        sipCache.add(msg)
        mqttClient?.sendMessage(msg) ?: run {
            throw IllegalStateException("MqttClient hasn't been created")
        }
    }

    /**
     * Sends [SdpMessage] to Sipfront
     * @param msg [SdpMessage]
     */
    @ObjCName("send")
    @JvmStatic
    @Throws(IllegalStateException::class, IllegalArgumentException::class)
    fun sendSdp(@ObjCName("sdp") msg: SdpMessage) {
        if (!isInitialized()) {
            throw IllegalStateException("${BuildKonfig.PROJECT_NAME} isn't initialised")
        }
        sdpCache.add(msg)
        mqttClient?.sendMessage(msg) ?: run {
            throw IllegalStateException("MqttClient hasn't been created")
        }
    }

    /**
     * Returns true if [CallAnalytics] has been initialized
     * @return[Boolean] true if [CallAnalytics] has been initialized
     */
    @Suppress("BooleanMethodIsAlwaysInverted")
    @JvmStatic
    fun isInitialized(): Boolean = initialised.value

    /**
     * Returns current [Config]
     * @return[Config]
     */
    @JvmStatic
    internal fun getConfig(): Config = config

    @JvmStatic
    private fun initMqttClient(
        sessionConfig: SessionConfig, trustAllCerts: Boolean
    ): Boolean {
        return try {
            mqttClient = MqttClient.Builder()
                .sessionData(sessionConfig = sessionConfig)
                .trustAllCerts(trustAllCerts = trustAllCerts)
                .build()
            Log.debug()?.i("Successfully initialized MqttClient")
            true
        } catch (exception: Exception) {
            Log.release().e("Failed to initialize MqttClient", exception)
            false
        }
    }
}

