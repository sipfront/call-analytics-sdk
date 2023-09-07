package com.sipfront.sdk.pjsip.pjsua2.enums

import com.sipfront.sdk.json.message.enums.CallDirection

enum class PjSipRole(val value: Int) {
    /**
     * Outgoing Call
     */
    PJSIP_ROLE_UAC(0),

    /**
     * Incoming Call
     */
    PJSIP_ROLE_UAS(1);

    companion object {
        @JvmStatic
        fun valueOf(value: Int): PjSipRole {
            for (role in entries)
                if (role.value == value) return role
            return PJSIP_ROLE_UAC
        }
    }

    fun toCallDirection(): CallDirection = when(this) {
        PJSIP_ROLE_UAC -> CallDirection.OUTGOING
        PJSIP_ROLE_UAS -> CallDirection.INCOMING
    }
}