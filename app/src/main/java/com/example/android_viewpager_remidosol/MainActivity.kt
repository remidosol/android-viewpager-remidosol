package com.example.android_viewpager_remidosol

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.example.android_viewpager_remidosol.utils.DepthPageTransformer
import com.example.android_viewpager_remidosol.utils.ViewPagerAdapter
import com.tbuonomo.viewpagerdotsindicator.WormDotsIndicator

class MainActivity : AppCompatActivity() {

    lateinit var viewPager: ViewPager2
    lateinit var dotsIndicator: WormDotsIndicator
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
        initViewPager()
    }

    private fun initViews() {
        viewPager = findViewById(R.id.viewPager)
        dotsIndicator = findViewById(R.id.worm_dots_indicator)
    }

    private fun initViewPager() {
        val adapter = ViewPagerAdapter(this)
        viewPager.setPageTransformer(DepthPageTransformer())
        viewPager.adapter = adapter
        dotsIndicator.setViewPager2(viewPager)
    }
}