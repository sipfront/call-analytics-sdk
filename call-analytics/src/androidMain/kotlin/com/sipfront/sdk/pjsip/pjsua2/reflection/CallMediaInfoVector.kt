package com.sipfront.sdk.pjsip.pjsua2.reflection

import com.sipfront.sdk.pjsip.pjsua2.constants.PjsipConstants
import com.sipfront.sdk.pjsip.pjsua2.interfaces.PjsipObject
import com.sipfront.sdk.pjsip.pjsua2.utils.ReflectionHelper

object CallMediaInfoVector : PjsipObject {
    @Suppress("EnumEntryName")
    private enum class Method(val parameterTypes: Array<Class<*>>? = null) {
        size,
        get(arrayOf(Int::class.java));
    }

    override fun className(): String {
        return "${PjsipConstants.PACKAGE}.${this::class.java.simpleName}"
    }


    fun getCallMediaInfoSize(org_pjsip_pjsua2_CallMediaInfoVector: Any): Long {
        return if (ReflectionHelper.matchesClass(
                org_pjsip_pjsua2_CallMediaInfoVector,
                className()
            )
        ) {
            ReflectionHelper.invokeMethod(
                org_pjsip_pjsua2_CallMediaInfoVector,
                Method.size.toString()
            ) as Long
        } else {
            throw NullPointerException("${this.className()}.${this::class.java.enclosingMethod?.name} returns null!")
        }
    }

    fun getCallMediaInfo(org_pjsip_pjsua2_CallMediaInfoVector: Any, index: Int): Any {
        return if (ReflectionHelper.matchesClass(
                org_pjsip_pjsua2_CallMediaInfoVector,
                className()
            )
        ) {
            ReflectionHelper.invokeMethod(
                org_pjsip_pjsua2_CallMediaInfoVector,
                Method.get.toString(),
                Method.get.parameterTypes,
                arrayOf(index)
            ) as Any
        } else {
            throw NullPointerException("${this.className()}.${this::class.java.enclosingMethod?.name} returns null!")
        }
    }
}