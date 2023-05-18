package com.leandro1995.healthypet.viewmodel

import androidx.lifecycle.ViewModel
import com.leandro1995.healthypet.intent.WelcomeIntent
import kotlinx.coroutines.flow.MutableStateFlow

class WelcomeViewModel : ViewModel() {

    val welComeMutableStateFlow: MutableStateFlow<WelcomeIntent> by lazy {
        MutableStateFlow(WelcomeIntent.View)
    }
}