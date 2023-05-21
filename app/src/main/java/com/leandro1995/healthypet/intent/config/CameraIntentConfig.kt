package com.leandro1995.healthypet.intent.config

import com.leandro1995.healthypet.config.callback.intent.CameraIntentCallBack
import com.leandro1995.healthypet.intent.CameraIntent

object CameraIntentConfig {

    private lateinit var cameraIntentCallBack: CameraIntentCallBack

    fun instance(cameraIntentCallBack: CameraIntentCallBack) {

        this.cameraIntentCallBack = cameraIntentCallBack
    }

    fun cameraSelect(cameraIntent: CameraIntent) {

        when (cameraIntent) {

            CameraIntent.View -> {

                cameraIntentCallBack.view()
            }

            is CameraIntent.Photo -> {

                cameraIntentCallBack.photo()
            }
        }
    }
}