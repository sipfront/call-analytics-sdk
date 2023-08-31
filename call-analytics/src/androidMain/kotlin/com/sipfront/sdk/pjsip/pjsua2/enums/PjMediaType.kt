package com.sipfront.sdk.pjsip.pjsua2.enums

enum class PjMediaType(val value: Int) {
    PJMEDIA_TYPE_NONE(0),
    PJMEDIA_TYPE_AUDIO(1),
    PJMEDIA_TYPE_VIDEO(2);


    companion object {
        @JvmStatic
        fun valueOf(value: Int): PjMediaType {
            for (mediaType in PjMediaType.values())
                if (mediaType.value == value) return mediaType
            return PJMEDIA_TYPE_NONE
        }
    }
}