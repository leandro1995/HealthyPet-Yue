package com.leandro1995.healthypet.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.leandro1995.healthypet.activity.EditProfilePetActivity
import com.leandro1995.healthypet.config.Setting
import com.leandro1995.healthypet.intent.ProfileIntent
import com.leandro1995.healthypet.model.design.Url
import com.leandro1995.healthypet.model.entity.Pet
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class ProfileViewModel : ViewModel() {

    companion object {

        const val SHARE_APP = 0
        const val PLAY_STORE = 1
        const val EDIT_PROFILE_PET_ACTIVITY = 2
        const val ID_PET = 3
    }

    val profileMutableStateFlow: MutableStateFlow<ProfileIntent> by lazy {
        MutableStateFlow(ProfileIntent.View)
    }

    var pet = Pet()

    val onClick = fun(action: Int) {

        when (action) {

            SHARE_APP -> {

                shareApp()
            }

            PLAY_STORE -> {

                playStore()
            }

            EDIT_PROFILE_PET_ACTIVITY -> {

                editProfilePetActivity()
            }

            ID_PET -> {

                idPet()
            }
        }
    }

    private fun shareApp() {

        profileMutableStateFlow.value =
            ProfileIntent.ShareApp(url = Url(url = Setting.PLAY_STORE_URL))
    }

    private fun playStore() {

        profileMutableStateFlow.value =
            ProfileIntent.PlayStoreOpen(intent = Url(url = Setting.PLAY_STORE_URL).viewPage())
    }

    private fun editProfilePetActivity() {

        profileMutableStateFlow.value =
            ProfileIntent.EditProfilePetActivity(activity = EditProfilePetActivity(), pet = pet)
    }

    private fun idPet() {

        viewModelScope.launch {

            pet = pet.idPetDatabase()

            profileMutableStateFlow.value = ProfileIntent.IdPet(pet = pet)
        }
    }
}