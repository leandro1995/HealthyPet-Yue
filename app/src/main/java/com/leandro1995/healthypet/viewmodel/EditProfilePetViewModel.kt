package com.leandro1995.healthypet.viewmodel

import androidx.lifecycle.ViewModel
import com.leandro1995.healthypet.intent.EditProfilePetIntent
import com.leandro1995.healthypet.model.entity.Pet
import kotlinx.coroutines.flow.MutableStateFlow

class EditProfilePetViewModel : ViewModel() {

    val editProfilePetMutableStateFlow: MutableStateFlow<EditProfilePetIntent> by lazy {
        MutableStateFlow(EditProfilePetIntent.View)
    }

    lateinit var pet: Pet
}