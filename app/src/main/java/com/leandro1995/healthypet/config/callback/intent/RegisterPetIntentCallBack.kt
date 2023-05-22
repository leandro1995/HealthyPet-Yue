package com.leandro1995.healthypet.config.callback.intent

import com.leandro1995.healthypet.model.design.Calendar

interface RegisterPetIntentCallBack {

    fun view()

    fun datePickerDialog(calendar: Calendar)
}