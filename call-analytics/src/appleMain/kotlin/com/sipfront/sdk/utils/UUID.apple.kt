package com.sipfront.sdk.utils

import platform.Foundation.NSUUID

internal actual fun randomUUID(): String = NSUUID().UUIDString()