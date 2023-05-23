package com.leandro1995.healthypet.viewmodel

import androidx.lifecycle.ViewModel
import com.leandro1995.healthypet.intent.RegisterPetIntent
import com.leandro1995.healthypet.model.design.Calendar
import com.leandro1995.healthypet.model.design.Message
import com.leandro1995.healthypet.model.entity.Pet
import kotlinx.coroutines.flow.MutableStateFlow

class RegisterPetViewModel : ViewModel() {

    companion object {

        const val DATE_PICKER_DIALOG = 0
        const val VERIFY_PET = 1
    }

    val registerPetMutableStateFlow: MutableStateFlow<RegisterPetIntent> by lazy {
        MutableStateFlow(RegisterPetIntent.View)
    }

    val onClick = fun(action: Int) {

        when (action) {

            DATE_PICKER_DIALOG -> {

                datePickerDialog()
            }

            VERIFY_PET -> {

                verifyPet()
            }
        }
    }

    val pet = Pet()

    private fun datePickerDialog() {

        registerPetMutableStateFlow.value = RegisterPetIntent.DatePickerDialog(
            calendar = Calendar(
                date = pet.date, isToday = true, isNow = true
            )
        )
    }

    private fun verifyPet() {

        pet.checkPet().let { index ->

            if (index != 0) {

                registerPetMutableStateFlow.value =
                    RegisterPetIntent.MessageErrorDialog(message = Message(indexMessage = index))
            } else {

            }
        }
    }
}