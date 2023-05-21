package com.leandro1995.healthypet.viewmodel

import androidx.lifecycle.ViewModel
import com.leandro1995.healthypet.intent.CameraIntent
import com.leandro1995.healthypet.model.design.Camera
import kotlinx.coroutines.flow.MutableStateFlow

class CameraViewModel : ViewModel() {

    companion object {

        const val PHOTO = 0
    }

    val cameraMutableStateFlow: MutableStateFlow<CameraIntent> by lazy {
        MutableStateFlow(CameraIntent.View)
    }

    val onClick = fun(action: Int) {

        when (action) {

            PHOTO -> {

                photo()
            }
        }
    }

    private fun photo() {

        cameraMutableStateFlow.value = CameraIntent.Photo(camera = Camera())
    }
}