package com.evirgenoguz.login_register

import android.util.Log
import androidx.fragment.app.viewModels
import com.evirgenoguz.login_register.databinding.FragmentLoginBinding
import com.evirgenoguz.model.LoginModel
import com.evirgenoguz.presentation.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment : BaseFragment<FragmentLoginBinding>(FragmentLoginBinding::inflate) {

    private val loginViewModel by viewModels<LoginViewModel>()

    override fun setupUI() {
        super.setupUI()
        initListeners()
    }

    private fun initListeners() {
        binding.buttonLogin.setOnClickListener {
            loginViewModel.login(
                LoginModel(
                    binding.editTextEmail.text.toString(),
                    binding.editTextPassword.text.toString()
                )
            )
        }
//      Todo Don't you have account and register text will separate and register will navigate RegisterFragment
    }

    override fun observeUI() {
        loginViewModel.loginScreenUiState.observe(viewLifecycleOwner) {
            when(it){
                is LoginScreenUiState.Error -> handleError()
                LoginScreenUiState.Loading -> handleLoading()
                is LoginScreenUiState.Success -> handleSuccess()
            }
        }
    }

    private fun handleSuccess() {
        //Todo navigate to homepage
        Log.d("LoginFragment", "Success Handle")
    }

    private fun handleLoading() {
        //Todo show progress dialog
        Log.d("LoginFragment", "Loading Handle")
    }

    private fun handleError() {
        //Todo show error dialog
        Log.d("LoginFragment", "Error Handle")
    }

}