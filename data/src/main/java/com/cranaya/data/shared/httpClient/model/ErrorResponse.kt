package com.cranaya.data.shared.httpClient.model

import com.squareup.moshi.JsonClass


@JsonClass(generateAdapter = true)
data class ErrorResponse(
    val statusCode: Int = 500,
    val message: String = ""
)
