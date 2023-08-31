package com.sipfront.sdk.pjsip.pjsua2.reflection

import com.sipfront.sdk.pjsip.pjsua2.constants.PjsipConstants
import com.sipfront.sdk.pjsip.pjsua2.enums.PjMediaDir
import com.sipfront.sdk.pjsip.pjsua2.enums.PjMediaType
import com.sipfront.sdk.pjsip.pjsua2.interfaces.PjsipObject
import com.sipfront.sdk.pjsip.pjsua2.utils.ReflectionHelper

object CallMediaInfo : PjsipObject {
    @Suppress("EnumEntryName")
    private enum class Method {
        getType,
        getDir;
    }

    override fun className(): String {
        return "${PjsipConstants.PACKAGE}.${this::class.java.simpleName}"
    }


    fun getCallMediaInfoType(org_pjsip_pjsua2_CallMediaInfo: Any): PjMediaType {
        return if (ReflectionHelper.matchesClass(org_pjsip_pjsua2_CallMediaInfo, className())) {
            PjMediaType.valueOf(
                ReflectionHelper.invokeMethod(
                    org_pjsip_pjsua2_CallMediaInfo,
                    Method.getType.toString()
                ) as Int
            )
        } else {
            throw NullPointerException("${this.className()}.${this::class.java.enclosingMethod?.name} returns null!")
        }
    }

    fun getCallMediaInfoDir(callMediaInfo: Any): PjMediaDir {
        return if (ReflectionHelper.matchesClass(callMediaInfo, className())) {
            PjMediaDir.valueOf(
                ReflectionHelper.invokeMethod(
                    callMediaInfo,
                    Method.getDir.toString()
                ) as Int
            )
        } else {
            throw NullPointerException("${this.className()}.${this::class.java.enclosingMethod?.name} returns null!")
        }
    }
}