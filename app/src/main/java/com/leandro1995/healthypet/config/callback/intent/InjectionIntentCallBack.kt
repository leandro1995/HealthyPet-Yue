package com.leandro1995.healthypet.config.callback.intent

import android.app.Activity
import com.leandro1995.healthypet.model.entity.Injection
import com.leandro1995.healthypet.model.entity.Pet

interface InjectionIntentCallBack {

    fun view()

    fun registerInjection(activity: Activity, pet: Pet)

    fun injectionArrayList(injectionArrayList: ArrayList<Injection>)
}