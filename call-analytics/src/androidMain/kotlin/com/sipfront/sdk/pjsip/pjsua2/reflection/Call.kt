package com.sipfront.sdk.pjsip.pjsua2.reflection

import com.sipfront.sdk.pjsip.pjsua2.constants.PjsipConstants
import com.sipfront.sdk.pjsip.pjsua2.interfaces.PjsipObject
import com.sipfront.sdk.pjsip.pjsua2.utils.ReflectionHelper

object Call: PjsipObject {
    @Suppress("EnumEntryName")
    private enum class Method(val parameterTypes: Array<Class<*>>? = null) {
        isActive,
        hasMedia,
        getInfo,
        getStreamStat(arrayOf(Long::class.java));
    }

    override fun className(): String {
        return "${PjsipConstants.PACKAGE}.${this::class.java.simpleName}"
    }


    @Suppress("BooleanMethodIsAlwaysInverted")
    fun isActive(org_pjsip_pjsua2_Call: Any): Boolean {
        return if (ReflectionHelper.matchesClass(org_pjsip_pjsua2_Call, className())) {
            ReflectionHelper.invokeMethod(
                org_pjsip_pjsua2_Call,
                Method.isActive.toString()
            ) as Boolean
        } else {
            false
        }
    }

    fun hasMedia(org_pjsip_pjsua2_Call: Any): Boolean {
        return if (ReflectionHelper.matchesClass(org_pjsip_pjsua2_Call, className())) {
            ReflectionHelper.invokeMethod(
                org_pjsip_pjsua2_Call,
                Method.hasMedia.toString()
            ) as Boolean
        } else {
            false
        }
    }

    fun getInfo(org_pjsip_pjsua2_Call: Any): Any {
        return if (ReflectionHelper.matchesClass(org_pjsip_pjsua2_Call, className())) {
            ReflectionHelper.invokeMethod(
                org_pjsip_pjsua2_Call,
                Method.getInfo.toString()
            ) as Any
        } else {
            throw NullPointerException("${this.className()}.${this::class.java.enclosingMethod?.name} returns null!")
        }
    }

    fun getStreamStat(org_pjsip_pjsua2_Call: Any, index: Long): Any {
        return if (ReflectionHelper.matchesClass(org_pjsip_pjsua2_Call, className())
        ) {
            ReflectionHelper.invokeMethod(
                org_pjsip_pjsua2_Call,
                Method.getStreamStat.toString(),
                Method.getStreamStat.parameterTypes,
                arrayOf(index)
            ) as Any
        } else {
            throw NullPointerException("${this.className()}.${this::class.java.enclosingMethod?.name} returns null!")
        }
    }
}