package com.leandro1995.healthypet.util

import android.app.Activity
import com.leandro1995.healthypet.R
import com.leandro1995.healthypet.model.design.TypeInjectionChecked
import com.leandro1995.healthypet.model.design.WelcomePage
import com.leandro1995.healthypet.model.entity.TypeInjection
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

        fun typeInjectionCheckedArrayList(activity: Activity): ArrayList<TypeInjectionChecked> {

            val typeInjectionCheckedArrayList = ArrayList<TypeInjectionChecked>()

            typeInjectionArrayList(activity = activity).forEach {

                typeInjectionCheckedArrayList.add(TypeInjectionChecked(typeInjection = it))
            }

            return typeInjectionCheckedArrayList
        }

        fun typeInjection(activity: Activity, id: Int) =
            typeInjectionArrayList(activity = activity).find { it.id == id }

        private fun typeInjectionArrayList(activity: Activity) = arrayListOf(
            TypeInjection(id = 0, name = activity.getString(R.string.distemper_text)),
            TypeInjection(id = 1, name = activity.getString(R.string.par_virus_text)),
            TypeInjection(id = 2, name = activity.getString(R.string.hepatitis_text)),
            TypeInjection(id = 3, name = activity.getString(R.string.influenza_text)),
            TypeInjection(id = 4, name = activity.getString(R.string.lep_text)),
            TypeInjection(id = 5, name = activity.getString(R.string.rhino_text)),
            TypeInjection(id = 6, name = activity.getString(R.string.pan_text)),
            TypeInjection(id = 7, name = activity.getString(R.string.calicivirus_text)),
            TypeInjection(id = 8, name = activity.getString(R.string.rabia_text)),
            TypeInjection(id = 9, name = activity.getString(R.string.other_text))
        )
    }
}