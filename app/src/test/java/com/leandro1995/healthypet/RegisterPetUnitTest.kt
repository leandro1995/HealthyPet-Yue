package com.leandro1995.healthypet

import com.leandro1995.healthypet.intent.RegisterPetIntent
import com.leandro1995.healthypet.viewmodel.RegisterPetViewModel
import org.junit.Assert.assertEquals
import org.junit.Test

class RegisterPetUnitTest {

    private val registerPetViewModel = RegisterPetViewModel()

    @Test
    fun checkPetPhoto() {

        registerPetViewModel.apply {

            onClick.invoke(RegisterPetViewModel.VERIFY_PET)

            assertEquals(
                R.string.photo_url_message,
                messageError(registerPetIntent = registerPetMutableStateFlow.value)
            )
        }
    }

    @Test
    fun checkPetName() {

        registerPetViewModel.apply {

            pet.let { pet ->

                pet.photoUrl = "urlPhoto"
            }

            onClick.invoke(RegisterPetViewModel.VERIFY_PET)

            assertEquals(
                R.string.name_message,
                messageError(registerPetIntent = registerPetMutableStateFlow.value)
            )
        }
    }

    @Test
    fun checkPetDate() {

        registerPetViewModel.apply {

            pet.let { pet ->

                pet.photoUrl = "urlPhoto"
                pet.name = "name pet"
            }

            onClick.invoke(RegisterPetViewModel.VERIFY_PET)

            assertEquals(
                R.string.date_message,
                messageError(registerPetIntent = registerPetMutableStateFlow.value)
            )
        }
    }

    private fun messageError(registerPetIntent: RegisterPetIntent) =
        (registerPetIntent as RegisterPetIntent.MessageErrorDialog).message.messageError()
}