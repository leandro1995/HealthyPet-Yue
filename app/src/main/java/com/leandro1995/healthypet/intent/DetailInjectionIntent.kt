package com.leandro1995.healthypet.intent

import com.leandro1995.healthypet.model.design.Calendar
import com.leandro1995.healthypet.model.entity.Injection

sealed class DetailInjectionIntent {

    object View : DetailInjectionIntent()

    data class InjectionStatus constructor(val isStatus: Boolean, val injection: Injection) :
        DetailInjectionIntent()

    data class DatePickerDialog constructor(val calendar: Calendar) : DetailInjectionIntent()
}