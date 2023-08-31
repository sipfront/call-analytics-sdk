package com.sipfront.sdk.pjsip.pjsua2.reflection

import com.sipfront.sdk.pjsip.pjsua2.constants.PjsipConstants
import com.sipfront.sdk.pjsip.pjsua2.interfaces.PjsipObject
import com.sipfront.sdk.pjsip.pjsua2.utils.ReflectionHelper

object StreamStat : PjsipObject {
    @Suppress("EnumEntryName")
    private enum class Method {
        getRtcp;
    }

    override fun className(): String {
        return "${PjsipConstants.PACKAGE}.${this::class.java.simpleName}"
    }

    fun getRtcp(org_pjsip_pjsua2_StreamStat: Any): Any {
        return if (ReflectionHelper.matchesClass(org_pjsip_pjsua2_StreamStat, className())) {
            ReflectionHelper.invokeMethod(
                org_pjsip_pjsua2_StreamStat, Method.getRtcp.toString()
            ) as Any
        } else {
            throw NullPointerException("${this.className()}.${this::class.java.enclosingMethod?.name} returns null!")
        }
    }
}