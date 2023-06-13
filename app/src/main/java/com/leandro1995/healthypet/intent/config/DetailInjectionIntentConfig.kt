package com.leandro1995.healthypet.intent.config

import com.leandro1995.healthypet.config.callback.intent.DetailInjectionIntentCallBack
import com.leandro1995.healthypet.intent.DetailInjectionIntent

object DetailInjectionIntentConfig {

    private lateinit var detailInjectionIntentCallBack: DetailInjectionIntentCallBack

    fun instance(detailInjectionIntentCallBack: DetailInjectionIntentCallBack) {

        this.detailInjectionIntentCallBack = detailInjectionIntentCallBack
    }

    fun detailInjectionSelect(detailInjectionIntent: DetailInjectionIntent) {

        when (detailInjectionIntent) {

            DetailInjectionIntent.View -> {

                detailInjectionIntentCallBack.view()
            }
        }
    }
}