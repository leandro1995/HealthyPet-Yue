package com.leandro1995.healthypet.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.leandro1995.healthypet.intent.EditProfilePetIntent
import com.leandro1995.healthypet.model.design.Calendar
import com.leandro1995.healthypet.model.design.Message
import com.leandro1995.healthypet.model.entity.Pet
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class EditProfilePetViewModel : ViewModel() {

    companion object {

        const val DATE_PICKER_DIALOG = 0
        const val VERIFY_PET = 1
        const val UPDATE_PET = 2
    }

    val editProfilePetMutableStateFlow: MutableStateFlow<EditProfilePetIntent> by lazy {
        MutableStateFlow(EditProfilePetIntent.View)
    }

    lateinit var pet: Pet

    val onClick = fun(action: Int) {

        when (action) {

            DATE_PICKER_DIALOG -> {

                datePickerDialog()
            }

            VERIFY_PET -> {

                verifyPet()
            }

            UPDATE_PET -> {

                updatePet()
            }
        }
    }

    private fun datePickerDialog() {

        editProfilePetMutableStateFlow.value = EditProfilePetIntent.DatePickerDialog(
            calendar = Calendar(
                date = pet.date, isNow = true, isToday = true
            )
        )
    }

    private fun verifyPet() {

        pet.checkPet().let { index ->

            if (index != 0) {

                editProfilePetMutableStateFlow.value =
                    EditProfilePetIntent.MessageErrorDialog(message = Message(indexMessage = index))
            } else {

                onClick.invoke(UPDATE_PET)
            }
        }
    }

    private fun updatePet() {

        viewModelScope.launch {

            pet.updatePetDatabase()
        }
    }
}