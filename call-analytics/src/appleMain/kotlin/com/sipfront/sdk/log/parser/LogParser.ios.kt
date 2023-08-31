package com.sipfront.sdk.log.parser

actual fun processLogs(processLogLine: (String) -> Unit) {
    throw NotImplementedError("LogParser is currently not implemented on iOS")
}