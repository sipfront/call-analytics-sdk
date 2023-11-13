package com.sipfront.sdk.log

import co.touchlab.kermit.ConsoleWriter
import co.touchlab.kermit.LogWriter

internal actual fun getLogWriter(): LogWriter = ConsoleWriter()