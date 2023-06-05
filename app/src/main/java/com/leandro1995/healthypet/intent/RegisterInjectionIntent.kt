package com.leandro1995.healthypet.intent

import com.leandro1995.healthypet.model.design.Calendar
import com.leandro1995.healthypet.model.design.Message

sealed class RegisterInjectionIntent {

    object View : RegisterInjectionIntent()

    data class MessageErrorDialog constructor(val message: Message) : RegisterInjectionIntent()

    data class DatePickerDialog constructor(val calendar: Calendar) : RegisterInjectionIntent()
}