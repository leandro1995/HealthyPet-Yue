package com.leandro1995.healthypet.config.callback.intent

import android.app.Activity
import com.leandro1995.healthypet.model.entity.Injection

interface InjectionIntentCallBack {

    fun view()

    fun registerInjection(activity: Activity)

    fun injectionArrayList(injectionArrayList: ArrayList<Injection>)
}