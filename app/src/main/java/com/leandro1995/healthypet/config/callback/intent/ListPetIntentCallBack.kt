package com.leandro1995.healthypet.config.callback.intent

import android.app.Activity

interface ListPetIntentCallBack {

    fun view()

    fun registerPetActivity(activity: Activity)
}