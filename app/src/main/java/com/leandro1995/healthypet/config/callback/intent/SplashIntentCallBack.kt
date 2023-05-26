package com.leandro1995.healthypet.config.callback.intent

import android.app.Activity
import com.leandro1995.healthypet.model.entity.Pet

interface SplashIntentCallBack {

    fun view()

    fun welComeActivity(activity: Activity)

    fun petListActivity(activity: Activity, petArrayList: ArrayList<Pet>)
}