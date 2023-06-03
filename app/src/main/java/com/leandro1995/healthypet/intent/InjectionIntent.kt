package com.leandro1995.healthypet.intent

import android.app.Activity

sealed class InjectionIntent {

    object View : InjectionIntent()

    data class RegisterInjection(val activity: Activity) : InjectionIntent()
}
