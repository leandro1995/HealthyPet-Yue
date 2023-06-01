package com.leandro1995.healthypet.config.callback.intent

import android.app.Activity
import android.content.Intent
import com.leandro1995.healthypet.model.design.Url
import com.leandro1995.healthypet.model.entity.Pet

interface ProfileIntentCallBack {

    fun view()

    fun playStoreOpen(intent: Intent)

    fun shareApp(url: Url)

    fun editProfilePetActivity(activity: Activity, pet: Pet)

    fun idPet(pet: Pet)
}