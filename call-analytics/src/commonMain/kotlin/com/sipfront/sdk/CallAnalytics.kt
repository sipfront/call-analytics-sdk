package com.sipfront.sdk

import co.touchlab.stately.collections.ConcurrentMutableList
import com.sipfront.sdk.constants.Constants
import com.sipfront.sdk.constants.SipfrontIntent
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
import kotlinx.atomicfu.AtomicBoolean
import kotlinx.atomicfu.atomic
import kotlinx.atomicfu.update
import kotlinx.serialization.SerializationException
import kotlin.experimental.ExperimentalObjCName
import kotlin.jvm.JvmStatic
import kotlin.native.ObjCName

@OptIn(ExperimentalObjCName::class)
object CallAnalytics : ProguardKeep {
    private val initialised: AtomicBoolean = atomic(false)
    private lateinit var config: Config
    private lateinit var logParser: LogParser
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
     * The key is [SipfrontIntent.Extra.CONFIG] and data has the following JSON format:
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
     *  @return[Boolean] true if successfully initialised
     */
    @JvmStatic
    @Throws(IllegalStateException::class, IllegalArgumentException::class, SerializationException::class)
    @ObjCName("initialize")
    fun init(
        @ObjCName("params") sessionParams: SessionParams,
        @ObjCName("config") config: Config = Config.Builder().build()
    ): Boolean {
        Log.enableLogging(config.enableDebugLogs)
        Log.debug()
            ?.i(
                "Starting Call Analytics ${BuildKonfig.VERSION_CODE}-${Platform.getBuildType()} initialization on: " +
                        "${Platform.getDeviceModel()} - ${Platform.getOsFamily()} ${Platform.getOsVersion()}\n" +
                        "with Config: ${JsonParser.toString(config)}"
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
     *  @param json [String] contains the data as JSON required to register on Sipfront
     *  @param config [Config] optional configuration to use
     *  @return [Boolean] true if successfully initialised
     */
    @JvmStatic
    @Throws(IllegalStateException::class)
    @ObjCName("initialize")
    private fun init(
        json: String, config: Config = Config.Builder().build()
    ): Boolean {
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
     *  @return[Boolean] true if successfully initialised
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
                logParser = LogParser()
                Log.debug()?.i(
                    "Successfully initialized Call Analytics ${BuildKonfig.VERSION_CODE}-${Platform.getBuildType()} with SessionConfig: $sessionConfig,  config: $config"
                )
                if (config.enableLogParser) {
                    logParser.start()
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
            throw IllegalStateException("Call Analytics isn't initialised")
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
            throw IllegalStateException("Call Analytics isn't initialised")
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
            throw IllegalStateException("Call Analytics isn't initialised")
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
            throw IllegalStateException("Call Analytics isn't initialised")
        }
        sdpCache.add(msg)
        mqttClient?.sendMessage(msg) ?: run {
            throw IllegalStateException("MqttClient hasn't been created")
        }
    }

    /**
     * Returns true if [CallAnalytics] has been initialized
     * @return[Boolean] true if [CallAnalytics] has been initialiued
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
            mqttClient = MqttClient.Builder().sessionData(sessionConfig = sessionConfig)
                .trustAllCerts(trustAllCerts = trustAllCerts).build()
            Log.debug()?.i("Successfully initialized MqttClient")
            true
        } catch (exception: Exception) {
            Log.release().e("Failed to initialize MqttClient", exception)
            false
        }
    }

    /*
    private lateinit var pjsua2: Pjsua2
    private var recording: Boolean = false
    private var recorder: MediaRecorder? = null

    /**
     * ### Start [CallAnalytics]
     *
     * - Will start [CallAnalytics]
     * - **Must be called from a thread registered with Pjsip**
     */
    @JvmStatic
    fun start() {
        try {
            if (initialised.get()) {
                Timber.i("Starting Call Analytics")
                logParser = LogParser(debug = config.enableDebugLogs)
                if (config.enableLogParser) {
                    // Try to read SIP traces using Logcat
                    logParser.start()
                }
                pjsua2 = Pjsua2(debug = config.enableDebugLogs)
                if (config.enablePjsua) {
                    // Try to ready RTCP messages using Pjsua2 API
                    pjsua2.start()
                }
            } else {
                Timber.e("Can't start Call Analytics because it hasn't been initialized!")
            }
        } catch (exception: Exception) {
            Timber.e(exception)
        }
    }

    /**
     * ### Stop [CallAnalytics]
     *
     * - Stops all threads running within [CallAnalytics]
     * - Resets all values to initial state
     * - Ready to start new test afterwards
     */
    @JvmStatic
    fun stop() {
        try {
            Timber.i("Stopping Call Analytics")
            if (config.enablePjsua) {
                pjsua2.stop()
            }
            if (config.enableLogParser) {
                logParser.stop()
            }
        } catch (exception: Exception) {
            Timber.e(exception)
        } finally {
            initializationData = null
            mqttClient = null
        }
    }

    /**
     * ### Read SIP message using Pjsip OnCallTsxStateParam
     *
     * - This is an alternative to parsing from app logs
     * - Will immediately stop automatic parsing from app logs
     * - **Must be called from a thread registered with Pjsip**
     *
     * @param[org_pjsip_pjsua2_OnCallTsxStateParam] object must be of type org.pjsip.pjsua2.OnCallTsxStateParam
     */
    @JvmStatic
    fun pjsipOnCallTsxState(org_pjsip_pjsua2_OnCallTsxStateParam: Any?) {
        try {
            if (!config.enablePjsua) {
                throw UnsupportedOperationException("Can't use Pjsua method because it is disabled in config!")
            }

            logParser.apply {
                if (isRunning()) {
                    Timber.e("Requesting to read SIP logs from Pjsip Callback while LogParser already running! Stopping LogParser!")
                    stop()
                }
            }

            pjsua2.onCallTsxState(org_pjsip_pjsua2_OnCallTsxStateParam)
        } catch (exception: java.lang.Exception) {
            Timber.e(exception)
        }
    }

    /**
     * ### Read RTCP message using Pjsip Call object
     *
     * - This will start a thread that will continuously check the Call object for new RTCP messages
     * - **Call object must not be cleared after providing it to this method**
     * - **Must be called from a thread registered with Pjsip**
     *
     * @param[org_pjsip_pjsua2_Call] object must be of type org.pjsip.pjsua2.Call
     */
    @JvmStatic
    fun pjsipAddCall(org_pjsip_pjsua2_Call: Any) {
        try {
            if (!config.enablePjsua) {
                throw UnsupportedOperationException("Can't use Pjsua method because it is disabled in config!")
            }

            pjsua2.addCall(org_pjsip_pjsua2_Call)
        } catch (exception: java.lang.Exception) {
            Timber.e(exception)
        }
    }

    @JvmStatic
    fun startRecording(context: Context) {
        recorder = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            MediaRecorder(context)
        } else {
            MediaRecorder()
        }
        val dir = Environment.getExternalStorageDirectory()
        val file = File.createTempFile("sound", ".3gp", dir)
        recorder?.apply {
            setAudioSource(MediaRecorder.AudioSource.VOICE_DOWNLINK)
            setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP)
            setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB)
            setAudioSamplingRate(44100)
            setAudioChannels(1)
            setOutputFile(file.absolutePath)
            prepare()
            start()
            recording = true
        }
    }

    @JvmStatic
    fun stopRecording() {
        if (recording) {
            recorder?.apply {
                stop()
                reset()
                release()
            }
            recorder = null
            recording = false
        }
    }*/
}

