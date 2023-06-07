package com.leandro1995.healthypet.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.leandro1995.healthypet.activity.RegisterInjectionActivity
import com.leandro1995.healthypet.intent.InjectionIntent
import com.leandro1995.healthypet.model.entity.Pet
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class InjectionViewModel : ViewModel() {

    companion object {

        const val REGISTER_INJECTION = 0
        const val INJECTION_LIST = 1
    }

    val injectionMutableStateFlow: MutableStateFlow<InjectionIntent> by lazy {
        MutableStateFlow(InjectionIntent.View)
    }

    val pet = Pet()

    val onClick = fun(action: Int) {

        when (action) {

            REGISTER_INJECTION -> {

                registerInjection()
            }

            INJECTION_LIST -> {

                injectionList()
            }
        }
    }

    private fun registerInjection() {

        injectionMutableStateFlow.value =
            InjectionIntent.RegisterInjection(activity = RegisterInjectionActivity())
    }

    private fun injectionList() {

        viewModelScope.launch {

            injectionMutableStateFlow.value =
                InjectionIntent.InjectionArrayList(injectionArrayList = pet.injectionArrayListDatabase())
        }
    }
}