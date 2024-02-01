package com.sipfront.sdk.json.response

import com.sipfront.sdk.json.JsonKeys
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.js.ExperimentalJsExport
import kotlin.js.JsExport

@OptIn(ExperimentalJsExport::class)
@Serializable
@SerialName("ResponseGetUploadArtifactUrl")
@JsExport
data class ResponseMqttMessage internal constructor(
    @SerialName(JsonKeys.Response.Mqtt.message)
    val message: String,
    @SerialName(JsonKeys.Response.Mqtt.traceId)
    val traceId: String
)
