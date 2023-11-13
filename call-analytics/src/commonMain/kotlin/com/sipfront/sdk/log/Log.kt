package com.sipfront.sdk.log

import co.touchlab.kermit.*
import com.sipfront.sdk.BuildKonfig

internal object Log {
    private var isDebugLoggingEnabled: Boolean = false
    private var logger: Logger = Logger(loggerConfigInit(getLogWriter()), BuildKonfig.PROJECT_NAME)

    fun enableDebugLogs(enable: Boolean) {
        isDebugLoggingEnabled = enable
        Logger.setMinSeverity(if (isDebugLoggingEnabled) Severity.Verbose else Severity.Warn)
    }

    fun debug(): Logger? {
        return if (isDebugLoggingEnabled) {
            logger
        } else {
            null
        }
    }

    fun release(): Logger = logger
}

internal expect fun getLogWriter(): LogWriter