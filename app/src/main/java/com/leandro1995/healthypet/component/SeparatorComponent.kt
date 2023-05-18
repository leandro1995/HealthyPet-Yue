package com.leandro1995.healthypet.component

import android.content.Context
import android.content.res.TypedArray
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import com.leandro1995.healthypet.R
import com.leandro1995.healthypet.component.ambient.ViewAmbient
import com.leandro1995.healthypet.component.util.TypeArrayComponentUtil
import com.leandro1995.healthypet.databinding.ComponentSeparatorBinding

class SeparatorComponent(context: Context, attrs: AttributeSet? = null) :
    ViewAmbient(context, attrs) {

    private lateinit var componentSeparatorBinding: ComponentSeparatorBinding

    init {

        typedArray(
            typedArray = attributes(
                intArray = R.styleable.SeparatorComponent, attrs = attrs
            )
        )
    }

    override fun view() {

        componentSeparatorBinding = DataBindingUtil.inflate(
            (context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater),
            R.layout.component_separator,
            this,
            true
        )
    }

    override fun typedArray(typedArray: TypedArray?) {

        componentSeparatorBinding.separatorView.background = ContextCompat.getDrawable(
            context,
            TypeArrayComponentUtil.typeArrayBackground(
                typedArray = typedArray,
                indexAttr = R.styleable.SeparatorComponent_background_separator
            )
        )
    }
}