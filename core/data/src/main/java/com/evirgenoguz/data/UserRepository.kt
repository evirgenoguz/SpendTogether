package com.evirgenoguz.data

import com.evirgenoguz.model.User

interface UserRepository {

    suspend fun saveUser(user: User)

    suspend fun deleteUser()

    suspend fun updateUser()

    suspend fun getUser()

    fun isUserInDatabase()

}