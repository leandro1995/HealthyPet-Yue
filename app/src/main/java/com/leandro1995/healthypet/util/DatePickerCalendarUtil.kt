package com.leandro1995.healthypet.util

import com.google.android.material.datepicker.CalendarConstraints
import com.google.android.material.datepicker.DateValidatorPointBackward

class DatePickerCalendarUtil() {

    companion object {

        fun setValidatorNow() = CalendarConstraints.Builder().setValidator(
            DateValidatorPointBackward.now()).build()
    }
}