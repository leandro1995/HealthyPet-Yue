package com.leandro1995.healthypet.intent

import com.leandro1995.healthypet.model.design.Calendar

sealed class RegisterPetIntent {

    object View : RegisterPetIntent()

    data class DatePickerDialog constructor(val calendar: Calendar) : RegisterPetIntent()
}
