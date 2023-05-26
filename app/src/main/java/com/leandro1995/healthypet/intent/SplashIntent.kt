package com.leandro1995.healthypet.intent

import android.app.Activity
import com.leandro1995.healthypet.model.entity.Pet

sealed class SplashIntent {

    object View : SplashIntent()

    data class WelcomeActivity constructor(val activity: Activity) : SplashIntent()

    data class ListPetActivity constructor(
        val activity: Activity,
        val petArrayList: ArrayList<Pet>
    ) : SplashIntent()
}