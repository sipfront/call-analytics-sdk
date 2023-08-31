package com.sipfront.sdk.log

import co.touchlab.kermit.*
import kotlinx.cinterop.ExperimentalForeignApi
import kotlinx.cinterop.ptr
import platform.darwin.*
import kotlin.experimental.ExperimentalNativeApi
import kotlin.native.concurrent.freeze

actual fun getLogWriter(): LogWriter = XcodePublicSeverityWriter()

internal open class XcodePublicSeverityWriter(
    private val messageStringFormatter: MessageStringFormatter = DefaultFormatter
) : PublicOSLogWriter(messageStringFormatter) {
    override fun formatMessage(severity: Severity, tag: Tag, message: Message): String =
        "${emojiPrefix(severity)} ${messageStringFormatter.formatMessage(null, tag, message)}"

    @OptIn(ExperimentalNativeApi::class)
    override fun logThrowable(osLogSeverity: UByte, throwable: Throwable) {
        // oslog cuts off longer strings, so for local development, println is more useful
        println(throwable.getStackTrace().joinToString("\n"))
    }

    //If this looks familiar, yes, it came directly from Napier :) https://github.com/AAkira/Napier#darwinios-macos-watchos-tvosintelapple-silicon
    open fun emojiPrefix(severity: Severity): String = when (severity) {
        Severity.Verbose -> "⚪️"
        Severity.Debug -> "🔵"
        Severity.Info -> "🟢"
        Severity.Warn -> "🟡"
        Severity.Error -> "🔴"
        Severity.Assert -> "🟤️"
    }
}

internal open class PublicOSLogWriter internal constructor(
    private val messageStringFormatter: MessageStringFormatter,
    private val darwinLogger: PublicDarwinLogger
) : LogWriter() {

    constructor(messageStringFormatter: MessageStringFormatter = DefaultFormatter) : this(
        messageStringFormatter,
        PublicDarwinLoggerActual
    )

    override fun log(severity: Severity, message: String, tag: String, throwable: Throwable?) {
        callLog(
            severity, formatMessage(
                severity = severity,
                message = Message(message),
                tag = Tag(tag)
            ), throwable
        )
    }

    // Added to do some testing on log format. https://github.com/touchlab/Kermit/issues/243
    open fun callLog(severity: Severity, message: String, throwable: Throwable?) {
        val osLogSeverity = kermitSeverityToOsLogType(severity)
        darwinLogger.log(osLogSeverity, message)
        if (throwable != null) {
            logThrowable(osLogSeverity, throwable)
        }
    }

    @OptIn(ExperimentalNativeApi::class)
    open fun logThrowable(osLogSeverity: UByte, throwable: Throwable) {
        throwable.message?.let { darwinLogger.log(osLogSeverity, it) }
    }

    private fun kermitSeverityToOsLogType(severity: Severity): UByte = when (severity) {
        Severity.Verbose, Severity.Debug -> OS_LOG_TYPE_DEBUG
        Severity.Info -> OS_LOG_TYPE_INFO
        Severity.Warn -> OS_LOG_TYPE_DEFAULT
        Severity.Error -> OS_LOG_TYPE_ERROR
        Severity.Assert -> OS_LOG_TYPE_FAULT
    }

    open fun formatMessage(severity: Severity, tag: Tag, message: Message): String =
        messageStringFormatter.formatMessage(null, tag, message)
}


internal interface PublicDarwinLogger {
    fun log(osLogSeverity: UByte, message: String)
}

private object PublicDarwinLoggerActual : PublicDarwinLogger {
    @OptIn(ExperimentalForeignApi::class)
    override fun log(osLogSeverity: UByte, message: String) {
        _os_log_internal(
            __dso_handle.ptr,
            OS_LOG_DEFAULT,
            osLogSeverity,
            /**
             * Override of these logging classes done in order to set here the log line to public type,
             * otherwise all iOS logs would be hidden as private in our Browserstack tests!
             */
            "%{public}s",
            message.freeze()
        )
    }
}