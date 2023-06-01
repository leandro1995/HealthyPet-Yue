package com.leandro1995.healthypet.viewmodel

import androidx.lifecycle.ViewModel
import com.leandro1995.healthypet.config.Setting
import com.leandro1995.healthypet.intent.ProfileIntent
import com.leandro1995.healthypet.model.design.Url
import com.leandro1995.healthypet.model.entity.Pet
import kotlinx.coroutines.flow.MutableStateFlow

class ProfileViewModel : ViewModel() {

    companion object {

        const val PLAY_STORE = 0
    }

    val profileMutableStateFlow: MutableStateFlow<ProfileIntent> by lazy {
        MutableStateFlow(ProfileIntent.View)
    }

    lateinit var pet: Pet

    val onClick = fun(action: Int) {

        when (action) {

            PLAY_STORE -> {

                playStore()
            }
        }
    }

    private fun playStore() {

        profileMutableStateFlow.value =
            ProfileIntent.PlayStoreOpen(intent = Url(url = Setting.PLAY_STORE_URL).viewPage())
    }
}