package com.sipfront.sdk.pjsip.pjsua2.reflection

import com.sipfront.sdk.pjsip.pjsua2.constants.PjsipConstants
import com.sipfront.sdk.pjsip.pjsua2.interfaces.PjsipObject
import com.sipfront.sdk.pjsip.pjsua2.utils.ReflectionHelper

object TsxStateEventSrc : PjsipObject {
    @Suppress("EnumEntryName")
    private enum class Method {
        getRdata, getTdata;
    }

    override fun className(): String {
        return "${PjsipConstants.PACKAGE}.${this::class.java.simpleName}"
    }

    fun getRdata(org_pjsip_pjsua2_TsxStateEventSrc: Any): Any {
        return if (ReflectionHelper.matchesClass(org_pjsip_pjsua2_TsxStateEventSrc, className())) {
            ReflectionHelper.invokeMethod(
                org_pjsip_pjsua2_TsxStateEventSrc, Method.getRdata.toString()
            ) as Any
        } else {
            throw NullPointerException("${this.className()}.${this::class.java.enclosingMethod?.name} returns null!")
        }
    }

    fun getTdata(org_pjsip_pjsua2_TsxStateEventSrc: Any): Any {
        return if (ReflectionHelper.matchesClass(org_pjsip_pjsua2_TsxStateEventSrc, className())) {
            ReflectionHelper.invokeMethod(
                org_pjsip_pjsua2_TsxStateEventSrc, Method.getTdata.toString()
            ) as Any
        } else {
            throw NullPointerException("${this.className()}.${this::class.java.enclosingMethod?.name} returns null!")
        }
    }
}