package com.leandro1995.healthypet.model.entity

import com.leandro1995.healthypet.config.Setting

class Pet constructor(
    var photoUrl: String = "",
    var name: String = "",
    var spice: Spice = Spice(),
    var isSex: Boolean = false,
    var date: Long = -1L
) {

    fun checkPet() = when {

        isPhotoUrlEmpty() -> {

            Setting.PHOTO_URL_MESSAGE
        }

        isNameEmpty() -> {

            Setting.NAME_MESSAGE
        }

        isDateEmpty() -> {

            Setting.DATE_MESSAGE
        }

        else -> {

            Setting.COMPLETE
        }
    }

    private fun isPhotoUrlEmpty() = photoUrl.isEmpty()

    private fun isNameEmpty() = name.isEmpty()

    private fun isDateEmpty() = date == 1L
}