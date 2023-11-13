package com.sipfront.sdk.utils

import kotlinx.coroutines.CoroutineDispatcher

@Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")
internal actual class DispatcherProvider {
    actual companion object {
        actual val IO: CoroutineDispatcher
            get() = kotlinx.coroutines.Dispatchers.IO
    }
}