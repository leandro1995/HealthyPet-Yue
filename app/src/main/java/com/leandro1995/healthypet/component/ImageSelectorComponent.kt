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
import com.leandro1995.healthypet.component.config.callback.ImageSelectorComponentCallBack
import com.leandro1995.healthypet.config.Setting
import com.leandro1995.healthypet.databinding.ComponentImageSelectorBinding
import com.leandro1995.healthypet.extension.putString
import com.leandro1995.healthypet.util.ActivityUtil
import com.leandro1995.healthypet.util.PermissionUtil
import java.io.File

class ImageSelectorComponent(context: Context, attrs: AttributeSet? = null) :
    ViewAmbient(context, attrs) {

    private lateinit var componentImageSelectorBinding: ComponentImageSelectorBinding

    var imageSelectorComponentCallBack: ImageSelectorComponentCallBack? = null

    private val resultLauncher = ActivityUtil.activityResultLauncher(
        activity = (context as AppCompatActivity),
        resultData = { data ->

            (data putString Setting.IMAGE_PUT).let { photoUrl ->

                componentImageSelectorBinding.photoProfileSimple.setImageURI(
                    Uri.fromFile(
                        File(
                            photoUrl!!
                        )
                    )
                )
                componentImageSelectorBinding.addImage.setImageResource(R.drawable.ic_edit)

                isImageSelectorComponent(url = photoUrl)
            }
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

        PermissionUtil.cameraPermission(
            fragmentActivity = (context as AppCompatActivity),
            result = {

                resultLauncher.launch(Intent(context, CameraActivity::class.java))
            })
    }

    private fun isImageSelectorComponent(url: String) {

        if (imageSelectorComponentCallBack != null) {

            imageSelectorComponentCallBack!!.photoUrl(url = url)
        }
    }
}