package com.leandro1995.healthypet.config.callback.intent

import android.app.Activity

interface InjectionIntentCallBack {

    fun view()

    fun registerInjection(activity: Activity)
}