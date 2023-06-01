package com.leandro1995.healthypet.component

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import com.leandro1995.healthypet.R
import com.leandro1995.healthypet.component.ambient.ViewAmbient
import com.leandro1995.healthypet.component.config.callback.SexSelectionComponentCallBack
import com.leandro1995.healthypet.databinding.ComponentSexSelectionBinding

class SexSelectionComponent(context: Context, attrs: AttributeSet? = null) :
    ViewAmbient(context, attrs) {

    private lateinit var componentSexSelectionBinding: ComponentSexSelectionBinding

    var sexSelectionComponentCallBack: SexSelectionComponentCallBack? = null

    override fun view() {

        componentSexSelectionBinding = DataBindingUtil.inflate(
            (context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater),
            R.layout.component_sex_selection,
            this,
            true
        )

        onClick()
        defaultSelect()
    }

    fun selectSex(isSex: Boolean) {

        if (isSex) {

            sexFemaleSelect()
        } else {

            sexMaleSelect()
        }
    }

    private fun defaultSelect() {

        sexMaleSelect()
    }

    private fun onClick() {

        componentSexSelectionBinding.sexMaleLinear.setOnClickListener {

            sexMaleSelect()
        }

        componentSexSelectionBinding.sexFemaleLinear.setOnClickListener {

            sexFemaleSelect()
        }
    }

    private fun sexMaleSelect() {

        componentSexSelectionBinding.sexMaleLinear.background = ContextCompat.getDrawable(
            context, R.drawable.background_sex_selection_component_activated
        )

        componentSexSelectionBinding.sexFemaleLinear.background = ContextCompat.getDrawable(
            context, R.drawable.background_sex_selection_component_deactivated
        )

        componentSexSelectionBinding.sexMaleText.setTextColor(
            ContextCompat.getColor(
                context, R.color.white
            )
        )

        componentSexSelectionBinding.sexFemaleText.setTextColor(
            ContextCompat.getColor(
                context, R.color.blue_070821
            )
        )

        componentSexSelectionBinding.sexMaleImage.setImageResource(R.drawable.ic_male_select)

        componentSexSelectionBinding.sexFemaleImage.setImageResource(R.drawable.ic_female)

        isSexSelection(isSelection = false)
    }

    private fun sexFemaleSelect() {

        componentSexSelectionBinding.sexMaleLinear.background = ContextCompat.getDrawable(
            context, R.drawable.background_sex_selection_component_deactivated
        )

        componentSexSelectionBinding.sexFemaleLinear.background = ContextCompat.getDrawable(
            context, R.drawable.background_sex_selection_component_activated
        )

        componentSexSelectionBinding.sexMaleText.setTextColor(
            ContextCompat.getColor(
                context, R.color.blue_070821
            )
        )

        componentSexSelectionBinding.sexFemaleText.setTextColor(
            ContextCompat.getColor(
                context, R.color.white
            )
        )

        componentSexSelectionBinding.sexMaleImage.setImageResource(R.drawable.ic_male)

        componentSexSelectionBinding.sexFemaleImage.setImageResource(R.drawable.ic_female_select)

        isSexSelection(isSelection = true)
    }

    private fun isSexSelection(isSelection: Boolean) {

        if (sexSelectionComponentCallBack != null) {

            sexSelectionComponentCallBack!!.isSelectSex(isSelection)
        }
    }
}