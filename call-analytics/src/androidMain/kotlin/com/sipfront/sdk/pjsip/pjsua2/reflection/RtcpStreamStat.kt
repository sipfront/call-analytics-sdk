package com.sipfront.sdk.pjsip.pjsua2.reflection

import com.sipfront.sdk.pjsip.pjsua2.constants.PjsipConstants
import com.sipfront.sdk.pjsip.pjsua2.interfaces.PjsipObject
import com.sipfront.sdk.pjsip.pjsua2.utils.ReflectionHelper

object RtcpStreamStat : PjsipObject {
    @Suppress("EnumEntryName")
    private enum class Method {
        getJitterUsec,
        getPkt,
        getLoss;
    }

    override fun className(): String {
        return "${PjsipConstants.PACKAGE}.${this::class.java.simpleName}"
    }

    fun getJitterUsec(org_pjsip_pjsua2_RtcpStreamStat: Any): Any {
        return if (ReflectionHelper.matchesClass(org_pjsip_pjsua2_RtcpStreamStat, className())) {
            ReflectionHelper.invokeMethod(
                org_pjsip_pjsua2_RtcpStreamStat,
                Method.getJitterUsec.toString()
            ) as Any
        } else {
            throw NullPointerException("${this.className()}.${this::class.java.enclosingMethod?.name} returns null!")
        }
    }

    fun getPkt(org_pjsip_pjsua2_RtcpStreamStat: Any): Long {
        return if (ReflectionHelper.matchesClass(org_pjsip_pjsua2_RtcpStreamStat, className())) {
            ReflectionHelper.invokeMethod(
                org_pjsip_pjsua2_RtcpStreamStat,
                Method.getPkt.toString()
            ) as Long
        } else {
            throw NullPointerException("${this.className()}.${this::class.java.enclosingMethod?.name} returns null!")
        }
    }

    fun getLoss(org_pjsip_pjsua2_RtcpStreamStat: Any): Long {
        return if (ReflectionHelper.matchesClass(org_pjsip_pjsua2_RtcpStreamStat, className())) {
            ReflectionHelper.invokeMethod(
                org_pjsip_pjsua2_RtcpStreamStat,
                Method.getLoss.toString()
            ) as Long
        } else {
            throw NullPointerException("${this.className()}.${this::class.java.enclosingMethod?.name} returns null!")
        }
    }
}