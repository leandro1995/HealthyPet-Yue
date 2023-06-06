package com.leandro1995.healthypet.intent.config

import com.leandro1995.healthypet.config.callback.intent.InjectionIntentCallBack
import com.leandro1995.healthypet.intent.InjectionIntent

object InjectionIntentConfig {

    private lateinit var injectionIntentCallBack: InjectionIntentCallBack

    fun instance(injectionIntentCallBack: InjectionIntentCallBack) {

        this.injectionIntentCallBack = injectionIntentCallBack
    }

    fun injectionSelect(injectionIntent: InjectionIntent) {

        when (injectionIntent) {

            InjectionIntent.View -> {

                injectionIntentCallBack.view()
            }

            is InjectionIntent.RegisterInjection -> {

                injectionIntentCallBack.registerInjection(activity = injectionIntent.activity)
            }

            is InjectionIntent.InjectionArrayList -> {

                injectionIntentCallBack.injectionArrayList(injectionArrayList = injectionIntent.injectionArrayList)
            }
        }
    }
}