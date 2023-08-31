package com.sipfront.sdk.utils

import platform.Foundation.NSUUID

actual fun randomUUID(): String = NSUUID().UUIDString()