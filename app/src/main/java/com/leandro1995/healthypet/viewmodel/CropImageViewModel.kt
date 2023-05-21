package com.leandro1995.healthypet.viewmodel

import androidx.lifecycle.ViewModel
import com.leandro1995.healthypet.intent.CropImageIntent
import kotlinx.coroutines.flow.MutableStateFlow

class CropImageViewModel : ViewModel() {

    companion object {

        const val CROP_IMAGE = 0
    }

    val cropImageMutableStateFlow: MutableStateFlow<CropImageIntent> by lazy {
        MutableStateFlow(CropImageIntent.View)
    }

    val onClick = fun(action: Int) {

        when (action) {

            CROP_IMAGE -> {

                cropImage()
            }
        }
    }

    private fun cropImage() {

        cropImageMutableStateFlow.value = CropImageIntent.CropImage
    }
}