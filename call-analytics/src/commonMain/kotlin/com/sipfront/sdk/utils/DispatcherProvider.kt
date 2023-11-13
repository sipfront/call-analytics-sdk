package com.sipfront.sdk.utils

import kotlinx.coroutines.CoroutineDispatcher

@Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")
internal expect class DispatcherProvider {
    companion object {
        val IO: CoroutineDispatcher
    }
}