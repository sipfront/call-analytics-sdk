package com.sipfront.sdk.utils

@Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")
internal actual object Platform {
    private const val VERSION_NOT_AVAILABLE = "VERSION_NOT_AVAILABLE"
    private const val NOT_A_BROWSER = "NOT_A_BROWSER"

    actual fun getOsFamily(): OsFamily = OsFamily.JAVASCRIPT

    actual fun getOsVersion(): String {
        // Attempt to get the Node.js version
        val nodeVersion = try {
            js("process.versions.node") as? String
        } catch (e: dynamic) {
            null // Failed to get the Node.js version
        }

        // If Node.js version is available, return it
        nodeVersion?.let { return it }

        // Otherwise, fallback to a different method of getting the version
        return try {
            getSupportedECMAScriptVersion()
        } catch (e: dynamic) {
            VERSION_NOT_AVAILABLE // A constant string indicating that the version is not available
        }
    }

    actual fun isDebug(): Boolean = try {
        js("process.env.NODE_ENV") == "development"
    } catch (e: dynamic) {
        // Fallback or additional check if process.env.NODE_ENV is not available
        // For example, you might check for the presence of a debug flag in the URL, window object, or some other browser-specific global state
        // If there's no clear browser-specific check, you might default to false (not in debug mode) or true (in debug mode) based on your use case
        false
    }

    actual fun getBuildType(): String = if (isDebug()) "debug" else "release"

    actual fun getDeviceModel(): String = try {
        // In a browser environment, access the user agent from the navigator object
        val userAgent: String = js("navigator.userAgent") as String
        getBrowserFromUserAgent(userAgent)
    } catch (e: dynamic) {
        // In a Node.js environment, 'navigator' is undefined.
        // You can attempt to use the 'process' object or return a default value.
        try {
            val processVersion: String = js("process.version") as String
            "Node.js $processVersion"
        } catch (e: dynamic) {
            NOT_A_BROWSER
        }
    }

    private fun getSupportedECMAScriptVersion(): String {
        return when {
            js("typeof BigInt === 'function'") != null -> "ES2020"
            js("typeof String.prototype.matchAll === 'function'") != null -> "ES2020"
            js("typeof globalThis === 'object'") != null -> "ES2020"
            js("typeof Array.prototype.flat === 'function'") != null -> "ES2019"
            isRestSpreadPropertiesSupported() -> "ES2018"
            js("typeof Object.getOwnPropertyDescriptors === 'function'") != null -> "ES2017"
            js("typeof String.prototype.padStart === 'function'") != null -> "ES2017"
            js("typeof Object.entries === 'function'") != null -> "ES2017"
            isAsyncFunctionSupported() -> "ES2017"
            js("typeof Array.prototype.includes === 'function'") != null -> "ES2016"
            js("typeof Symbol === 'function'") != null -> "ES2015"
            js("typeof Promise === 'function'") != null -> "ES2015"
            else -> "ES5"
        }
    }

    private fun isAsyncFunctionSupported(): Boolean = try {
        js("eval('async function() {}')")
        true
    } catch (e: dynamic) {
        false
    }

    private fun isRestSpreadPropertiesSupported(): Boolean = try {
        js("eval('({...{a: 1}})')")
        true
    } catch (e: dynamic) {
        false
    }

    private fun getBrowserFromUserAgent(userAgent: String): String {
        return when {
            userAgent.contains("Firefox", ignoreCase = true) -> "Firefox"
            userAgent.contains("Chrome", ignoreCase = true) -> "Chrome"
            userAgent.contains("Safari", ignoreCase = true) -> "Safari"
            userAgent.contains("Edge", ignoreCase = true) -> "Edge"
            userAgent.contains("Opera", ignoreCase = true) -> "Opera"
            userAgent.contains("MSIE", ignoreCase = true) -> "Internet Explorer"
            else -> "Unknown"
        }
    }
}