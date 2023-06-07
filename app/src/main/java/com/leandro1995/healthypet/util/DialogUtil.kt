package com.leandro1995.healthypet.util

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.datepicker.MaterialDatePicker
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.leandro1995.healthypet.R
import com.leandro1995.healthypet.model.design.Calendar
import com.leandro1995.healthypet.model.design.Message

class DialogUtil {

    companion object {

        private const val DATE_PICKER_DIALOG = "date_picker_dialog"

        fun datePickerDialog(
            activity: Activity, calendar: Calendar, dateLong: (long: Long) -> Unit
        ) {

            MaterialDatePicker.Builder.datePicker().let { dialog ->

                dialog.setTitleText(activity.getString(R.string.app_name))

                if (calendar.isToday) {

                    if (calendar.isSelectDay()) {

                        dialog.setSelection(MaterialDatePicker.todayInUtcMilliseconds())
                    } else {

                        dialog.setSelection(calendar.date)
                    }
                }

                if (calendar.isCalendarConstraints) {

                    dialog.setCalendarConstraints(DatePickerCalendarUtil.setValidatorNow(isNow = calendar.isNow))
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

        fun messageDialog(activity: Activity, message: Message) {

            MaterialAlertDialogBuilder(activity).setTitle(activity.getString(R.string.app_name))
                .setMessage(activity.getString(message.messageError()!!))
                .setPositiveButton(activity.getString(R.string.accept_button)) { _, _ ->

                }.show()
        }
    }
}