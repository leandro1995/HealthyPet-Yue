package com.leandro1995.healthypet.intent

import com.leandro1995.healthypet.model.design.Calendar

sealed class EditProfilePetIntent {

    object View : EditProfilePetIntent()

    data class DatePickerDialog constructor(val calendar: Calendar) : EditProfilePetIntent()
}
