package com.evirgenoguz.login_register

import androidx.fragment.app.viewModels
import com.evirgenoguz.login_register.databinding.FragmentLoginBinding
import com.evirgenoguz.presentation.base.BaseFragment

class LoginFragment : BaseFragment<FragmentLoginBinding>(FragmentLoginBinding::inflate) {

    private val loginViewModel by viewModels<LoginViewModel>()

}