package com.sipfront.sdk.log

import co.touchlab.kermit.DefaultFormatter
import co.touchlab.kermit.LogWriter
import co.touchlab.kermit.platformLogWriter

actual fun getLogWriter(): LogWriter = platformLogWriter(DefaultFormatter)