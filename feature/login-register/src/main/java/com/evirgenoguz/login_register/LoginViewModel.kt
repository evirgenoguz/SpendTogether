package com.evirgenoguz.login_register

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.evirgenoguz.common.ResponseState
import com.evirgenoguz.domain.LoginUseCase
import com.evirgenoguz.model.LoginModel
import com.evirgenoguz.presentation.base.BaseViewModel
import com.google.firebase.auth.FirebaseUser
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginUseCase: LoginUseCase
) : BaseViewModel() {

    private val _loginScreenUiState = MutableLiveData<LoginScreenUiState>()
    val loginScreenUiState: LiveData<LoginScreenUiState> get() = _loginScreenUiState


    fun login(loginModel: LoginModel) {
        viewModelScope.launch {
            loginUseCase(loginModel).collect { response ->
                when (response) {
                    is ResponseState.Loading -> {
                        _loginScreenUiState.postValue(LoginScreenUiState.Loading)
                    }

                    is ResponseState.Error -> {
                        _loginScreenUiState.postValue(
                            LoginScreenUiState.Error(response.message)
                        )
                    }

                    is ResponseState.Success -> {
                        _loginScreenUiState.postValue(LoginScreenUiState.Success(response.data))
                    }
                }
            }
        }
    }
}

sealed class LoginScreenUiState {
    object Loading : LoginScreenUiState()
    data class Error(val message: String) : LoginScreenUiState()
    data class Success(val data: FirebaseUser) : LoginScreenUiState()
}