package com.sipfront.sdk.pjsip.pjsua2

import com.sipfront.sdk.CallAnalytics
import com.sipfront.sdk.constants.Constants
import com.sipfront.sdk.json.message.RtcpMessage
import com.sipfront.sdk.json.message.SipMessage
import com.sipfront.sdk.log.Log
import kotlinx.atomicfu.AtomicBoolean
import kotlinx.atomicfu.atomic
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.Job
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.cancelAndJoin
import kotlinx.coroutines.delay
import kotlinx.coroutines.ensureActive
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

internal class Pjsua2 {
    private var rtcpJob: Job? = null
    private var pjsua2Call: Any? = null
    private val isRunning: AtomicBoolean = atomic(false)

    init {
        Log.debug()?.i("Pjsua2 has been created!")
    }

    fun addCall(org_pjsip_pjsua2_Call: Any?) {
        try {
            if (!CallAnalytics.isInitialized()) {
                Log.release().e("Can't add Pjsua2 Call because Call Analytics SDK hasn't been initialized")
                return
            }
            org_pjsip_pjsua2_Call?.let { call ->
                if (!isCallAdded()) {
                    pjsua2Call = call
                    runBlocking {
                        if (isRunning.compareAndSet(false, true)) {
                            rtcpJob = launch(start = CoroutineStart.LAZY) {
                                while (isCallAdded() && PjSipObjectParser.isCallActive(call)) {
                                    // Check whether this job is cancelled, since a coroutine must cooperate to be cancellable.
                                    ensureActive()
                                    val rtcpMessage: RtcpMessage? =
                                        PjSipObjectParser.getRtcpMessage(call) ?: run {
                                            Log.release().e("Couldn't parse RtcpMessage from pjsua Call")
                                            null
                                        }
                                    rtcpMessage?.let { CallAnalytics.sendRtcp(it) }
                                    delay(Constants.RTCP_READ_INTERVAL_MS)
                                }
                            }
                        }
                    }
                } else {
                    Log.release().e("Can't add Call because another one has already been added!")
                }
            } ?: run {
                Log.release().e("Can't add Pjsua2 Call because Call is null!")
            }
        } catch (exception: Exception) {
            Log.release().e("Failed adding Pjsua2 Call", exception)
        }
    }

    fun start() {
        try {
            Log.debug()?.i("Start reading RTCP traces using Pjsua2")
            if (!isCallAdded()) {
                Log.release().e("Can't start Pjsua2 rtcpJob because no Call added!")
                return
            }
            if (isRunning()) {
                Log.release().e("Can't start Pjsua2 rtcpJob because already running!")
                return
            }

            rtcpJob?.start() ?: run {
                Log.release().e("Failed to start Pjsua2 rtcpJob because it is null!")
            }
        } catch (cancel: CancellationException) {
            cancel.message?.let { Log.debug()?.i(it) }
        } catch (exception: Exception) {
            Log.release().e("Failed to start Pjsua2", exception)
        }
    }

    fun stop() {
        try {
            Log.debug()?.i("Stop reading RTCP traces using Pjsua2")
            MainScope().launch {
                // Cancel the job and wait for its completion on main thread.
                rtcpJob?.cancelAndJoin()
                rtcpJob = null
                pjsua2Call = null
                isRunning.value = false
            }
        } catch (exception: Exception) {
            Log.release().e("Failed to stop Pjsua2", exception)
        }
    }

    fun onCallTsxState(org_pjsip_pjsua2_OnCallTsxStateParam: Any?) {
        try {
            if (!CallAnalytics.isInitialized()) {
                Log.release().e("Can't send SIP Message because Call Analytics SDK hasn't been initialized")
                return
            }
            if (org_pjsip_pjsua2_OnCallTsxStateParam == null) {
                Log.release().e("Can't send SIP Message because OnCallTsxStateParam is null")
                return
            }
            val sipMessage: SipMessage? =
                PjSipObjectParser.getSipMessage(org_pjsip_pjsua2_OnCallTsxStateParam) ?: run {
                    Log.release().e("Couldn't parse SipMessage from pjsua2 OnCallTsxStateParam")
                    null
                }
            sipMessage?.let { CallAnalytics.sendSip(it) }
        } catch (exception: Exception) {
            Log.release().e("Failed adding OnCallTsxStateParam", exception)
        }
    }

    private fun isCallAdded(): Boolean {
        return pjsua2Call != null
    }

    private fun isRunning(): Boolean {
        return isRunning.value && rtcpJob?.isActive ?: false
    }
}