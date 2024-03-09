package com.evirgenoguz.data

import android.util.Log
import com.evirgenoguz.model.User
import com.google.firebase.firestore.FirebaseFirestore
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val fireStore: FirebaseFirestore
) : UserRepository {

    companion object {
        private const val USER_COLLECTION = "users"
    }

    override suspend fun saveUser(user: User) {
        fireStore.collection(USER_COLLECTION).document(user.uid).set(user)
            .addOnSuccessListener {
                Log.d("Deneme", "success")
            }.addOnFailureListener {
                Log.d("Deneme", "failure")
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