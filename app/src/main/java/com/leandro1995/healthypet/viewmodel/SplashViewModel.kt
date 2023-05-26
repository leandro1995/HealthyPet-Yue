package com.leandro1995.healthypet.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.leandro1995.healthypet.activity.ListPetActivity
import com.leandro1995.healthypet.activity.WelcomeActivity
import com.leandro1995.healthypet.datastore.config.HealthyPetDataStoreConfig
import com.leandro1995.healthypet.intent.SplashIntent
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class SplashViewModel : ViewModel() {

    companion object {

        const val ACTIVITY_SELECT = 0
    }

    val splashMutableStateFlow: MutableStateFlow<SplashIntent> by lazy {
        MutableStateFlow(SplashIntent.View)
    }

    val onClick = fun(action: Int) {

        when (action) {

            ACTIVITY_SELECT -> {

                activitySelect()
            }
        }
    }

    private fun activitySelect() {

        if (HealthyPetDataStoreConfig.isWelcome()) {

            viewModelScope.launch {

                splashMutableStateFlow.value = SplashIntent.ListPetActivity(
                    activity = ListPetActivity(),
                    petArrayList = arrayListOf()
                )
            }
        } else {

            splashMutableStateFlow.value =
                SplashIntent.WelcomeActivity(activity = WelcomeActivity())
        }
    }
}