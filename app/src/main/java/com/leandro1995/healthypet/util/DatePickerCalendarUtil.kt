package com.leandro1995.healthypet.util

import com.google.android.material.datepicker.CalendarConstraints
import com.google.android.material.datepicker.DateValidatorPointBackward
import com.google.android.material.datepicker.DateValidatorPointForward
import java.util.Calendar
import java.util.Date

class DatePickerCalendarUtil() {

    companion object {

        fun setValidatorNow(isNow: Boolean) = CalendarConstraints.Builder().setValidator(
            if (isNow) {

                DateValidatorPointBackward.now()
            } else {

                DateValidatorPointForward.from(date())
            }
        ).build()

        private fun date(): Long {

            val calendar = Calendar.getInstance()

            calendar.time = Date()

            return calendar.time.time
        }
    }
}