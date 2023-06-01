package com.leandro1995.healthypet.intent

import com.leandro1995.healthypet.model.design.Calendar
import com.leandro1995.healthypet.model.design.Message

sealed class EditProfilePetIntent {

    object View : EditProfilePetIntent()

    data class DatePickerDialog constructor(val calendar: Calendar) : EditProfilePetIntent()

    data class MessageErrorDialog constructor(val message: Message) : EditProfilePetIntent()
}
