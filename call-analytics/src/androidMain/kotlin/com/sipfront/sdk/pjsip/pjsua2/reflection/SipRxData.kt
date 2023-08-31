package com.sipfront.sdk.pjsip.pjsua2.reflection

import com.sipfront.sdk.pjsip.pjsua2.constants.PjsipConstants
import com.sipfront.sdk.pjsip.pjsua2.interfaces.PjsipObject
import com.sipfront.sdk.pjsip.pjsua2.utils.ReflectionHelper

object SipRxData : PjsipObject {
    @Suppress("EnumEntryName")
    private enum class Method {
        getWholeMsg;
    }

    override fun className(): String {
        return "${PjsipConstants.PACKAGE}.${this::class.java.simpleName}"
    }

    fun getWholeMsg(org_pjsip_pjsua2_SipRxData: Any): String {
        return if (ReflectionHelper.matchesClass(org_pjsip_pjsua2_SipRxData, className())) {
            ReflectionHelper.invokeMethod(
                org_pjsip_pjsua2_SipRxData,
                Method.getWholeMsg.toString()
            ) as String
        } else {
            throw NullPointerException("${this.className()}.${this::class.java.enclosingMethod?.name} returns null!")
        }
    }
}