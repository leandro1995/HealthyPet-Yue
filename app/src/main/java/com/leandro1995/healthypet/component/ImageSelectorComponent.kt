package com.leandro1995.healthypet.component

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.leandro1995.healthypet.R
import com.leandro1995.healthypet.activity.CameraActivity
import com.leandro1995.healthypet.component.ambient.ViewAmbient
import com.leandro1995.healthypet.config.Setting
import com.leandro1995.healthypet.databinding.ComponentImageSelectorBinding
import com.leandro1995.healthypet.extension.putString
import com.leandro1995.healthypet.model.design.ActivityUtil
import java.io.File

class ImageSelectorComponent(context: Context, attrs: AttributeSet? = null) :
    ViewAmbient(context, attrs) {

    private lateinit var componentImageSelectorBinding: ComponentImageSelectorBinding

    private val resultLauncher = ActivityUtil.activityResultLauncher(
        activity = (context as AppCompatActivity),
        resultData = { data ->

            componentImageSelectorBinding.photoProfileSimple.setImageURI(Uri.fromFile(File((data putString Setting.IMAGE_PUT)!!)))
        })

    override fun view() {

        componentImageSelectorBinding = DataBindingUtil.inflate(
            (context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater),
            R.layout.component_image_selector,
            this,
            true
        )

        onClick()
    }

    private fun onClick() {

        componentImageSelectorBinding.addImage.setOnClickListener {

            starActivityCamera()
        }
    }

    private fun starActivityCamera() {

        resultLauncher.launch(Intent(context, CameraActivity::class.java))
    }
}