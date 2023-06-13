package com.leandro1995.healthypet.viewmodel

import androidx.lifecycle.ViewModel
import com.leandro1995.healthypet.intent.DetailInjectionIntent
import kotlinx.coroutines.flow.MutableStateFlow

class DetailInjectionViewModel : ViewModel() {

    val detailInjectionMutableStateFlow: MutableStateFlow<DetailInjectionIntent> by lazy {
        MutableStateFlow(DetailInjectionIntent.View)
    }
}