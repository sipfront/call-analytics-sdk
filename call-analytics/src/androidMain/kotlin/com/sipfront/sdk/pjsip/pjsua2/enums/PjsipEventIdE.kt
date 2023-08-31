package com.sipfront.sdk.pjsip.pjsua2.enums

enum class PjsipEventIdE(val value: Int) {
    PJSIP_EVENT_UNKNOWN(0),
    PJSIP_EVENT_TIMER(1),
    PJSIP_EVENT_TX_MSG(2),
    PJSIP_EVENT_RX_MSG(3),
    PJSIP_EVENT_TRANSPORT_ERROR(4),
    PJSIP_EVENT_TSX_STATE(5),
    PJSIP_EVENT_USER(6);


    companion object {
        @JvmStatic
        fun valueOf(value: Int): PjsipEventIdE {
            for (pjsipEventIdE in PjsipEventIdE.values())
                if (pjsipEventIdE.value == value) return pjsipEventIdE
            return PJSIP_EVENT_UNKNOWN
        }
    }
}