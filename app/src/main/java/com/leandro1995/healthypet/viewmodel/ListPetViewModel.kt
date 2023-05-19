package com.leandro1995.healthypet.viewmodel

import androidx.lifecycle.ViewModel
import com.leandro1995.healthypet.activity.RegisterPetActivity
import com.leandro1995.healthypet.intent.ListPetIntent
import kotlinx.coroutines.flow.MutableStateFlow

class ListPetViewModel : ViewModel() {

    companion object {

        const val LIST_PET_ACTIVITY = 0
    }

    val listPetMutableStateFlow: MutableStateFlow<ListPetIntent> by lazy {
        MutableStateFlow(ListPetIntent.View)
    }

    val onClick = fun(action: Int) {

        when (action) {

            LIST_PET_ACTIVITY -> {

                listPetActivity()
            }
        }
    }

    private fun listPetActivity() {

        listPetMutableStateFlow.value =
            ListPetIntent.RegisterPetActivity(activity = RegisterPetActivity())
    }
}