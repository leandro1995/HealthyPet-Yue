package com.leandro1995.healthypet.viewmodel

import androidx.lifecycle.ViewModel
import com.leandro1995.healthypet.intent.RegisterInjectionIntent
import com.leandro1995.healthypet.model.design.Message
import com.leandro1995.healthypet.model.entity.Injection
import kotlinx.coroutines.flow.MutableStateFlow

class RegisterInjectionViewModel : ViewModel() {

    companion object {

        const val VERIFY_INJECTION = 0
    }

    val registerInjectionMutableSateFlow: MutableStateFlow<RegisterInjectionIntent> by lazy {
        MutableStateFlow(RegisterInjectionIntent.View)
    }

    val injection = Injection()

    val onClick = fun(action: Int) {

        when (action) {

            VERIFY_INJECTION -> {

                verifyInjection()
            }
        }
    }

    private fun verifyInjection() {

        injection.checkInjection().let { index ->

            if (index != 0) {

                registerInjectionMutableSateFlow.value =
                    RegisterInjectionIntent.MessageErrorDialog(message = Message(indexMessage = index))
            } else {

            }
        }
    }
}