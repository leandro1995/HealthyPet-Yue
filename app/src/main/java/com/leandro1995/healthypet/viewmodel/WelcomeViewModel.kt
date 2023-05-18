package com.leandro1995.healthypet.viewmodel

import androidx.lifecycle.ViewModel
import com.leandro1995.healthypet.activity.ListPetActivity
import com.leandro1995.healthypet.intent.WelcomeIntent
import com.leandro1995.healthypet.model.design.PositionViewPager
import kotlinx.coroutines.flow.MutableStateFlow

class WelcomeViewModel : ViewModel() {

    companion object {

        const val POSITION = 0
        const val LIST_PET_ACTIVITY = 1
    }

    val welComeMutableStateFlow: MutableStateFlow<WelcomeIntent> by lazy {
        MutableStateFlow(WelcomeIntent.View)
    }

    var position = 0

    val onClick = fun(action: Int) {

        when (action) {

            POSITION -> {

                position()
            }

            LIST_PET_ACTIVITY -> {

                listPetActivity()
            }
        }
    }

    private fun position() {

        welComeMutableStateFlow.value =
            WelcomeIntent.PositionPage(positionViewPager = PositionViewPager(position = position))
    }

    private fun listPetActivity() {

        welComeMutableStateFlow.value = WelcomeIntent.ListPetActivity(activity = ListPetActivity())
    }
}