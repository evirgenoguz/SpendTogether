package com.evirgenoguz.domain

import com.evirgenoguz.common.ResponseState
import com.evirgenoguz.data.AuthRepository
import com.evirgenoguz.model.RegisterModel
import com.google.firebase.auth.FirebaseUser
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * @Author: Oguz Evirgen
 * @Date: 24.02.2024
 */

class RegisterUseCase @Inject constructor(
    private val authRepository: AuthRepository,
) {

    suspend operator fun invoke(registerModel: RegisterModel): Flow<ResponseState<FirebaseUser>> {
        return authRepository.register(registerModel)
    }

}