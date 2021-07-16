package com.example.android_viewpager_remidosol.fragments.splash

import android.animation.Animator
import android.os.Bundle
import android.os.Handler
import android.os.Looper.getMainLooper
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.android_viewpager_remidosol.R
import com.example.android_viewpager_remidosol.databinding.FragmentSplashBinding

class SplashFragment : Fragment() {
    private lateinit var binding: FragmentSplashBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSplashBinding.inflate(inflater, container, false)
        val view = binding.root
        initListeners()
        return view
    }

    private fun initListeners() {
        binding.splashConstraint.setBackgroundResource(R.drawable.splash_linear_gradient)

        binding.healthCircleAnimation.addAnimatorListener(object : Animator.AnimatorListener {
            override fun onAnimationStart(animation: Animator?) {
                Log.v("Animation", "Splash screen animation has been started.")

                val firstTranslationOfAnim = binding.healthCircleAnimationCover.translationY
                binding.healthCircleAnimationCover.translationY -= binding.root.height.toFloat()
                binding.healthCircleAnimationCover.animate().translationY(firstTranslationOfAnim)
                    .setDuration(1500)
                    .setStartDelay(1000)

//                binding.healthCircleAnimation.resolveKeyPath(KeyPath("**")).forEach {
//                    Log.i("KeyPath", it.toString())
//                }
            }

            override fun onAnimationEnd(animation: Animator?) {
                Log.v("Animation", "Splash screen animation has been ended.")

                animateSplash()
            }

            override fun onAnimationCancel(animation: Animator?) {
                Log.v("Animation", "Splash screen animation has been canceled.")
            }

            override fun onAnimationRepeat(animation: Animator?) {
                Log.v("Animation", "Splash screen animation has been repeated.")
            }
        })
    }

    private fun animateSplash() {
        binding.splashConstraint.animate().translationY(2000f).setDuration(1500)
            .setStartDelay(100)
        binding.healthCircleAnimationCover.animate()
            .translationY(-2000f).setDuration(1500)
            .setStartDelay(1000)

        Handler(getMainLooper()).postDelayed({
            findNavController().navigate(R.id.action_splashFragment_to_onBoardingFragment)
        }, 600)
    }


}