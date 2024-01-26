package com.evirgenoguz.onboarding

import android.content.Context
import androidx.navigation.fragment.findNavController
import com.evirgenoguz.onboarding.databinding.FragmentToAppBinding
import com.evirgenoguz.presentation.base.BaseFragment

class ToAppFragment : BaseFragment<FragmentToAppBinding>(FragmentToAppBinding::inflate) {
    override fun setupUI() {
        binding.fabDone.setOnClickListener {
            val action = OnBoardingFragmentDirections.actionOnBoardingFragmentToSampleFragment()
            findNavController().navigate(action)
            onBoardingFinished()
        }
    }

    private fun onBoardingFinished() {
        val sharedPref = activity?.getSharedPreferences("onBoarding", Context.MODE_PRIVATE)
        val editor = sharedPref?.edit()
        editor?.putBoolean("Finished", true)
        editor?.apply()
    }
}