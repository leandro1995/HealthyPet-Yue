package com.leandro1995.healthypet.viewmodel

import androidx.lifecycle.ViewModel
import com.leandro1995.healthypet.intent.ProfileIntent
import kotlinx.coroutines.flow.MutableStateFlow

class ProfileViewModel : ViewModel() {

    val profileMutableStateFlow: MutableStateFlow<ProfileIntent> by lazy {
        MutableStateFlow(ProfileIntent.View)
    }
}