package com.evirgenoguz.login_register

import androidx.fragment.app.viewModels
import com.evirgenoguz.login_register.databinding.FragmentRegisterBinding
import com.evirgenoguz.presentation.base.BaseFragment

class RegisterFragment : BaseFragment<FragmentRegisterBinding>(FragmentRegisterBinding::inflate) {

    private val registerViewModel by viewModels<RegisterViewModel>()

}