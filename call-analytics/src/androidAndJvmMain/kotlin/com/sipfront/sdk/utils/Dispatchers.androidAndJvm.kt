package com.sipfront.sdk.utils

import kotlinx.coroutines.CoroutineDispatcher

actual class DispatcherProvider {
    actual companion object {
        actual val IO: CoroutineDispatcher
            get() = kotlinx.coroutines.Dispatchers.IO
    }
}