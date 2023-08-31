package com.sipfront.sdk.utils

import kotlinx.coroutines.CoroutineDispatcher

expect class DispatcherProvider {
    companion object {
        val IO: CoroutineDispatcher
    }
}