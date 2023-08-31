package com.sipfront.sdk.pjsip.pjsua2.reflection

import com.sipfront.sdk.pjsip.pjsua2.constants.PjsipConstants
import com.sipfront.sdk.pjsip.pjsua2.interfaces.PjsipObject
import com.sipfront.sdk.pjsip.pjsua2.utils.ReflectionHelper

object OnCallTsxStateParam : PjsipObject {
    @Suppress("EnumEntryName")
    private enum class Method {
        getE;
    }

    override fun className(): String {
        return "${PjsipConstants.PACKAGE}.${this::class.java.simpleName}"
    }


    fun getE(org_pjsip_pjsua2_OnCallTsxStateParam: Any): Any {
        return if (ReflectionHelper.matchesClass(
                org_pjsip_pjsua2_OnCallTsxStateParam, className()
            )
        ) {
            ReflectionHelper.invokeMethod(
                org_pjsip_pjsua2_OnCallTsxStateParam, Method.getE.toString()
            ) as Any
        } else {
            throw NullPointerException("${this.className()}.${this::class.java.enclosingMethod?.name} returns null!")
        }
    }
}