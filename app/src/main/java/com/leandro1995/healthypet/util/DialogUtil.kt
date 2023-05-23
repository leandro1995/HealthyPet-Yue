package com.leandro1995.healthypet.util

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.datepicker.MaterialDatePicker
import com.leandro1995.healthypet.R
import com.leandro1995.healthypet.model.design.Calendar

class DialogUtil {

    companion object {

        private const val DATE_PICKER_DIALOG = "date_picker_dialog"

        fun datePickerDialog(
            activity: Activity,
            calendar: Calendar,
            dateLong: (long: Long) -> Unit
        ) {

            MaterialDatePicker.Builder.datePicker().let { dialog ->

                dialog.setTitleText(activity.getString(R.string.app_name))

                if (calendar.isToday) {

                    dialog.setSelection(MaterialDatePicker.todayInUtcMilliseconds())
                }

                if (calendar.isNow) {

                    dialog.setCalendarConstraints(DatePickerCalendarUtil.setValidatorNow())
                }

                dialog.build().let { build ->

                    build.addOnPositiveButtonClickListener {

                        dateLong(it)
                    }

                    build.show(
                        (activity as AppCompatActivity).supportFragmentManager, DATE_PICKER_DIALOG
                    )
                }
            }
        }
    }
}