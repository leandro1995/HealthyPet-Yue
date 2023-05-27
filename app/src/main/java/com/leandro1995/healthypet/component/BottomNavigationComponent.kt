package com.leandro1995.healthypet.component

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.databinding.DataBindingUtil
import com.leandro1995.healthypet.R
import com.leandro1995.healthypet.component.ambient.ViewAmbient
import com.leandro1995.healthypet.databinding.ComponentBottomNavigationBinding

class BottomNavigationComponent(context: Context, attrs: AttributeSet? = null) :
    ViewAmbient(context, attrs) {

    private lateinit var componentBottomNavigationBinding: ComponentBottomNavigationBinding

    override fun view() {

        componentBottomNavigationBinding = DataBindingUtil.inflate(
            (context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater),
            R.layout.component_bottom_navigation,
            this,
            true
        )
    }
}