package com.evirgenoguz.login_register

import android.util.Log
import androidx.fragment.app.viewModels
import com.evirgenoguz.login_register.databinding.FragmentRegisterBinding
import com.evirgenoguz.model.RegisterModel
import com.evirgenoguz.presentation.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RegisterFragment : BaseFragment<FragmentRegisterBinding>(FragmentRegisterBinding::inflate) {

    private val registerViewModel by viewModels<RegisterViewModel>()

    override fun setupUI() {
        super.setupUI()
        initListeners()
    }

    private fun initListeners() = with(binding) {
        buttonRegister.setOnClickListener {
            registerViewModel.register(
                RegisterModel(
                    nickName = editTextNick.text.toString(),
                    email = editTextEmail.text.toString(),
                    password = editTextPassword.text.toString()
                )
            )
        }

        textViewToLogin.setOnClickListener {
            navigate(RegisterFragmentDirections.actionRegisterFragmentToLoginFragment())
        }
    }

    override fun observeUI() {
        registerViewModel.registerScreenUiState.observe(viewLifecycleOwner) { registerScreenUiState ->
            when (registerScreenUiState) {
                RegisterScreenUiState.Loading -> handleLoading()
                is RegisterScreenUiState.Success -> handleSuccess()
                is RegisterScreenUiState.Error -> handleError(registerScreenUiState.message)
            }
        }
    }

    private fun handleSuccess() {
        //Todo navigate to loginFragment and show ToastMessage you are succesfully registered
        navigate(RegisterFragmentDirections.actionRegisterFragmentToLoginFragment())
        Log.d("RegisterFragment", "Success Handle")
    }

    private fun handleLoading() {
        //Todo show progress dialog
        Log.d("RegisterFragment", "Loading Handle")
    }

    private fun handleError(message: String) {
        //Todo show error dialog
        Log.d("RegisterFragment", message)
    }

}