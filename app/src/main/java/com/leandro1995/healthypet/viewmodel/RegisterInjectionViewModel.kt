package com.leandro1995.healthypet.viewmodel

import androidx.lifecycle.ViewModel
import com.leandro1995.healthypet.intent.RegisterInjectionIntent
import kotlinx.coroutines.flow.MutableStateFlow

class RegisterInjectionViewModel : ViewModel() {

    val registerInjectionMutableSateFlow: MutableStateFlow<RegisterInjectionIntent> by lazy {
        MutableStateFlow(RegisterInjectionIntent.View)
    }
}