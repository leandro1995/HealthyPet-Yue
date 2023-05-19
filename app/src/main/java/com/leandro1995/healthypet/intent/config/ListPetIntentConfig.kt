package com.leandro1995.healthypet.intent.config

import com.leandro1995.healthypet.config.callback.intent.ListPetIntentCallBack
import com.leandro1995.healthypet.intent.ListPetIntent

object ListPetIntentConfig {

    private lateinit var listPetIntentCallBack: ListPetIntentCallBack

    fun instance(listPetIntentCallBack: ListPetIntentCallBack) {

        this.listPetIntentCallBack = listPetIntentCallBack
    }

    fun listPetSelect(listPetIntent: ListPetIntent) {

        when (listPetIntent) {

            ListPetIntent.View -> {

                listPetIntentCallBack.view()
            }
        }
    }
}