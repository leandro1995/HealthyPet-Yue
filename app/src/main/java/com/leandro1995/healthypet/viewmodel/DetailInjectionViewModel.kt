package com.leandro1995.healthypet.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.leandro1995.healthypet.intent.DetailInjectionIntent
import com.leandro1995.healthypet.model.entity.Injection
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class DetailInjectionViewModel : ViewModel() {

    companion object {

        const val DELETE_INJECTION = 0
        const val UPDATE_INJECTION = 1
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

            UPDATE_INJECTION -> {

                updateInjection()
            }
        }
    }

    private fun deleteInjection() {

        viewModelScope.launch {

            injection.deleteInjectionDatabase()

            detailInjectionMutableStateFlow.value =
                DetailInjectionIntent.InjectionStatus(isStatus = true, injection = injection)
        }
    }

    private fun updateInjection() {

        detailInjectionMutableStateFlow.value =
            DetailInjectionIntent.InjectionStatus(isStatus = false, injection = injection)
    }
}