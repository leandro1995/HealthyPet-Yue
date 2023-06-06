package com.leandro1995.healthypet.intent

import android.app.Activity
import com.leandro1995.healthypet.model.entity.Injection

sealed class InjectionIntent {

    object View : InjectionIntent()

    data class RegisterInjection constructor(val activity: Activity) : InjectionIntent()

    data class InjectionArrayList constructor(val injectionArrayList: ArrayList<Injection>) :
        InjectionIntent()
}
