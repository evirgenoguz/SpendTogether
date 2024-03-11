package com.evirgenoguz.login_register

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.evirgenoguz.common.ResponseState
import com.evirgenoguz.domain.RegisterUseCase
import com.evirgenoguz.domain.SaveUserUseCase
import com.evirgenoguz.model.RegisterModel
import com.evirgenoguz.model.User
import com.evirgenoguz.presentation.base.BaseViewModel
import com.google.firebase.auth.FirebaseUser
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(
    private val registerUseCase: RegisterUseCase,
    private val saveUserUseCase: SaveUserUseCase
) : BaseViewModel() {

    private val _registerScreenUiState = MutableLiveData<RegisterScreenUiState>()
    val registerScreenUiState get() = _registerScreenUiState

    fun register(registerModel: RegisterModel) {
        viewModelScope.launch {
            registerUseCase(registerModel).collect { response ->
                when (response) {
                    ResponseState.Loading -> {
                        _registerScreenUiState.postValue(RegisterScreenUiState.Loading)
                        showIndicator()
                    }

                    is ResponseState.Success -> {
                        saveUserUseCase.invoke(
                            User(response.data.uid, registerModel.nickName, registerModel.email, "")
                        )
                        _registerScreenUiState.postValue(RegisterScreenUiState.Success(response.data))
                        hideIndicator()
                    }

                    is ResponseState.Error -> {
                        _registerScreenUiState.postValue(RegisterScreenUiState.Error(response.message))
                        //Todo will change showErrorDialog
                        hideIndicator()
                    }
                }
            }
        }
    }
}


sealed class RegisterScreenUiState {
    object Loading : RegisterScreenUiState()
    data class Error(val message: String) : RegisterScreenUiState()
    data class Success(val data: FirebaseUser) : RegisterScreenUiState()
}