package com.leandro1995.healthypet.component

import android.content.Context
import android.content.res.TypedArray
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.ui.setupWithNavController
import com.leandro1995.healthypet.R
import com.leandro1995.healthypet.component.ambient.ViewAmbient
import com.leandro1995.healthypet.component.util.TypeArrayComponentUtil
import com.leandro1995.healthypet.databinding.ComponentBottomNavigationBinding

class BottomNavigationComponent(context: Context, attrs: AttributeSet? = null) :
    ViewAmbient(context, attrs) {

    private lateinit var componentBottomNavigationBinding: ComponentBottomNavigationBinding

    init {

        typedArray(
            typedArray = attributes(
                intArray = R.styleable.BottomNavigationComponent, attrs = attrs
            )
        )
    }

    override fun view() {

        componentBottomNavigationBinding = DataBindingUtil.inflate(
            (context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater),
            R.layout.component_bottom_navigation,
            this,
            true
        )
    }

    fun navigationItem(navController: NavController) {

        componentBottomNavigationBinding.homeNavigation.setupWithNavController(navController)
    }

    override fun typedArray(typedArray: TypedArray?) {

        componentBottomNavigationBinding.homeNavigation.apply {

            menu.clear()
            inflateMenu(
                TypeArrayComponentUtil.typeArrayMenu(
                    typedArray = typedArray,
                    indexAttr = R.styleable.BottomNavigationComponent_menu_bottom_navigation
                )
            )
        }
    }
}