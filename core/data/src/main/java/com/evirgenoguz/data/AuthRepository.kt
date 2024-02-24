package com.evirgenoguz.data

import com.evirgenoguz.common.ResponseState
import com.evirgenoguz.model.LoginModel
import com.evirgenoguz.model.RegisterModel
import com.evirgenoguz.network.dto.request.ResetPasswordRequest
import com.google.firebase.auth.FirebaseUser
import kotlinx.coroutines.flow.Flow

interface AuthRepository {
    val currentUser: FirebaseUser?
    suspend fun login(loginModel: LoginModel): Flow<ResponseState<FirebaseUser>>

    suspend fun register(registerModel: RegisterModel): Flow<ResponseState<FirebaseUser>>

    suspend fun resetPassword(resetPasswordRequest: ResetPasswordRequest): Flow<ResponseState<Void>>

    fun logOut()
}