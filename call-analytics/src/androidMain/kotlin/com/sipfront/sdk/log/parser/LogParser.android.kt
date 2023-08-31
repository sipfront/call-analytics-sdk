package com.sipfront.sdk.log.parser

actual fun processLogs(processLogLine: (String) -> Unit) {
    Runtime.getRuntime().exec("logcat -c") // Clear logs
    Runtime.getRuntime().exec("logcat -v long") // Start to capture new logs
        .inputStream
        .bufferedReader()
        .useLines { lines ->
            // Note that this forEach loop is an infinite loop until this job is cancelled.
            lines.forEach { line ->
                processLogLine(line)
            }
        }
}