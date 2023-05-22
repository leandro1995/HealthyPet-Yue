package com.leandro1995.healthypet.model.entity

import android.app.Activity

class Spice constructor(val id: Int = -1, private var idText: Int = -1) {

    fun text(activity: Activity) = if (idText == -1) {

        ""
    } else {

        activity.getString(idText)
    }
}