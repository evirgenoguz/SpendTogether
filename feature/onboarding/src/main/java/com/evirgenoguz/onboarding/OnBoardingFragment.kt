package com.evirgenoguz.onboarding

import android.content.Context
import androidx.navigation.fragment.findNavController
import com.evirgenoguz.onboarding.databinding.FragmentOnBoardingBinding
import com.evirgenoguz.presentation.base.BaseFragment

class OnBoardingFragment :
    BaseFragment<FragmentOnBoardingBinding>(FragmentOnBoardingBinding::inflate) {
    override fun setupUI() {
        val fragmentList = arrayListOf(
            WelcomeFragment(),
            DescribeAppFragment(),
            ToAppFragment()
        )

        val adapter = OnBoardingViewPagerAdapter(
            fragmentList = fragmentList,
            fragmentManager = requireActivity().supportFragmentManager,
            lifecycle = lifecycle
        )

        binding.viewpagerOnboarding.currentItem = 0
        binding.viewpagerOnboarding.adapter = adapter
        binding.dotsIndicator.attachTo(binding.viewpagerOnboarding)

        if (false /*onBoardingFinished()*/) {
            //Todo that will navigate to login or register fragment
            findNavController().navigate(OnBoardingFragmentDirections.actionOnBoardingFragmentToSampleFragment())
        }
    }

    private fun onBoardingFinished(): Boolean {
        val sharedPref = activity?.getSharedPreferences("onBoarding", Context.MODE_PRIVATE)
        return sharedPref?.getBoolean("Finished", false) ?: false
    }
}