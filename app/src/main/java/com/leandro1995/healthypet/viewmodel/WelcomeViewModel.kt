package com.leandro1995.healthypet.viewmodel

import androidx.lifecycle.ViewModel
import com.leandro1995.healthypet.intent.WelcomeIntent
import com.leandro1995.healthypet.model.design.PositionViewPager
import kotlinx.coroutines.flow.MutableStateFlow

class WelcomeViewModel : ViewModel() {

    companion object {

        const val POSITION = 0
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
        }
    }

    private fun position() {

        welComeMutableStateFlow.value =
            WelcomeIntent.PositionPage(positionViewPager = PositionViewPager(position = position))
    }
}