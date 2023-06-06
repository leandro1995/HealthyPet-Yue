package com.leandro1995.healthypet.model.entity

import com.leandro1995.healthypet.config.Setting
import com.leandro1995.healthypet.database.config.DataBaseConfig
import com.leandro1995.healthypet.database.model.Injection
import com.leandro1995.healthypet.extension.dateFormat
import com.leandro1995.healthypet.extension.fileUrl
import java.io.Serializable
import java.util.Date

class Injection constructor(
    private var id: Int = -1,
    var photoUrl: String = "",
    var currentDate: Long = Date().time,
    var nextAppointment: Long = -1L,
    var typeInjection: TypeInjection = TypeInjection(),
    var comment: String = ""
) : Serializable {

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

    fun photoFile() = photoUrl.fileUrl()

    fun dateNextAppointment(format: String) =
        nextAppointment.dateFormat(format = format, isCalendar = false)

    suspend fun registerInjectionDatabase() {

        id = DataBaseConfig.injectionDao().register(
            injection = Injection(
                photoUrl = photoUrl,
                currentDate = currentDate,
                nextAppointment = nextAppointment,
                idTypeInjection = typeInjection.id,
                comment = comment
            )
        ).toInt()
    }

    private fun isPhotoUrl() = photoUrl.isEmpty()

    private fun isNextAppointment() = nextAppointment == -1L
}