package com.sipfront.sdk.log

import co.touchlab.kermit.LogWriter
import co.touchlab.kermit.NoTagFormatter
import co.touchlab.kermit.platformLogWriter

actual fun getLogWriter(): LogWriter = platformLogWriter(NoTagFormatter)