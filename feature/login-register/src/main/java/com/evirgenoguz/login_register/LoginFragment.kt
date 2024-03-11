package com.evirgenoguz.login_register

import android.util.Log
import androidx.fragment.app.viewModels
import com.evirgenoguz.login_register.databinding.FragmentLoginBinding
import com.evirgenoguz.model.LoginModel
import com.evirgenoguz.presentation.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment : BaseFragment<FragmentLoginBinding>(FragmentLoginBinding::inflate) {

    override val viewModel by viewModels<LoginViewModel>()

    override fun setupUI() {
        super.setupUI()
        initListeners()
    }

    private fun initListeners() = with(binding) {
        buttonLogin.setOnClickListener {
            viewModel.login(
                LoginModel(
                    editTextEmail.text.toString(),
                    editTextPassword.text.toString()
                )
            )
        }

        textViewForgotPassword.setOnClickListener {
            // TODO: show a dialog that include edittext for user's mail
            // viewmodelda reset password methodu olustur
            // reset password icin usecase olustur
            // reset password custom layoutdan aldigin maili viewmodel iceisindeki resetpassword
            // methoduna Model nesnesi icerisinde gonder
            // mail gonderimi basarili seklinde bir toast mesaj yazilabilir
        }

        textViewRegister.setOnClickListener {
            navigate(LoginFragmentDirections.actionLoginFragmentToRegisterFragment())
        }
    }

    override fun observeUI() {
        viewModel.loginScreenUiState.observe(viewLifecycleOwner) { loginScreenUiState ->
            when (loginScreenUiState) {
                LoginScreenUiState.Loading -> handleLoading()
                is LoginScreenUiState.Success -> handleSuccess()
                is LoginScreenUiState.Error -> handleError(loginScreenUiState.message)
            }
        }
    }

    private fun handleSuccess() {
        //Todo navigate to homepage
        navigate(LoginFragmentDirections.actionLoginFragmentToSampleFragment())
        Log.d("LoginFragment", "Success Handle")
    }

    private fun handleLoading() {
        //Todo show progress dialog
        Log.d("LoginFragment", "Loading Handle")
    }

    private fun handleError(message: String) {
        //Todo show error dialog
        Log.d("LoginFragment", message)
    }

}