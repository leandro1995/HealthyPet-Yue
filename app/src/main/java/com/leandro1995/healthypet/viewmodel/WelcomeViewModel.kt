package com.leandro1995.healthypet.viewmodel

import androidx.lifecycle.ViewModel
import com.leandro1995.healthypet.activity.ListPetActivity
import com.leandro1995.healthypet.intent.WelcomeIntent
import com.leandro1995.healthypet.model.design.PositionViewPager
import com.leandro1995.healthypet.util.ArrayListUtil
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

    val welcomePageArrayList = ArrayListUtil.welcomePageArrayList()

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

        PositionViewPager(position = position).let { positionViewPager ->

            if (positionViewPager.pagePosition(
                    maxPosition = ArrayListUtil.arrayListSize(arrayList = welcomePageArrayList)
                )
            ) {

                onClick.invoke(LIST_PET_ACTIVITY)
            } else {

                welComeMutableStateFlow.value =
                    WelcomeIntent.PositionPage(positionViewPager = positionViewPager)
            }
        }
    }

    private fun listPetActivity() {

        welComeMutableStateFlow.value = WelcomeIntent.ListPetActivity(activity = ListPetActivity())
    }
}