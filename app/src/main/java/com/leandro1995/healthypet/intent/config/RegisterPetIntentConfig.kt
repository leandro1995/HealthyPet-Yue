package com.leandro1995.healthypet.intent.config

import com.leandro1995.healthypet.config.callback.intent.RegisterPetIntentCallBack
import com.leandro1995.healthypet.intent.RegisterPetIntent

object RegisterPetIntentConfig {

    private lateinit var registerPetIntentCallBack: RegisterPetIntentCallBack

    fun instance(registerPetIntentCallBack: RegisterPetIntentCallBack) {

        this.registerPetIntentCallBack = registerPetIntentCallBack
    }

    fun registerPetSelect(registerPetIntent: RegisterPetIntent) {

        when (registerPetIntent) {

            RegisterPetIntent.View -> {

                registerPetIntentCallBack.view()
            }

            is RegisterPetIntent.DatePickerDialog -> {

                registerPetIntentCallBack.datePickerDialog(calendar = registerPetIntent.calendar)
            }

            is RegisterPetIntent.MessageErrorDialog -> {

                registerPetIntentCallBack.messageErrorDialog(message = registerPetIntent.message)
            }
        }
    }
}