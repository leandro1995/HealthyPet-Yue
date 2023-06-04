package com.leandro1995.healthypet.model.entity

import com.leandro1995.healthypet.config.Setting

class Injection constructor(
    private val id: Int = -1,
    var photoUrl: String = "",
    private val currentDate: Long = -1L,
    var nextAppointment: Long = -1L,
    private val typeInjection: TypeInjection = TypeInjection(),
    private val comment: String = ""
) {

    fun checkInjection() = when {

        isPhotoUrl() -> {

            Setting.PHOTO_URL_INJECTION_MESSAGE
        }

        isNextAppointment() -> {

            Setting.NEXT_APPOINTMENT
        }

        typeInjection.isId() -> {

            Setting.INJECTION
        }

        else -> {

            Setting.COMPLETE
        }
    }

    private fun isPhotoUrl() = photoUrl.isEmpty()

    private fun isNextAppointment() = nextAppointment == -1L
}