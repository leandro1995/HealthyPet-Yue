package com.leandro1995.healthypet.intent.config

import com.leandro1995.healthypet.config.callback.intent.RegisterInjectionIntentCallBack
import com.leandro1995.healthypet.intent.RegisterInjectionIntent

object RegisterInjectionIntentConfig {

    private lateinit var registerInjectionIntentCallBack: RegisterInjectionIntentCallBack

    fun instance(registerInjectionIntentCallBack: RegisterInjectionIntentCallBack) {

        this.registerInjectionIntentCallBack = registerInjectionIntentCallBack
    }

    fun registerInjectionSelect(registerInjectionIntent: RegisterInjectionIntent) {

        when (registerInjectionIntent) {

            RegisterInjectionIntent.View -> {

                registerInjectionIntentCallBack.view()
            }

            is RegisterInjectionIntent.MessageErrorDialog -> {

                registerInjectionIntentCallBack.messageErrorDialog(message = registerInjectionIntent.message)
            }

            is RegisterInjectionIntent.DatePickerDialog -> {

                registerInjectionIntentCallBack.datePickerDialog(calendar = registerInjectionIntent.calendar)
            }
        }
    }
}