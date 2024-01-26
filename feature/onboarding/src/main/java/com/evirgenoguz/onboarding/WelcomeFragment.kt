package com.evirgenoguz.onboarding

import androidx.viewpager2.widget.ViewPager2
import com.evirgenoguz.onboarding.databinding.FragmentWelcomeBinding
import com.evirgenoguz.presentation.base.BaseFragment

class WelcomeFragment : BaseFragment<FragmentWelcomeBinding>(FragmentWelcomeBinding::inflate) {
    override fun setupUI() {
        binding.fabNext.setOnClickListener {
            val viewPager = activity?.findViewById<ViewPager2>(R.id.viewpager_onboarding)
            viewPager?.let {
                it.currentItem = 1
            }
        }
    }
}