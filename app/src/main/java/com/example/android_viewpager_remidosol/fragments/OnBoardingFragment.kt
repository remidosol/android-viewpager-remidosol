package com.example.android_viewpager_remidosol.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.android_viewpager_remidosol.databinding.FragmentOnboardingBinding
import com.example.android_viewpager_remidosol.utils.DepthPageTransformer
import com.example.android_viewpager_remidosol.utils.ViewPagerAdapter

class OnBoardingFragment : Fragment() {
    private lateinit var binding: FragmentOnboardingBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOnboardingBinding.inflate(inflater, container, false)
        val view = binding.root
        initViewPager()
        return view
    }

    private fun initViewPager() {
        val adapter = ViewPagerAdapter(requireActivity() as AppCompatActivity)
        binding.viewPager.setPageTransformer(DepthPageTransformer())
        binding.viewPager.adapter = adapter
        binding.wormDotsIndicator.setViewPager2(binding.viewPager)
    }
}