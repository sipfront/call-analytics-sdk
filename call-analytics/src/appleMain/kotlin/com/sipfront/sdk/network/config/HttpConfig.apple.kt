package com.sipfront.sdk.network.config

import io.ktor.client.engine.*
import io.ktor.client.engine.darwin.*

internal actual fun getHttpClientEngine(trustAllCerts: Boolean, customSSLAlpn: String?): HttpClientEngine = Darwin.create {
    /**
     * Currently no configuration on engine required.
     *
     * In the future we could implement here a way to trust all certificates.
     * See link: https://alistairsykes.medium.com/how-to-trust-all-ssl-certificates-with-kmm-and-ktor-8f686aec0d09
     *
     * handleChallenge { session, task, challenge, completionHandler ->
     *     Custom ChallengeHandler Implementation that allows certains URLs to pass
     * }
     */
}