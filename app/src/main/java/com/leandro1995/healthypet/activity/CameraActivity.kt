package com.leandro1995.healthypet.activity

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.leandro1995.healthypet.R
import com.leandro1995.healthypet.config.Setting
import com.leandro1995.healthypet.config.callback.camera.CameraPhotoCallBack
import com.leandro1995.healthypet.config.callback.intent.CameraIntentCallBack
import com.leandro1995.healthypet.config.listener.CameraPhotoListener
import com.leandro1995.healthypet.databinding.ActivityCameraBinding
import com.leandro1995.healthypet.extension.lifecycleScope
import com.leandro1995.healthypet.intent.config.CameraIntentConfig
import com.leandro1995.healthypet.util.DesignUtil
import com.leandro1995.healthypet.util.FileUtil
import com.leandro1995.healthypet.viewmodel.CameraViewModel

class CameraActivity : AppCompatActivity(), CameraIntentCallBack {

    private lateinit var cameraBinding: ActivityCameraBinding

    private val cameraViewModel by viewModels<CameraViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        CameraIntentConfig.instance(cameraIntentCallBack = this)

        cameraBinding = DataBindingUtil.setContentView(this, R.layout.activity_camera)
        cameraBinding.cameraViewModel = cameraViewModel

        materialToolbar()
        collect()
    }

    private fun materialToolbar() {

        DesignUtil.materialToolbar(activity = this,
            materialToolbar = cameraBinding.appBarTransparent.toolbar,
            isArrow = true,
            method = { finish() })
    }

    private fun collect() {

        lifecycleScope(activity = this, method = {

            cameraViewModel.cameraMutableStateFlow.collect { cameraIntent ->

                CameraIntentConfig.cameraSelect(cameraIntent = cameraIntent)
            }
        })
    }

    override fun view() {

        cameraBinding.apply {

            camera.let { cameraView ->

                cameraView.setLifecycleOwner(this@CameraActivity)

                cameraView.addCameraListener(CameraPhotoListener().apply {

                    cameraPhotoCallBack = object : CameraPhotoCallBack {

                        override fun photoByteArray(byteArray: ByteArray) {

                            starActivityCropImage(byteArray = byteArray)
                        }
                    }
                })
            }
        }
    }

    override fun photo() {

        cameraBinding.camera.takePicture()
    }

    private fun starActivityCropImage(byteArray: ByteArray) {

        startActivity(Intent(this@CameraActivity, CropImageActivity::class.java).apply {

            putExtra(
                Setting.IMAGE_PUT,
                FileUtil.photoUrl(activity = this@CameraActivity, byteArray = byteArray)
            )
        })
    }
}