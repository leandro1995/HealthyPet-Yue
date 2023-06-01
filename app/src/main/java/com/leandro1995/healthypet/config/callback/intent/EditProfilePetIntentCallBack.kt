package com.leandro1995.healthypet.config.callback.intent

import com.leandro1995.healthypet.model.design.Calendar
import com.leandro1995.healthypet.model.design.Message

interface EditProfilePetIntentCallBack {

    fun view()

    fun datePickerDialog(calendar: Calendar)

    fun messageErrorDialog(message: Message)

    fun completeUpdate()
}