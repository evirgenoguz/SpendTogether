package com.evirgenoguz.network.dto

import com.google.gson.annotations.SerializedName

data class SampleResponse(
    @SerializedName("sample-id")
    val id: Int,
    @SerializedName("sample-user")
    val user: String
)
