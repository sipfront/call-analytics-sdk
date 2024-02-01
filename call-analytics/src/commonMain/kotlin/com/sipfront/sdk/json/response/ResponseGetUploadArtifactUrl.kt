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
data class ResponseGetUploadArtifactUrl internal constructor(
    @SerialName(JsonKeys.Response.status)
    val status: String,
    @SerialName(JsonKeys.Response.UploadArtifact.url)
    val url: String
)
