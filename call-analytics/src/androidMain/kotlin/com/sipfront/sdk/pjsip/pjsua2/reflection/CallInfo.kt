package com.sipfront.sdk.pjsip.pjsua2.reflection

import com.sipfront.sdk.pjsip.pjsua2.constants.PjsipConstants
import com.sipfront.sdk.pjsip.pjsua2.enums.PjSipRole
import com.sipfront.sdk.pjsip.pjsua2.interfaces.PjsipObject
import com.sipfront.sdk.pjsip.pjsua2.utils.ReflectionHelper

object CallInfo : PjsipObject {
    @Suppress("EnumEntryName")
    private enum class Method {
        getCallIdString,
        getLocalUri,
        getRemoteUri,
        getRole,
        getMedia;
    }

    override fun className(): String {
        return "${PjsipConstants.PACKAGE}.${this::class.java.simpleName}"
    }

    fun getCallIdString(org_pjsip_pjsua2_CallInfo: Any): String {
        return if (ReflectionHelper.matchesClass(org_pjsip_pjsua2_CallInfo, className())) {
            ReflectionHelper.invokeMethod(
                org_pjsip_pjsua2_CallInfo, Method.getCallIdString.toString()
            ) as String
        } else {
            throw NullPointerException("${this.className()}.${this::class.java.enclosingMethod?.name} returns null!")
        }
    }

    fun getLocalUri(org_pjsip_pjsua2_CallInfo: Any): String {
        return if (ReflectionHelper.matchesClass(org_pjsip_pjsua2_CallInfo, className())) {
            ReflectionHelper.invokeMethod(
                org_pjsip_pjsua2_CallInfo,
                Method.getLocalUri.toString()
            ) as String
        } else {
            throw NullPointerException("${this.className()}.${this::class.java.enclosingMethod?.name} returns null!")
        }
    }

    fun getRemoteUri(org_pjsip_pjsua2_CallInfo: Any): String {
        return if (ReflectionHelper.matchesClass(org_pjsip_pjsua2_CallInfo, className())) {
            ReflectionHelper.invokeMethod(
                org_pjsip_pjsua2_CallInfo,
                Method.getRemoteUri.toString()
            ) as String
        } else {
            throw NullPointerException("${this.className()}.${this::class.java.enclosingMethod?.name} returns null!")
        }
    }

    fun getRole(org_pjsip_pjsua2_CallInfo: Any): PjSipRole {
        return if (ReflectionHelper.matchesClass(org_pjsip_pjsua2_CallInfo, className())) {
            PjSipRole.valueOf(
                ReflectionHelper.invokeMethod(
                    org_pjsip_pjsua2_CallInfo,
                    Method.getRole.toString()
                ) as Int
            )
        } else {
            throw NullPointerException("${this.className()}.${this::class.java.enclosingMethod?.name} returns null!")
        }
    }

    fun getCallMediaInfoVector(org_pjsip_pjsua2_CallInfo: Any): Any {
        return if (ReflectionHelper.matchesClass(org_pjsip_pjsua2_CallInfo, className())) {
            ReflectionHelper.invokeMethod(
                org_pjsip_pjsua2_CallInfo,
                Method.getMedia.toString()
            ) as Any
        } else {
            throw NullPointerException("${this.className()}.${this::class.java.enclosingMethod?.name} returns null!")
        }
    }
}