package com.leandro1995.healthypet.viewmodel

import androidx.lifecycle.ViewModel
import com.leandro1995.healthypet.activity.RegisterInjectionActivity
import com.leandro1995.healthypet.intent.InjectionIntent
import kotlinx.coroutines.flow.MutableStateFlow

class InjectionViewModel : ViewModel() {

    companion object {

        const val REGISTER_INJECTION = 0
    }

    val injectionMutableStateFlow: MutableStateFlow<InjectionIntent> by lazy {
        MutableStateFlow(InjectionIntent.View)
    }

    val onClick = fun(action: Int) {

        when (action) {

            REGISTER_INJECTION -> {

                registerInjection()
            }
        }
    }

    private fun registerInjection() {

        injectionMutableStateFlow.value =
            InjectionIntent.RegisterInjection(activity = RegisterInjectionActivity())
    }
}