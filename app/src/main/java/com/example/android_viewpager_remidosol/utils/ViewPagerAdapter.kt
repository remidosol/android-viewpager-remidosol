package com.example.android_viewpager_remidosol.utils

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.android_viewpager_remidosol.fragments.EmptyFragment
import com.example.android_viewpager_remidosol.fragments.health.info.HealthInfoFragment
import com.example.android_viewpager_remidosol.fragments.health.on_the_job.HealthOnTheJobFragment
import com.example.android_viewpager_remidosol.fragments.health.service.HealthService
import com.example.android_viewpager_remidosol.fragments.health.stat.HealthStatFragment
import com.example.android_viewpager_remidosol.fragments.health.support.HealthSupport

private const val FRAGMENT_COUNT = 5

class ViewPagerAdapter(activity: AppCompatActivity) : FragmentStateAdapter(activity) {
    override fun getItemCount(): Int = FRAGMENT_COUNT

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> HealthInfoFragment()
            1 -> HealthOnTheJobFragment()
            2 -> HealthStatFragment()
            3 -> HealthService()
            4 -> HealthSupport()
            else -> EmptyFragment()
        }
    }
}