package com.leandro1995.healthypet.component.util

import android.content.res.TypedArray

class TypeArrayComponentUtil {

    companion object {

        fun typeArrayBackground(typedArray: TypedArray?, indexAttr: Int) =
            typedArray?.getResourceId(indexAttr, android.R.color.transparent)
                ?: android.R.color.transparent
    }
}