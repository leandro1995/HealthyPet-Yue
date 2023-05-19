package com.leandro1995.healthypet.component.ambient

import android.content.Context
import android.content.res.TypedArray
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import androidx.databinding.DataBindingUtil
import com.leandro1995.healthypet.R
import com.leandro1995.healthypet.component.util.TypeArrayComponentUtil
import com.leandro1995.healthypet.databinding.ComponentListPetBinding

open class ListViewAmbient(context: Context, attrs: AttributeSet? = null) :
    ViewAmbient(context, attrs) {

    private lateinit var componentListPetBinding: ComponentListPetBinding

    init {

        typedArray(
            typedArray = attributes(
                intArray = R.styleable.ListViewAmbient, attrs = attrs
            )
        )
    }

    override fun view() {

        componentListPetBinding = DataBindingUtil.inflate(
            (context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater),
            R.layout.component_list_pet,
            this,
            true
        )
    }

    override fun typedArray(typedArray: TypedArray?) {

        TypeArrayComponentUtil.let { typedArrayComponent ->

            componentListPetBinding.errorImage.setImageResource(
                typedArrayComponent.typeArrayImage(
                    typedArray = typedArray,
                    indexAttr = R.styleable.ListViewAmbient_image_error_list
                )
            )

            componentListPetBinding.errorText.text = typedArrayComponent.typeArrayText(
                typedArray = typedArray,
                indexAttr = R.styleable.ListViewAmbient_text_error_list
            )
        }
    }

    protected fun errorMessageVisible() {

        componentListPetBinding.messageErrorLinear.visibility = View.VISIBLE
    }

    private fun errorMessageGone() {

        componentListPetBinding.messageErrorLinear.visibility = View.GONE
    }
}