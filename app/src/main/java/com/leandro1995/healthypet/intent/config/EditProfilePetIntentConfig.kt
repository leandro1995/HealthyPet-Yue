package com.leandro1995.healthypet.intent.config

import com.leandro1995.healthypet.config.callback.intent.EditProfilePetIntentCallBack
import com.leandro1995.healthypet.intent.EditProfilePetIntent

object EditProfilePetIntentConfig {

    private lateinit var editProfilePetIntentCallBack: EditProfilePetIntentCallBack

    fun instance(editProfilePetIntentCallBack: EditProfilePetIntentCallBack) {

        this.editProfilePetIntentCallBack = editProfilePetIntentCallBack
    }

    fun editProfilePetSelect(editProfilePetIntent: EditProfilePetIntent) {

        when (editProfilePetIntent) {

            EditProfilePetIntent.View -> {

                editProfilePetIntentCallBack.view()
            }

            is EditProfilePetIntent.DatePickerDialog -> {

                editProfilePetIntentCallBack.datePickerDialog(calendar = editProfilePetIntent.calendar)
            }

            is EditProfilePetIntent.MessageErrorDialog -> {

                editProfilePetIntentCallBack.messageErrorDialog(message = editProfilePetIntent.message)
            }
        }
    }
}