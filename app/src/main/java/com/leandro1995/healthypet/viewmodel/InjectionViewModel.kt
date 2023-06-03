package com.leandro1995.healthypet.viewmodel

import androidx.lifecycle.ViewModel
import com.leandro1995.healthypet.intent.InjectionIntent
import kotlinx.coroutines.flow.MutableStateFlow

class InjectionViewModel : ViewModel() {

    val injectionMutableStateFlow: MutableStateFlow<InjectionIntent> by lazy {
        MutableStateFlow(InjectionIntent.View)
    }
}