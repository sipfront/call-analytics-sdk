package com.sipfront.sdk.pjsip.pjsua2.reflection

import com.sipfront.sdk.pjsip.pjsua2.constants.PjsipConstants
import com.sipfront.sdk.pjsip.pjsua2.interfaces.PjsipObject
import com.sipfront.sdk.pjsip.pjsua2.utils.ReflectionHelper

object RtcpStat : PjsipObject {
    @Suppress("EnumEntryName")
    private enum class Method {
        getRxStat,
        getTxStat,
        getRttUsec;
    }

    override fun className(): String {
        return "${PjsipConstants.PACKAGE}.${this::class.java.simpleName}"
    }

    fun getRxStat(org_pjsip_pjsua2_RtcpStat: Any): Any {
        return if (ReflectionHelper.matchesClass(org_pjsip_pjsua2_RtcpStat, className())) {
            ReflectionHelper.invokeMethod(
                org_pjsip_pjsua2_RtcpStat,
                Method.getRxStat.toString()
            ) as Any
        } else {
            throw NullPointerException("${this.className()}.${this::class.java.enclosingMethod?.name} returns null!")
        }
    }

    fun getTxStat(org_pjsip_pjsua2_RtcpStat: Any): Any {
        return if (ReflectionHelper.matchesClass(org_pjsip_pjsua2_RtcpStat, className())) {
            ReflectionHelper.invokeMethod(
                org_pjsip_pjsua2_RtcpStat,
                Method.getTxStat.toString()
            ) as Any
        } else {
            throw NullPointerException("${this.className()}.${this::class.java.enclosingMethod?.name} returns null!")
        }
    }

    fun getRttUsec(org_pjsip_pjsua2_RtcpStat: Any): Any {
        return if (ReflectionHelper.matchesClass(org_pjsip_pjsua2_RtcpStat, className())) {
            ReflectionHelper.invokeMethod(
                org_pjsip_pjsua2_RtcpStat,
                Method.getRttUsec.toString()
            ) as Any
        } else {
            throw NullPointerException("${this.className()}.${this::class.java.enclosingMethod?.name} returns null!")
        }
    }
}