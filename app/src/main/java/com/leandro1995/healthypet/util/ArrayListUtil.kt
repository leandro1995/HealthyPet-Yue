package com.leandro1995.healthypet.util

import com.leandro1995.healthypet.R
import com.leandro1995.healthypet.model.design.WelcomePage

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
    }
}