package com.evirgenoguz.domain

import com.evirgenoguz.data.UserRepository
import com.evirgenoguz.model.User
import javax.inject.Inject

class SaveUserUseCase @Inject constructor(
    private val userRepository: UserRepository
) {

    suspend operator fun invoke(user: User) {
        userRepository.saveUser(user)
    }

}