package com.example.android_viewpager_remidosol.fragments.health.support

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.android_viewpager_remidosol.R
import com.example.android_viewpager_remidosol.databinding.FragmentSplashBinding
import com.example.android_viewpager_remidosol.databinding.FragmentSupportBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder


class HealthSupport : Fragment() {

    private lateinit var binding: FragmentSupportBinding
    private lateinit var infoButton: ImageButton

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSupportBinding.inflate(inflater, container, false)

        val view = binding.root

        infoButton = view.findViewById(R.id.infoButton)
        initListeners(view.context)

        return view
    }

    private fun initListeners(context: Context) {
        infoButton.setOnClickListener {
            showModal(context)
        }
    }

    private fun showModal(context: Context){
        MaterialAlertDialogBuilder(
            context,
            R.style.ThemeOverlay_MaterialComponents_MaterialAlertDialog
        )
            .setTitle(resources.getString(R.string.info))
            .setMessage(resources.getString(R.string.info_message))
            .setPositiveButton(resources.getString(R.string.okey)) { dialog, which ->
                dialog.cancel()
            }
            .setOnCancelListener {
                Toast.makeText(context, R.string.thanks, Toast.LENGTH_SHORT).show()
            }
            .show()
    }
}