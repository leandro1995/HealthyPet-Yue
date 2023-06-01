package com.leandro1995.healthypet

import com.leandro1995.healthypet.intent.EditProfilePetIntent
import com.leandro1995.healthypet.model.entity.Pet
import com.leandro1995.healthypet.viewmodel.EditProfilePetViewModel
import org.junit.Assert.assertEquals
import org.junit.Test

class EditProfilePetUnitTest {

    private val editProfilePetViewModel = EditProfilePetViewModel()

    @Test
    fun checkPetPhoto() {

        editProfilePetViewModel.apply {

            pet = Pet()

            onClick.invoke(EditProfilePetViewModel.VERIFY_PET)

            assertEquals(
                R.string.photo_url_message,
                messageError(editProfilePetIntent = editProfilePetMutableStateFlow.value)
            )
        }
    }

    @Test
    fun checkPetName() {

        editProfilePetViewModel.apply {

            pet = Pet()

            pet.let { pet ->

                pet.photoUrl = "urlPhoto"
            }

            onClick.invoke(EditProfilePetViewModel.VERIFY_PET)

            assertEquals(
                R.string.name_message,
                messageError(editProfilePetIntent = editProfilePetMutableStateFlow.value)
            )
        }
    }

    @Test
    fun checkPetDate() {

        editProfilePetViewModel.apply {

            pet = Pet()

            pet.let { pet ->

                pet.photoUrl = "urlPhoto"
                pet.name = "name pet"
            }

            onClick.invoke(EditProfilePetViewModel.VERIFY_PET)

            assertEquals(
                R.string.date_message,
                messageError(editProfilePetIntent = editProfilePetMutableStateFlow.value)
            )
        }
    }

    private fun messageError(editProfilePetIntent: EditProfilePetIntent) =
        (editProfilePetIntent as EditProfilePetIntent.MessageErrorDialog).message.messageError()
}