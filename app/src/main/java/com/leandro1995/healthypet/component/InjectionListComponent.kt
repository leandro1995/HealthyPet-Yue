package com.leandro1995.healthypet.component

import android.content.Context
import android.util.AttributeSet
import com.leandro1995.healthypet.component.ambient.ListViewAmbient
import com.leandro1995.healthypet.model.entity.Injection

class InjectionListComponent(context: Context, attrs: AttributeSet? = null) :
    ListViewAmbient(context, attrs) {

    fun injectionArrayList(injectionArrayList: ArrayList<Injection>) {

    }
}