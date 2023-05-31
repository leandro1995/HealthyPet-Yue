package com.leandro1995.healthypet.config.callback.intent

import android.content.Intent

interface ProfileIntentCallBack {

    fun view()

    fun playStoreOpen(intent: Intent)
}