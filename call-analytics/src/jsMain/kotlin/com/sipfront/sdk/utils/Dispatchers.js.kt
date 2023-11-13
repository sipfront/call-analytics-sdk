@file:Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")

package com.sipfront.sdk.utils

import kotlinx.coroutines.CoroutineDispatcher

internal actual class DispatcherProvider {
    actual companion object {
        actual val IO : CoroutineDispatcher = kotlinx.coroutines.Dispatchers.Default
    }
}