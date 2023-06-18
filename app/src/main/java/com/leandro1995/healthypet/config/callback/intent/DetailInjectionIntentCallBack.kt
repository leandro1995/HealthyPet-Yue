package com.leandro1995.healthypet.config.callback.intent

import com.leandro1995.healthypet.model.design.Calendar
import com.leandro1995.healthypet.model.entity.Injection

interface DetailInjectionIntentCallBack {

    fun view()

    fun injectionStatus(isStatus: Boolean, injection: Injection)

    fun datePickerDialog(calendar: Calendar)
}