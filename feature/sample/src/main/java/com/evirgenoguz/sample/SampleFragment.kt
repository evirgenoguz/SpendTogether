package com.evirgenoguz.sample

import android.util.Log
import androidx.fragment.app.viewModels
import com.evirgenoguz.presentation.base.BaseFragment
import com.evirgenoguz.sample.databinding.FragmentSampleBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SampleFragment : BaseFragment<FragmentSampleBinding>(FragmentSampleBinding::inflate) {

    override val viewModel by viewModels<SampleViewModel>()

    override fun callInitialViewModelFunction() {
        viewModel.getSampleData()
    }

    override fun observeUI() {
        viewModel.sampleScreenUiState.observe(viewLifecycleOwner) {
            when(it){
                is SampleScreenUiState.Error -> handleError()
                SampleScreenUiState.Loading -> handleLoading()
                is SampleScreenUiState.Success -> handleSuccess()
            }
        }
    }

    private fun handleSuccess() {
        Log.d("SampleFragment", "Success Handle")
    }

    private fun handleLoading() {
        Log.d("SampleFragment", "Success Handle")
    }

    private fun handleError() {
        Log.d("SampleFragment", "Error Handle")
    }

}