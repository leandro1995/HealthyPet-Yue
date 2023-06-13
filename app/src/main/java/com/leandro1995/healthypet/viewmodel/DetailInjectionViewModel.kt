package com.leandro1995.healthypet.viewmodel

import androidx.lifecycle.ViewModel
import com.leandro1995.healthypet.intent.DetailInjectionIntent
import com.leandro1995.healthypet.model.entity.Injection
import kotlinx.coroutines.flow.MutableStateFlow

class DetailInjectionViewModel : ViewModel() {

    val detailInjectionMutableStateFlow: MutableStateFlow<DetailInjectionIntent> by lazy {
        MutableStateFlow(DetailInjectionIntent.View)
    }

    lateinit var injection: Injection
}