package com.sipfront.sdk.utils

import kotlinx.coroutines.CoroutineDispatcher

internal expect class DispatcherProvider {
    companion object {
        val IO: CoroutineDispatcher
    }
}