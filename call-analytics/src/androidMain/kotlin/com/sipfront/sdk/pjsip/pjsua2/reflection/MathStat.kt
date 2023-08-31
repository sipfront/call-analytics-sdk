package com.sipfront.sdk.pjsip.pjsua2.reflection

import com.sipfront.sdk.pjsip.pjsua2.constants.PjsipConstants
import com.sipfront.sdk.pjsip.pjsua2.interfaces.PjsipObject
import com.sipfront.sdk.pjsip.pjsua2.utils.ReflectionHelper

object MathStat : PjsipObject {
    @Suppress("EnumEntryName")
    private enum class Method {
        getLast;
    }

    override fun className(): String {
        return "${PjsipConstants.PACKAGE}.${this::class.java.simpleName}"
    }


    fun getLast(org_pjsip_pjsua2_MathStat: Any): Long {
        return if (ReflectionHelper.matchesClass(org_pjsip_pjsua2_MathStat, className())) {
            (ReflectionHelper.invokeMethod(
                org_pjsip_pjsua2_MathStat,
                Method.getLast.toString()
            ) as Int).toLong()
        } else {
            throw NullPointerException("${this.className()}.${this::class.java.enclosingMethod?.name} returns null!")
        }
    }
}