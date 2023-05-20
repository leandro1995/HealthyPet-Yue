package com.leandro1995.healthypet.component

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.databinding.DataBindingUtil
import com.leandro1995.healthypet.R
import com.leandro1995.healthypet.component.ambient.ViewAmbient
import com.leandro1995.healthypet.databinding.ComponentSexSelectionBinding

class SexSelectionComponent(context: Context, attrs: AttributeSet? = null) :
    ViewAmbient(context, attrs) {

    private lateinit var componentSexSelectionBinding: ComponentSexSelectionBinding

    override fun view() {

        componentSexSelectionBinding = DataBindingUtil.inflate(
            (context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater),
            R.layout.component_sex_selection,
            this,
            true
        )
    }
}