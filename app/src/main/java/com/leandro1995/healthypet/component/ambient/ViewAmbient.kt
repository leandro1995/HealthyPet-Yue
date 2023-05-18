package com.leandro1995.healthypet.component.ambient

import android.content.Context
import android.content.res.TypedArray
import android.util.AttributeSet
import androidx.constraintlayout.widget.ConstraintLayout

open class ViewAmbient @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null
) : ConstraintLayout(context, attrs) {

    init {

        view()
    }

    protected open fun view() {}

    protected fun attributes(intArray: IntArray, attrs: AttributeSet?) = if (attrs == null) {

        null
    } else {

        context.obtainStyledAttributes(attrs, intArray)
    }

    protected open fun typedArray(typedArray: TypedArray?) {}
}