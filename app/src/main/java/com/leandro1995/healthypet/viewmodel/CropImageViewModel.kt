package com.leandro1995.healthypet.viewmodel

import androidx.lifecycle.ViewModel
import com.leandro1995.healthypet.intent.CropImageIntent
import kotlinx.coroutines.flow.MutableStateFlow

class CropImageViewModel : ViewModel() {

    val cropImageMutableStateFlow: MutableStateFlow<CropImageIntent> by lazy {
        MutableStateFlow(CropImageIntent.View)
    }
}