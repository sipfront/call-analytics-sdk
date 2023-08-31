package com.sipfront.sdk.pjsip.pjsua2.reflection

import com.sipfront.sdk.pjsip.pjsua2.constants.PjsipConstants
import com.sipfront.sdk.pjsip.pjsua2.interfaces.PjsipObject
import com.sipfront.sdk.pjsip.pjsua2.utils.ReflectionHelper

object TsxStateEvent : PjsipObject {
    @Suppress("EnumEntryName")
    private enum class Method {
        getType, getSrc;
    }

    override fun className(): String {
        return "${PjsipConstants.PACKAGE}.${this::class.java.simpleName}"
    }

    fun getType(org_pjsip_pjsua2_TsxStateEvent: Any): Int {
        return if (ReflectionHelper.matchesClass(
                org_pjsip_pjsua2_TsxStateEvent, className()
            )
        ) {
            ReflectionHelper.invokeMethod(
                org_pjsip_pjsua2_TsxStateEvent, Method.getType.toString()
            ) as Int
        } else {
            throw NullPointerException("${this.className()}.${this::class.java.enclosingMethod?.name} returns null!")
        }
    }

    fun getSrc(org_pjsip_pjsua2_TsxStateEvent: Any): Any {
        return if (ReflectionHelper.matchesClass(
                org_pjsip_pjsua2_TsxStateEvent, className()
            )
        ) {
            ReflectionHelper.invokeMethod(
                org_pjsip_pjsua2_TsxStateEvent, Method.getSrc.toString()
            ) as Any
        } else {
            throw NullPointerException("${this.className()}.${this::class.java.enclosingMethod?.name} returns null!")
        }
    }
}