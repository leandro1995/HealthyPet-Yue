package com.leandro1995.healthypet.viewmodel

import androidx.lifecycle.ViewModel
import com.leandro1995.healthypet.intent.RegisterPetIntent
import kotlinx.coroutines.flow.MutableStateFlow

class RegisterPetViewModel : ViewModel() {

    val registerPetMutableStateFlow: MutableStateFlow<RegisterPetIntent> by lazy {
        MutableStateFlow(RegisterPetIntent.View)
    }
}