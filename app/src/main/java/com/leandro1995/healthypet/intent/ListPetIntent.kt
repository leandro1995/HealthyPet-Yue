package com.leandro1995.healthypet.intent

import android.app.Activity

sealed class ListPetIntent {

    object View : ListPetIntent()

    data class RegisterPetActivity constructor(val activity: Activity) : ListPetIntent()
}
