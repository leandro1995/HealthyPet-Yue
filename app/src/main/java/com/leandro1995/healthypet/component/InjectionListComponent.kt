package com.leandro1995.healthypet.component

import android.content.Context
import android.util.AttributeSet
import com.leandro1995.healthypet.component.ambient.ListViewAmbient
import com.leandro1995.healthypet.model.entity.Injection

class InjectionListComponent(context: Context, attrs: AttributeSet? = null) :
    ListViewAmbient(context, attrs) {

    private val injectionArrayList = arrayListOf<Injection>()

    fun injectionArrayList(injectionArrayList: ArrayList<Injection>) {

        this.injectionArrayList.clear()
        this.injectionArrayList.addAll(injectionArrayList)

        if (this.injectionArrayList.isEmpty()) {

            errorMessageVisible()
        } else {

            errorMessageGone()
        }
    }
}