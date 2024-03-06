package com.evirgenoguz.data.utils

import com.evirgenoguz.model.LoginModel
import com.evirgenoguz.model.RegisterModel
import com.evirgenoguz.network.dto.request.LoginRequest
import com.evirgenoguz.network.dto.request.RegisterRequest

/**
 * @Author: Oguz Evirgen
 * @Date: 24.02.2024
 */

fun LoginModel.toLoginRequest(): LoginRequest {
    return LoginRequest(
        email = this.email,
        password = this.password
    )
}

fun RegisterModel.toRegisterRequest(): RegisterRequest {
    return RegisterRequest(
        nickName = this.nickName,
        email =  this.email,
        password = this.password
    )
}