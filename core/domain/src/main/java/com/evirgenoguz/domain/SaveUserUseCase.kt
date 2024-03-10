package com.evirgenoguz.domain

import com.evirgenoguz.common.ResponseState
import com.evirgenoguz.data.UserRepository
import com.evirgenoguz.model.User
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SaveUserUseCase @Inject constructor(
    private val userRepository: UserRepository
) {

    suspend operator fun invoke(user: User): Flow<ResponseState<User>> {
        return userRepository.saveUser(user)
    }

}