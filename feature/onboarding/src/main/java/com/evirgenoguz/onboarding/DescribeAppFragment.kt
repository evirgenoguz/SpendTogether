package com.evirgenoguz.onboarding

import android.os.Handler
import androidx.viewpager2.widget.ViewPager2
import com.evirgenoguz.onboarding.databinding.FragmentDescribeAppBinding
import com.evirgenoguz.presentation.base.BaseFragment

class DescribeAppFragment : BaseFragment<FragmentDescribeAppBinding>(FragmentDescribeAppBinding::inflate) {
    override fun setupUI() {
        binding.fabNext.setOnClickListener {
            val viewPager = activity?.findViewById<ViewPager2>(R.id.viewpager_onboarding)
            viewPager?.let {
                it.currentItem = 2
            }
        }
    }

    override fun onResume() {
        super.onResume()
        val viewPager = activity?.findViewById<ViewPager2>(R.id.viewpager_onboarding)
        Handler().postDelayed({
            viewPager?.let {
                it.currentItem = 2
            }
        }, 3000)
    }
}