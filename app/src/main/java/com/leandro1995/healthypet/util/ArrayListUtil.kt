package com.leandro1995.healthypet.util

import android.app.Activity
import com.leandro1995.healthypet.R
import com.leandro1995.healthypet.model.design.WelcomePage
import com.leandro1995.healthypet.model.entity.Spice

class ArrayListUtil {

    companion object {

        fun welcomePageArrayList() = arrayListOf(
            WelcomePage(
                idImage = R.drawable.ic_welcome_page_one,
                idTitle = R.string.title_welcome_one,
                idSubtitle = R.string.description_welcome_one,
                idButtonText = R.string.next_button
            ), WelcomePage(
                idImage = R.drawable.ic_welcome_page_two,
                idTitle = R.string.title_welcome_two,
                idSubtitle = R.string.description_welcome_two,
                idButtonText = R.string.next_button
            ), WelcomePage(
                idImage = R.drawable.ic_welcome_page_three,
                idTitle = R.string.title_welcome_three,
                idSubtitle = R.string.description_welcome_three,
                idButtonText = R.string.begin_button
            )
        )

        fun arrayListSize(arrayList: ArrayList<*>) = arrayList.size

        fun spiceArrayList(activity: Activity) = arrayListOf(
            Spice(id = 1, name = activity.getString(R.string.dog_text)),
            Spice(id = 2, name = activity.getString(R.string.cat_text))
        )

        fun spiceFilter(id: Int, activity: Activity) =
            spiceArrayList(activity = activity).find { it.id == id }
    }
}