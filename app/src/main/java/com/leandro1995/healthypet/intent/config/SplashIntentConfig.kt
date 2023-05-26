package com.leandro1995.healthypet.intent.config

import com.leandro1995.healthypet.config.callback.intent.SplashIntentCallBack
import com.leandro1995.healthypet.intent.SplashIntent

object SplashIntentConfig {

    private lateinit var splashIntentCallBack: SplashIntentCallBack

    fun instance(splashIntentCallBack: SplashIntentCallBack) {

        this.splashIntentCallBack = splashIntentCallBack
    }

    fun splashSelect(splashIntent: SplashIntent) {

        when (splashIntent) {

            SplashIntent.View -> {

                splashIntentCallBack.view()
            }
        }
    }
}