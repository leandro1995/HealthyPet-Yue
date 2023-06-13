package com.leandro1995.healthypet.viewmodel

import androidx.lifecycle.ViewModel
import com.leandro1995.healthypet.intent.DetailInjectionIntent
import com.leandro1995.healthypet.model.entity.Injection
import kotlinx.coroutines.flow.MutableStateFlow

class DetailInjectionViewModel : ViewModel() {

    companion object {

        const val DELETE_INJECTION = 0
    }

    val detailInjectionMutableStateFlow: MutableStateFlow<DetailInjectionIntent> by lazy {
        MutableStateFlow(DetailInjectionIntent.View)
    }

    lateinit var injection: Injection

    val onClick = fun(action: Int) {

        when (action) {

            DELETE_INJECTION -> {

                deleteInjection()
            }
        }
    }

    private fun deleteInjection() {

        detailInjectionMutableStateFlow.value =
            DetailInjectionIntent.InjectionStatus(isStatus = true, injection = injection)
    }
}