package com.leandro1995.healthypet.intent.config

import com.leandro1995.healthypet.config.callback.intent.CropImageIntentCallBack
import com.leandro1995.healthypet.intent.CropImageIntent

object CropImageIntentConfig {

    private lateinit var cropImageIntentCallBack: CropImageIntentCallBack

    fun instance(cropImageIntentCallBack: CropImageIntentCallBack) {

        this.cropImageIntentCallBack = cropImageIntentCallBack
    }

    fun cropImageSelect(cropImageIntent: CropImageIntent) {

        when (cropImageIntent) {

            CropImageIntent.View -> {

                cropImageIntentCallBack.view()
            }
        }
    }
}