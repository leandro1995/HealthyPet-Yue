package com.leandro1995.healthypet.intent.config

import com.leandro1995.healthypet.config.callback.intent.WelcomeIntentCallBack
import com.leandro1995.healthypet.intent.WelcomeIntent

object WelcomeIntentConfig {

    private lateinit var welcomeIntentCallBack: WelcomeIntentCallBack

    fun instance(welcomeIntentCallBack: WelcomeIntentCallBack) {

        this.welcomeIntentCallBack = welcomeIntentCallBack
    }

    fun welcomeSelect(welcomeIntent: WelcomeIntent) {

        when (welcomeIntent) {

            WelcomeIntent.View -> {

                welcomeIntentCallBack.view()
            }

            is WelcomeIntent.PositionPage -> {

                welcomeIntentCallBack.positionPage(positionViewPager = welcomeIntent.positionViewPager)
            }

            is WelcomeIntent.ListPetActivity -> {

                welcomeIntentCallBack.listPetActivity(activity = welcomeIntent.activity)
            }
        }
    }
}