package com.sipfront.sdk.pjsip.pjsua2.reflection

import com.sipfront.sdk.pjsip.pjsua2.constants.PjsipConstants
import com.sipfront.sdk.pjsip.pjsua2.interfaces.PjsipObject
import com.sipfront.sdk.pjsip.pjsua2.utils.ReflectionHelper

object SipEventBody : PjsipObject {
    @Suppress("EnumEntryName")
    private enum class Method {
        getTsxState;
    }

    override fun className(): String {
        return "${PjsipConstants.PACKAGE}.${this::class.java.simpleName}"
    }


    fun getTsxState(org_pjsip_pjsua2_SipEventBody: Any): Any {
        return if (ReflectionHelper.matchesClass(
                org_pjsip_pjsua2_SipEventBody, className()
            )
        ) {
            ReflectionHelper.invokeMethod(
                org_pjsip_pjsua2_SipEventBody, Method.getTsxState.toString()
            ) as Any
        } else {
            throw NullPointerException("${this.className()}.${this::class.java.enclosingMethod?.name} returns null!")
        }
    }
}