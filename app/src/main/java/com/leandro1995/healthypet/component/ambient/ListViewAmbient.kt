package com.leandro1995.healthypet.component.ambient

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.databinding.DataBindingUtil
import com.leandro1995.healthypet.R
import com.leandro1995.healthypet.databinding.ComponentListPetBinding

open class ListViewAmbient(context: Context, attrs: AttributeSet? = null) :
    ViewAmbient(context, attrs) {

    private lateinit var componentListPetBinding: ComponentListPetBinding

    override fun view() {

        componentListPetBinding = DataBindingUtil.inflate(
            (context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater),
            R.layout.component_list_pet,
            this,
            true
        )
    }
}