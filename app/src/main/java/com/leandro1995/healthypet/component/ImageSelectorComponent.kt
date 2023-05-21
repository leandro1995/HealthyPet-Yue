package com.leandro1995.healthypet.component

import android.content.Context
import android.content.Intent
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.databinding.DataBindingUtil
import com.leandro1995.healthypet.R
import com.leandro1995.healthypet.activity.CameraActivity
import com.leandro1995.healthypet.component.ambient.ViewAmbient
import com.leandro1995.healthypet.databinding.ComponentImageSelectorBinding

class ImageSelectorComponent(context: Context, attrs: AttributeSet? = null) :
    ViewAmbient(context, attrs) {

    private lateinit var componentImageSelectorBinding: ComponentImageSelectorBinding

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

        context.startActivity(Intent(context, CameraActivity::class.java))
    }
}