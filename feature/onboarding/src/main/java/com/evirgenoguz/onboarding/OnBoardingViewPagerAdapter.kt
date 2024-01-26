package com.evirgenoguz.onboarding

import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewbinding.ViewBinding
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.evirgenoguz.presentation.base.BaseFragment

/**
 * @Author: Oguz Evirgen
 * @Date: 26.01.2024
 */

class OnBoardingViewPagerAdapter(
    private val fragmentList: ArrayList<BaseFragment<out ViewBinding>>,
    fragmentManager: FragmentManager,
    lifecycle: Lifecycle
) : FragmentStateAdapter(fragmentManager, lifecycle) {
    override fun getItemCount() = fragmentList.size

    override fun createFragment(position: Int) = fragmentList[position]
}