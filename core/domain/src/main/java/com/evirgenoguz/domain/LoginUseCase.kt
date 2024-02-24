package com.evirgenoguz.domain

import com.evirgenoguz.common.ResponseState
import com.evirgenoguz.data.AuthRepository
import com.evirgenoguz.model.LoginModel
import com.google.firebase.auth.FirebaseUser
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * @Author: Oguz Evirgen
 * @Date: 24.02.2024
 */

class LoginUseCase @Inject constructor(
    private val authRepository: AuthRepository
) {

    suspend operator fun invoke(loginModel: LoginModel): Flow<ResponseState<FirebaseUser>> {
        return authRepository.login(loginModel)
    }

}