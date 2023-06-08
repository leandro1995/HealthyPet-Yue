package com.leandro1995.healthypet.intent

import android.app.Activity
import android.content.Intent
import com.leandro1995.healthypet.model.design.Url
import com.leandro1995.healthypet.model.entity.Pet

sealed class ProfileIntent {

    object View : ProfileIntent()

    data class PlayStoreOpen constructor(val intent: Intent) : ProfileIntent()

    data class ShareApp constructor(val url: Url) : ProfileIntent()

    data class EditProfilePetActivity constructor(val activity: Activity, val pet: Pet) :
        ProfileIntent()

    data class IdPet constructor(val pet: Pet) : ProfileIntent()

    data class ListPetActivity constructor(
        val activity: Activity,
        val petArrayList: ArrayList<Pet>
    ) : ProfileIntent()
}
