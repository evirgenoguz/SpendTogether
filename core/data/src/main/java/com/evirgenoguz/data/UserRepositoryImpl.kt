package com.evirgenoguz.data

import com.evirgenoguz.common.ResponseState
import com.evirgenoguz.model.User
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val fireStore: FirebaseFirestore
) : UserRepository {

    companion object {
        private const val USER_COLLECTION = "users"
    }

    override suspend fun saveUser(user: User): Flow<ResponseState<User>> {
        return flow {
            emit(ResponseState.Loading)
            val response = fireStore.collection(USER_COLLECTION).document(user.uid).set(user)

            if (response.isSuccessful) {
                emit(ResponseState.Success(user))
            } else {
                emit(ResponseState.Error("user can not save successfully"))
            }
        }
    }

    override suspend fun deleteUser() {
        TODO("Not yet implemented")
    }

    override suspend fun updateUser() {
        TODO("Not yet implemented")
    }

    override suspend fun getUser() {
        TODO("Not yet implemented")
    }

    override fun isUserInDatabase() {
        TODO("Not yet implemented")
    }
}