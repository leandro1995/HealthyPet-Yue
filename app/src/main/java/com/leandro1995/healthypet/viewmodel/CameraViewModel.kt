package com.leandro1995.healthypet.viewmodel

import androidx.lifecycle.ViewModel
import com.leandro1995.healthypet.intent.CameraIntent
import kotlinx.coroutines.flow.MutableStateFlow

class CameraViewModel : ViewModel() {

    val cameraMutableStateFlow: MutableStateFlow<CameraIntent> by lazy {
        MutableStateFlow(CameraIntent.View)
    }
}