package com.evirgenoguz.network.dto.request

data class RegisterRequest(
    val nickName: String,
    val email: String,
    val password: String
)
