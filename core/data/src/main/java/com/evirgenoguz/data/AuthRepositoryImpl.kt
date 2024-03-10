package com.evirgenoguz.data

import com.evirgenoguz.common.ResponseState
import com.evirgenoguz.data.utils.await
import com.evirgenoguz.data.utils.toLoginRequest
import com.evirgenoguz.data.utils.toRegisterRequest
import com.evirgenoguz.model.LoginModel
import com.evirgenoguz.model.RegisterModel
import com.evirgenoguz.model.User
import com.evirgenoguz.network.dto.request.ResetPasswordRequest
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.UserProfileChangeRequest
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val firebaseAuth: FirebaseAuth,
    private val fireStore: FirebaseFirestore
) : AuthRepository {
    override val currentUser: FirebaseUser?
        get() = firebaseAuth.currentUser

    override suspend fun login(loginModel: LoginModel): Flow<ResponseState<FirebaseUser>> {
        return flow {
            emit(ResponseState.Loading)
            try {
                val loginRequest = loginModel.toLoginRequest() //That's unnecessary but that's the correct way
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

    override suspend fun register(registerModel: RegisterModel): Flow<ResponseState<FirebaseUser>> {
        return flow {
            emit(ResponseState.Loading)
            try {
                val registerRequest = registerModel.toRegisterRequest()
                val response = firebaseAuth.createUserWithEmailAndPassword(
                    registerRequest.email,
                    registerRequest.password
                ).await()
                response.user?.updateProfile(
                    UserProfileChangeRequest.Builder().setDisplayName(registerRequest.nickName)
                        .build()
                )?.await()
                fireStore.collection("users").document(response.user!!.uid).set(
                    User(
                        uid = response.user!!.uid,
                        nickName = registerModel.nickName,
                        email = registerModel.email,
                        imagePath = ""
                    )
                )
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
                val response =
                    firebaseAuth.sendPasswordResetEmail(resetPasswordRequest.email).await()
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