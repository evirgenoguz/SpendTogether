package com.evirgenoguz.data

import com.evirgenoguz.common.ResponseState
import com.evirgenoguz.network.dto.request.LoginRequest
import com.evirgenoguz.network.dto.request.RegisterRequest
import com.evirgenoguz.network.dto.request.ResetPasswordRequest
import com.google.firebase.auth.FirebaseUser
import kotlinx.coroutines.flow.Flow

interface AuthRepository {
    val currentUser: FirebaseUser?
    suspend fun login(loginRequest: LoginRequest): Flow<ResponseState<FirebaseUser>>

    suspend fun register(registerRequest: RegisterRequest): Flow<ResponseState<FirebaseUser>>

    suspend fun resetPassword(resetPasswordRequest: ResetPasswordRequest): Flow<ResponseState<Void>>

    fun logOut()
}