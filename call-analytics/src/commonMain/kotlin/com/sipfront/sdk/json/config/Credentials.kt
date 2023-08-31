package com.sipfront.sdk.json.config

import com.sipfront.sdk.json.JsonKeys
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class Credentials(
    @SerialName(JsonKeys.SessionConfig.Credentials.username)
    val username: String,
    @SerialName(JsonKeys.SessionConfig.Credentials.password)
    val password: String
)