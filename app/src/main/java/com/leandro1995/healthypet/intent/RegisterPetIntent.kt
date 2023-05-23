package com.leandro1995.healthypet.intent

import com.leandro1995.healthypet.model.design.Calendar
import com.leandro1995.healthypet.model.design.Message

sealed class RegisterPetIntent {

    object View : RegisterPetIntent()

    data class DatePickerDialog constructor(val calendar: Calendar) : RegisterPetIntent()

    data class MessageErrorDialog constructor(val message: Message) : RegisterPetIntent()
}
