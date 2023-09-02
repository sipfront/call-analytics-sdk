package com.sipfront.sdk.log

import co.touchlab.kermit.*
import com.sipfront.sdk.BuildKonfig

object Log {
    private var isLoggingEnabled: Boolean = false
    private var logger: Logger = Logger(loggerConfigInit(getLogWriter()), BuildKonfig.PROJECT_NAME)

    internal fun enableLogging(enable: Boolean) {
        isLoggingEnabled = enable
        Logger.setMinSeverity(if (isLoggingEnabled) Severity.Verbose else Severity.Warn)
    }

    fun debug(): Logger? {
        return if (isLoggingEnabled) {
            logger
        } else {
            null
        }
    }

    fun release(): Logger = logger
}

expect fun getLogWriter(): LogWriter