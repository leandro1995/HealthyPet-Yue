package com.leandro1995.healthypet.activity

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.leandro1995.healthypet.R
import com.leandro1995.healthypet.config.callback.intent.CameraIntentCallBack
import com.leandro1995.healthypet.databinding.ActivityCameraBinding
import com.leandro1995.healthypet.extension.lifecycleScope
import com.leandro1995.healthypet.intent.config.CameraIntentConfig
import com.leandro1995.healthypet.viewmodel.CameraViewModel

class CameraActivity : AppCompatActivity(), CameraIntentCallBack {

    private lateinit var cameraBinding: ActivityCameraBinding

    private val cameraViewModel by viewModels<CameraViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        CameraIntentConfig.instance(cameraIntentCallBack = this)

        cameraBinding = DataBindingUtil.setContentView(this, R.layout.activity_camera)
        cameraBinding.cameraViewModel = cameraViewModel

        collect()
    }

    private fun collect() {

        lifecycleScope(activity = this, method = {

            cameraViewModel.cameraMutableStateFlow.collect { cameraIntent ->

                CameraIntentConfig.cameraSelect(cameraIntent = cameraIntent)
            }
        })
    }

    override fun view() {

        cameraBinding.camera.setLifecycleOwner(this)
    }
}