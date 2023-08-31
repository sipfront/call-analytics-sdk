package com.sipfront.sdk.pjsip.pjsua2.reflection

import com.sipfront.sdk.pjsip.pjsua2.constants.PjsipConstants
import com.sipfront.sdk.pjsip.pjsua2.interfaces.PjsipObject
import com.sipfront.sdk.pjsip.pjsua2.utils.ReflectionHelper

object SipEvent : PjsipObject {
    @Suppress("EnumEntryName")
    private enum class Method {
        getBody;
    }

    override fun className(): String {
        return "${PjsipConstants.PACKAGE}.${this::class.java.simpleName}"
    }


    fun getBody(org_pjsip_pjsua2_SipEvent: Any): Any {
        return if (ReflectionHelper.matchesClass(
                org_pjsip_pjsua2_SipEvent,
                className()
            )
        ) {
            ReflectionHelper.invokeMethod(
                org_pjsip_pjsua2_SipEvent,
                Method.getBody.toString()
            ) as Any
        } else {
            throw NullPointerException("${this.className()}.${this::class.java.enclosingMethod?.name} returns null!")
        }
    }
}