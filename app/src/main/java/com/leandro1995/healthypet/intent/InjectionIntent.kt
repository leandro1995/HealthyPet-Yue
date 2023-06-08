package com.leandro1995.healthypet.intent

import android.app.Activity
import com.leandro1995.healthypet.model.entity.Injection
import com.leandro1995.healthypet.model.entity.Pet

sealed class InjectionIntent {

    object View : InjectionIntent()

    data class RegisterInjection constructor(val activity: Activity, val pet: Pet) :
        InjectionIntent()

    data class InjectionArrayList constructor(val injectionArrayList: ArrayList<Injection>) :
        InjectionIntent()
}
