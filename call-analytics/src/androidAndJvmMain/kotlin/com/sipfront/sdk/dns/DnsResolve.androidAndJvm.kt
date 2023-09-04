package com.sipfront.sdk.dns

import com.sipfront.sdk.log.Log
import org.minidns.hla.DnssecResolverApi
import org.minidns.hla.ResolverResult
import org.minidns.record.CNAME

internal actual fun resolveCname(server: String): String? {
    val result: ResolverResult<CNAME> =
        DnssecResolverApi.INSTANCE.resolve(server, CNAME::class.java)

    if (!result.wasSuccessful()) {
        Log.release().e("Failed resolving CNAME of server: $server with response code: ${result.responseCode}")
        return null
    }
    if (result.answers.isEmpty()) {
        Log.release().e("No CNAME found for server: $server")
        return null
    }

    return result.answers.elementAt(0).target.toString()
}