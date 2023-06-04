package com.leandro1995.healthypet.util

import android.app.Activity
import com.leandro1995.healthypet.R
import com.leandro1995.healthypet.model.design.InjectionChecked
import com.leandro1995.healthypet.model.design.WelcomePage
import com.leandro1995.healthypet.model.entity.Injection
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

        fun indexSpice(activity: Activity, id: Int) =
            spiceArrayList(activity = activity).indexOfFirst { it.id == id }

        fun injectionCheckedArrayList(activity: Activity): ArrayList<InjectionChecked> {

            val injectionCheckedArrayList = ArrayList<InjectionChecked>()

            injectionArrayList(activity = activity).forEach {

                injectionCheckedArrayList.add(InjectionChecked(injection = it))
            }

            return injectionCheckedArrayList
        }

        private fun injectionArrayList(activity: Activity) = arrayListOf(
            Injection(id = 0, name = activity.getString(R.string.distemper_text)),
            Injection(id = 1, name = activity.getString(R.string.par_virus_text)),
            Injection(id = 2, name = activity.getString(R.string.hepatitis_text)),
            Injection(id = 3, name = activity.getString(R.string.influenza_text)),
            Injection(id = 4, name = activity.getString(R.string.lep_text)),
            Injection(id = 5, name = activity.getString(R.string.rhino_text)),
            Injection(id = 6, name = activity.getString(R.string.pan_text)),
            Injection(id = 7, name = activity.getString(R.string.calicivirus_text)),
            Injection(id = 8, name = activity.getString(R.string.rabia_text)),
            Injection(id = 9, name = activity.getString(R.string.other_text))
        )
    }
}