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

        object Interface {
            const val name: String = "name"
            const val rate: String = "rate"
            const val ingress: String = "ingress"
            const val egress: String = "egress"
            const val ingressRate: String = "ingress_rate"
            const val egressRate: String = "egress_rate"
            const val voipMetrics: String = "voip_metrics"
            const val mediaOutbound: String = "media_outbound"
            const val mediaInbound: String = "media_inbound"

            object Rate {
                const val packetsLost: String = "packets_lost"
            }

            object Ingress {
                const val packets: String = "packets"
                const val bytes: String = "bytes"
            }

            object Egress {
                const val packets: String = "packets"
                const val bytes: String = "bytes"
            }

            object IngressRate {
                const val packets: String = "packets"
                const val bytes: String = "bytes"
            }

            object EgressRate {
                const val packets: String = "packets"
                const val bytes: String = "bytes"
            }

            object VoipMetrics {
                const val mosAverage: String = "mos_average"
                const val jitterAverage: String = "jitter_average"
                const val rttDscAverage: String = "rtt_dsct_average"
                const val packetLossTotal: String = "packetloss_total"
            }

            object MediaStats {
                const val audioLevel: String = "audio_level"
                const val totalAudioEnergy: String = "total_audio_energy"
            }
        }
    }

    object SessionConfig {
        const val sessionId: String = "session_id"
        const val server: String = "server"
        const val credentials: String = "credentials"
        const val mqttRtcpPath: String = "mqtt_rtcp_path"
        const val mqttSipPath: String = "mqtt_sip_path"

        object Credentials {
            const val username: String = "username"
            const val password: String = "password"
        }
    }
}