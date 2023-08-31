package com.sipfront.sdk.pjsip.pjsua2.enums

import com.sipfront.sdk.json.message.enums.MediaDirection

enum class PjMediaDir(val value: Int) {
    PJMEDIA_DIR_NONE(0),
    PJMEDIA_DIR_ENCODING(1),
    PJMEDIA_DIR_DECODING(2),
    PJMEDIA_DIR_ENCODING_DECODING(3);


    companion object {
        @JvmStatic
        fun valueOf(value: Int): PjMediaDir {
            for (mediaDir in PjMediaDir.values())
                if (mediaDir.value == value) return mediaDir
            return PJMEDIA_DIR_NONE
        }
    }

    fun toMediaDirection(): MediaDirection = when(this) {
        PJMEDIA_DIR_NONE -> MediaDirection.INACTIVE
        PJMEDIA_DIR_ENCODING -> MediaDirection.SEND_ONLY
        PJMEDIA_DIR_DECODING -> MediaDirection.RECEIVE_ONLY
        PJMEDIA_DIR_ENCODING_DECODING -> MediaDirection.SEND_RECEIVE
    }
}