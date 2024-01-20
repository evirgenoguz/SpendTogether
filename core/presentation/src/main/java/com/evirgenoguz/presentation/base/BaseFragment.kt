package com.evirgenoguz.presentation.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import androidx.viewbinding.ViewBinding
import com.evirgenoguz.presentation.viewBinding

abstract class BaseFragment<T : ViewBinding>(factory: (LayoutInflater) -> T) : Fragment() {

    val binding: T by viewBinding(factory)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        callInitialViewModelFunction()
        setupUI()
        observeUI()
    }

    open fun setupUI() = Unit

    open fun observeUI() = Unit

    open fun callInitialViewModelFunction() = Unit

    open fun navigate(action: NavDirections) {
        findNavController().navigate(action)
    }

}