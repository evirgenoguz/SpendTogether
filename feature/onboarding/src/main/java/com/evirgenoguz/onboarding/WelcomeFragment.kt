package com.evirgenoguz.onboarding

import android.os.Handler
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.evirgenoguz.onboarding.databinding.FragmentWelcomeBinding
import com.evirgenoguz.presentation.base.BaseFragment
import com.evirgenoguz.splash.SplashFragmentDirections

class WelcomeFragment : BaseFragment<FragmentWelcomeBinding>(FragmentWelcomeBinding::inflate) {
    override fun setupUI() {
        binding.fabNext.setOnClickListener {
            val viewPager = activity?.findViewById<ViewPager2>(R.id.viewpager_onboarding)
            viewPager?.let {
                it.currentItem = 1
            }
        }
    }

    override fun onResume() {
        super.onResume()
        val viewPager = activity?.findViewById<ViewPager2>(R.id.viewpager_onboarding)
        Handler().postDelayed({
            viewPager?.let {
                it.currentItem = 1
            }
        }, 3000)
    }
}