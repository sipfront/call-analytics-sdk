package com.sipfront.sdk.json

internal object JsonKeys {
    const val param: String = "param"
    const val timestamp: String = "timestamp"

    object Call {
        const val id: String = "id"
        const val direction: String = "direction"
    }

    object Address {
        const val local: String = "accountaor"
        const val remote: String = "peeruri"
        const val remoteDisplayName: String = "peerdisplayname"
    }

    object Message {
        const val clazz: String = "class"
        const val type: String = "type"
    }

    object Rtcp {
        const val interfaces: String = "interfaces"
        const val localJitterEnabled: String = "local_jitter_enabled"
        const val producer: String = "producer"

        object Producer {
            const val name: String = "name"
            const val version: String = "version"
        }

        object Interface {
            const val name: String = "name"
            const val rate: String = "rate"
            const val ingress: String = "ingress"
            const val egress: String = "egress"
            const val ingressRate: String = "ingress_rate"
            const val egressRate: String = "egress_rate"
            const val voipMetrics: String = "voip_metrics"
            const val voipMetricsInterval: String = "voip_metrics_interval"
            const val mediaOutbound: String = "media_outbound"
            const val mediaInbound: String = "media_inbound"

            object Rate {
                const val packetsLost: String = "packets_lost"
            }

            object Ingress {
                const val packets: String = "packets"
                const val bytes: String = "bytes"
                const val packetsLost: String = "packets_lost"
                const val jitterAverageMs: String = "jitter_average_ms"
                const val jitterSamples: String = "jitter_samples"
            }

            object Egress {
                const val packets: String = "packets"
                const val bytes: String = "bytes"
                const val packetsLost: String = "packets_lost"
                const val jitterAverageMs: String = "jitter_average_ms"
                const val jitterSamples: String = "jitter_samples"
                const val rttAverageMs: String = "rtt_average_ms"
                const val rttSamples: String = "rtt_samples"
            }

            object IngressRate {
                const val packets: String = "packets"
                const val bytes: String = "bytes"
                const val packetsLost: String = "packets_lost"
                const val jitterMs: String = "jitter_ms"
                const val jitterSamples: String = "jitter_samples"
            }

            object EgressRate {
                const val packets: String = "packets"
                const val bytes: String = "bytes"
                const val packetsLost: String = "packets_lost"
                const val packetsLostSamples: String = "packets_lost_samples"
                const val jitterMs: String = "jitter_ms"
                const val jitterSamples: String = "jitter_samples"
                const val rttMs: String = "rtt_ms"
                const val rttSamples: String = "rtt_samples"
            }

            object VoipMetrics {
                const val mosAverage: String = "mos_average"
                const val jitterAverage: String = "jitter_average"
                const val jitterMeasuredAverage: String = "jitter_measured_average"
                const val rttDscAverage: String = "rtt_dsct_average"
                const val packetLossTotal: String = "packetloss_total"
            }

            object VoipMetricsInterval {
                const val jitter: String = "jitter"
                const val jitterMeasured: String = "jitter_measured"
            }

            object MediaStats {
                const val audioLevel: String = "audio_level"
                const val totalAudioEnergy: String = "total_audio_energy"
            }
        }
    }

    object SessionConfig {
        const val sessionId: String = "session_id"
        const val instanceId: String = "instance_id"
        const val server: String = "server"
        const val credentials: String = "credentials"
        const val mqttRtcpPath: String = "mqtt_rtcp_path"
        const val mqttSipPath: String = "mqtt_sip_path"
        const val sipfrontApi: String = "sipfront_api"
        const val sipfrontApiToken: String = "sipfront_api_token"
        const val role: String = "role"

        object Credentials {
            const val username: String = "username"
            const val password: String = "password"
        }
    }

    object Response {
        const val status: String = "status"

        object UploadArtifact {
            const val url: String = "url"
        }

        object Mqtt {
            const val message = "message"
            const val traceId = "traceId"
        }
    }

    object Media {
        object Stream {
            const val direction = "direction"
            const val mimeType = "mime_type"
            const val fileName = "file_name"

            object MimeType {
                const val raw = "raw"
                const val codec = "codec"
                const val mediaType = "media_type"
                const val extension = "extension"

                object Codec {
                    const val displayName = "display_name"
                }
            }
        }
    }
}
