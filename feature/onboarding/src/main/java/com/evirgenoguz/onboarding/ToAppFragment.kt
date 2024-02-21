package com.evirgenoguz.onboarding

import android.content.Context
import android.os.Handler
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.evirgenoguz.onboarding.databinding.FragmentToAppBinding
import com.evirgenoguz.presentation.base.BaseFragment

class ToAppFragment : BaseFragment<FragmentToAppBinding>(FragmentToAppBinding::inflate) {
    override fun setupUI() {
        binding.fabDone.setOnClickListener {
            val action = OnBoardingFragmentDirections.actionOnBoardingFragmentToLoginFragment()
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

    override fun onResume() {
        super.onResume()
        val viewPager = activity?.findViewById<ViewPager2>(R.id.viewpager_onboarding)
        Handler().postDelayed({
            viewPager?.let {
                it.currentItem = 0
            }
        }, 3000)
    }
}