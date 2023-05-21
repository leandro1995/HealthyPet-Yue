package com.leandro1995.healthypet.activity

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.leandro1995.healthypet.R
import com.leandro1995.healthypet.config.Setting
import com.leandro1995.healthypet.config.callback.intent.CropImageIntentCallBack
import com.leandro1995.healthypet.databinding.ActivityCropImageBinding
import com.leandro1995.healthypet.extension.lifecycleScope
import com.leandro1995.healthypet.extension.putExtra
import com.leandro1995.healthypet.intent.config.CropImageIntentConfig
import com.leandro1995.healthypet.util.DesignUtil
import com.leandro1995.healthypet.util.FileUtil
import com.leandro1995.healthypet.viewmodel.CropImageViewModel
import java.io.File

class CropImageActivity : AppCompatActivity(), CropImageIntentCallBack {

    private lateinit var cropImageBinding: ActivityCropImageBinding

    private val cropImageViewModel by viewModels<CropImageViewModel>()

    private lateinit var file: File

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        CropImageIntentConfig.instance(cropImageIntentCallBack = this)

        cropImageBinding = DataBindingUtil.setContentView(this, R.layout.activity_crop_image)
        cropImageBinding.cropImageViewModel = cropImageViewModel

        materialToolbar()
        putExtra()
        collect()
    }

    private fun materialToolbar() {

        DesignUtil.materialToolbar(activity = this,
            materialToolbar = cropImageBinding.appBarTransparent.toolbar,
            isArrow = true,
            method = { finish() })
    }

    private fun collect() {

        lifecycleScope(activity = this, method = {

            cropImageViewModel.cropImageMutableStateFlow.collect { cropImageIntent ->

                CropImageIntentConfig.cropImageSelect(cropImageIntent = cropImageIntent)
            }
        })
    }

    private fun putExtra() {

        file = File(((Setting.IMAGE_PUT putExtra this)!!))
    }

    override fun view() {

        cropImageBinding.cropImage.setImageUriAsync(Uri.fromFile(file))
    }

    override fun cropImage() {

        setResult(Activity.RESULT_OK, Intent().apply {

            putExtra(
                Setting.IMAGE_PUT, FileUtil.bitmapUrl(
                    activity = this@CropImageActivity,
                    bitmap = cropImageBinding.cropImage.getCroppedImage()!!,
                    name = file.name
                )
            )
        })

        finish()
    }
}