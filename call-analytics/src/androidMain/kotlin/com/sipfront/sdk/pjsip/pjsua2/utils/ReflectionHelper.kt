package com.sipfront.sdk.pjsip.pjsua2.utils

import com.sipfront.sdk.log.Log

internal object ReflectionHelper {
    private const val ROOT_CLASS: String = "java.lang.Class"

    fun getClass(clazz: Any, className: String): Class<*>? {
        return if (clazz::class.java.name.equals(className)) {
            clazz::class.java
        } else if (clazz is Class<*> && clazz.name.equals(className)) {
            clazz::class.java
        } else if (clazz::class.java.superclass != null && !clazz::class.java.superclass.name.equals(
                ROOT_CLASS
            )
        ) {
            getClass(clazz::class.java.superclass, className)
        } else {
            Log.release()
                .e("getClass: Invalid argument, expected $className, received ${clazz::class.java.name} -> failure")
            null
        }
    }

    @Suppress("BooleanMethodIsAlwaysInverted")
    fun matchesClass(clazz: Any, className: String): Boolean {
        return if (clazz::class.java.name.equals(className)) {
            true
        } else if (clazz is Class<*> && clazz.name.equals(className)) {
            true
        } else if (clazz::class.java.superclass != null && !clazz::class.java.superclass.equals(
                ROOT_CLASS
            )
        ) {
            matchesClass(clazz::class.java.superclass, className)
        } else {
            Log.release()
                .e("matchesClass: Invalid argument, expected $className, received ${clazz::class.java.name} -> failure")
            false
        }
    }

    fun invokeMethod(
        clazz: Any,
        name: String,
        parameterTypes: Array<Class<*>>? = null,
        params: Array<*>? = null
    ): Any? {
        return if (!parameterTypes.isNullOrEmpty() && !params.isNullOrEmpty())
            clazz::class.java.getMethod(name, *parameterTypes).invoke(clazz, *params)
        else if (!parameterTypes.isNullOrEmpty())
            clazz::class.java.getMethod(name, *parameterTypes).invoke(clazz)
        else if (!params.isNullOrEmpty())
            clazz::class.java.getMethod(name).invoke(clazz, *params)
        else
            clazz::class.java.getMethod(name).invoke(clazz)
    }
}