package com.leandro1995.healthypet.viewmodel

import androidx.lifecycle.ViewModel
import com.leandro1995.healthypet.intent.RegisterPetIntent
import com.leandro1995.healthypet.model.design.Calendar
import com.leandro1995.healthypet.model.entity.Pet
import kotlinx.coroutines.flow.MutableStateFlow

class RegisterPetViewModel : ViewModel() {

    companion object {

        const val DATE_PICKER_DIALOG = 0
    }

    val registerPetMutableStateFlow: MutableStateFlow<RegisterPetIntent> by lazy {
        MutableStateFlow(RegisterPetIntent.View)
    }

    val onClick = fun(action: Int) {

        when (action) {

            DATE_PICKER_DIALOG -> {

                datePickerDialog()
            }
        }
    }

    val pet = Pet()

    private fun datePickerDialog() {

        registerPetMutableStateFlow.value =
            RegisterPetIntent.DatePickerDialog(calendar = Calendar(isToday = true, isNow = true))
    }
}