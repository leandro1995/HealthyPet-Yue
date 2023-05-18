package com.leandro1995.healthypet.model.design

import android.app.Activity

class WelcomePage constructor(
    val idImage: Int,
    private val idTitle: Int,
    private val idSubtitle: Int,
    private val idButtonText: Int
) {
    fun title(activity: Activity) = activity.getString(idTitle)

    fun subTitle(activity: Activity) = activity.getString(idSubtitle)

    fun buttonText(activity: Activity) = activity.getString(idButtonText)
}