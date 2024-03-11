package com.evirgenoguz.onboarding

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.evirgenoguz.onboarding.databinding.FragmentOnBoardingBinding

class OnBoardingFragment : Fragment() {

    private var _binding: FragmentOnBoardingBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentOnBoardingBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupUI()
    }

    private fun setupUI() {
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

        if (onBoardingFinished()) {
            findNavController().navigate(OnBoardingFragmentDirections.actionOnBoardingFragmentToLoginFragment())
        }
    }

    private fun onBoardingFinished(): Boolean {
        val sharedPref = activity?.getSharedPreferences("onBoarding", Context.MODE_PRIVATE)
        return sharedPref?.getBoolean("Finished", false) ?: false
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}