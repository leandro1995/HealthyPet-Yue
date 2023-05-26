package com.leandro1995.healthypet.viewmodel

import androidx.lifecycle.ViewModel
import com.leandro1995.healthypet.intent.SplashIntent
import kotlinx.coroutines.flow.MutableStateFlow

class SplashViewModel : ViewModel() {

    val splashMutableStateFlow: MutableStateFlow<SplashIntent.View> by lazy {
        MutableStateFlow(SplashIntent.View)
    }
}