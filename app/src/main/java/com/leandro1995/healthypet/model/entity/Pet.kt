package com.leandro1995.healthypet.model.entity

import com.leandro1995.healthypet.config.Setting
import com.leandro1995.healthypet.database.config.DataBaseConfig
import com.leandro1995.healthypet.database.model.Pet
import java.io.Serializable

class Pet constructor(
    var photoUrl: String = "",
    var name: String = "",
    var spice: Spice = Spice(),
    var isSex: Boolean = false,
    var date: Long = -1L
) : Serializable {

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

    suspend fun registerPetDatabase() {

        DataBaseConfig.petDao().register(
            pet = Pet(
                photoUrl = photoUrl, name = name, spiceId = spice.id, isSex = isSex, date = date
            )
        )
    }

    private fun isPhotoUrlEmpty() = photoUrl.isEmpty()

    private fun isNameEmpty() = name.isEmpty()

    private fun isDateEmpty() = date == -1L
}