package com.leandro1995.healthypet.util

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.datepicker.MaterialDatePicker
import com.leandro1995.healthypet.R

class DialogUtil {

    companion object {

        private const val DATE_PICKER_DIALOG = "date_picker_dialog"

        fun datePickerDialog(activity: Activity) {

            MaterialDatePicker.Builder.datePicker()
                .setTitleText(activity.getString(R.string.app_name)).build()
                .show((activity as AppCompatActivity).supportFragmentManager, DATE_PICKER_DIALOG)
        }
    }
}