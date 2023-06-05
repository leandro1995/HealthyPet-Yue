package com.leandro1995.healthypet.model.entity

import com.leandro1995.healthypet.config.Setting
import java.util.Date

class Injection constructor(
    private val id: Int = -1,
    var photoUrl: String = "",
    var currentDate: Long = Date().time,
    var nextAppointment: Long = -1L,
    var typeInjection: TypeInjection = TypeInjection(),
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