package com.leandro1995.healthypet.viewmodel

import androidx.lifecycle.ViewModel
import com.leandro1995.healthypet.intent.ListPetIntent
import kotlinx.coroutines.flow.MutableStateFlow

class ListPetViewModel : ViewModel() {

    val listPetMutableStateFlow: MutableStateFlow<ListPetIntent> by lazy {
        MutableStateFlow(ListPetIntent.View)
    }
}