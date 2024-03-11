package com.evirgenoguz.onboarding

import android.content.Context
import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.evirgenoguz.onboarding.databinding.FragmentToAppBinding

class ToAppFragment : Fragment() {

    private var _binding: FragmentToAppBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentToAppBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupUI()
    }

    private fun setupUI() {
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

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}