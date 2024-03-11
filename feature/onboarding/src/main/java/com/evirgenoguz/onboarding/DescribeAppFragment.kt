package com.evirgenoguz.onboarding

import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.evirgenoguz.onboarding.databinding.FragmentDescribeAppBinding

class DescribeAppFragment : Fragment() {

    private var _binding: FragmentDescribeAppBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDescribeAppBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupUI()
    }

    private fun setupUI() {
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

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}