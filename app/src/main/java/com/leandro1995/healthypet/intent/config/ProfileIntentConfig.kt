package com.leandro1995.healthypet.intent.config

import com.leandro1995.healthypet.config.callback.intent.ProfileIntentCallBack
import com.leandro1995.healthypet.intent.ProfileIntent

object ProfileIntentConfig {

    private lateinit var profileIntentCallBack: ProfileIntentCallBack

    fun instance(profileIntentCallBack: ProfileIntentCallBack) {

        this.profileIntentCallBack = profileIntentCallBack
    }

    fun profileSelect(profileIntent: ProfileIntent) {

        when (profileIntent) {

            ProfileIntent.View -> {

                profileIntentCallBack.view()
            }

            is ProfileIntent.PlayStoreOpen -> {

                profileIntentCallBack.playStoreOpen(intent = profileIntent.intent)
            }

            is ProfileIntent.ShareApp -> {

                profileIntentCallBack.shareApp(url = profileIntent.url)
            }
        }
    }
}