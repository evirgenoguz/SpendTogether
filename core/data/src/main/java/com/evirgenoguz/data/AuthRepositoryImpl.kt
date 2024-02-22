package com.evirgenoguz.data

import com.evirgenoguz.common.ResponseState
import com.evirgenoguz.data.utils.await
import com.evirgenoguz.network.dto.request.LoginRequest
import com.evirgenoguz.network.dto.request.RegisterRequest
import com.evirgenoguz.network.dto.request.ResetPasswordRequest
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.UserProfileChangeRequest
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val firebaseAuth: FirebaseAuth
) : AuthRepository {
    override val currentUser: FirebaseUser?
        get() = firebaseAuth.currentUser

    override suspend fun login(loginRequest: LoginRequest): Flow<ResponseState<FirebaseUser>> {
        return flow {
            emit(ResponseState.Loading)
            try {
                val response = firebaseAuth.signInWithEmailAndPassword(
                    loginRequest.email,
                    loginRequest.password
                ).await()
                emit(ResponseState.Success(response.user!!))
            } catch (e: Exception) {
                emit(ResponseState.Error(e.message.toString()))
            }
        }
    }

    override suspend fun register(registerRequest: RegisterRequest): Flow<ResponseState<FirebaseUser>> {
        return flow {
            emit(ResponseState.Loading)
            try {
                val response = firebaseAuth.createUserWithEmailAndPassword(
                    registerRequest.email,
                    registerRequest.password
                ).await()
                response.user?.updateProfile(
                    UserProfileChangeRequest.Builder().setDisplayName(registerRequest.nickName)
                        .build()
                )?.await()
                //Todo should add saveProfile function for store users to firestore
                emit(ResponseState.Success(response.user!!))
            } catch (e: Exception) {
                emit(ResponseState.Error(e.message.toString()))
            }
        }
    }

    override suspend fun resetPassword(resetPasswordRequest: ResetPasswordRequest): Flow<ResponseState<Void>> {
        return flow {
            emit(ResponseState.Loading)
            try {
                val response = firebaseAuth.sendPasswordResetEmail(resetPasswordRequest.email).await()
                emit(ResponseState.Success(response))
            } catch (e: Exception) {
                emit(ResponseState.Error(e.message.toString()))
            }
        }
    }

    override fun logOut() {
        if (currentUser != null) {
            firebaseAuth.signOut()
        }
    }
}