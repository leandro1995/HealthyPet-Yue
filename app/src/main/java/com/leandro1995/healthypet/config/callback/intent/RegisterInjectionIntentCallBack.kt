package com.leandro1995.healthypet.config.callback.intent

import com.leandro1995.healthypet.model.design.Calendar
import com.leandro1995.healthypet.model.design.Message

interface RegisterInjectionIntentCallBack {

    fun view()

    fun messageErrorDialog(message: Message)

    fun datePickerDialog(calendar: Calendar)

    fun completeRegistration()
}