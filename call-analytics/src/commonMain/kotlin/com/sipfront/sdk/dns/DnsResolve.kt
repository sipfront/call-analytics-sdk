package com.sipfront.sdk.dns

import com.sipfront.sdk.utils.DispatcherProvider
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

internal object DnsResolve {
    fun cname(server: String): Flow<String> = flow {
        resolveCname(server)?.let {
            emit(it)
        }
    }.flowOn(DispatcherProvider.IO)
}

internal expect fun resolveCname(server: String): String?