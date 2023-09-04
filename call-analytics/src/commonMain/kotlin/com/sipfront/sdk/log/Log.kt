package com.sipfront.sdk.log

import co.touchlab.kermit.*
import com.sipfront.sdk.BuildKonfig

internal object Log {
    private var isLoggingEnabled: Boolean = false
    private var logger: Logger = Logger(loggerConfigInit(getLogWriter()), BuildKonfig.PROJECT_NAME)

    fun enableLogging(enable: Boolean) {
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

internal expect fun getLogWriter(): LogWriter