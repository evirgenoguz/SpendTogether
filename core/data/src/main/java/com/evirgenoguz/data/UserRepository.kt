package com.evirgenoguz.data

import com.evirgenoguz.common.ResponseState
import com.evirgenoguz.model.User
import kotlinx.coroutines.flow.Flow

interface UserRepository {

    suspend fun saveUser(user: User): Flow<ResponseState<User>>

    suspend fun deleteUser()

    suspend fun updateUser()

    suspend fun getUser()

    fun isUserInDatabase()

}