package com.leandro1995.healthypet.component.util

import android.content.res.TypedArray

class TypeArrayComponentUtil {

    companion object {

        fun typeArrayBackground(typedArray: TypedArray?, indexAttr: Int) =
            typedArray?.getResourceId(indexAttr, android.R.color.transparent)
                ?: android.R.color.transparent

        fun typeArrayImage(typedArray: TypedArray?, indexAttr: Int) =
            typedArray?.getResourceId(indexAttr, android.R.color.transparent)
                ?: android.R.color.transparent

        fun typeArrayText(typedArray: TypedArray?, indexAttr: Int) =
            typedArray?.getString(indexAttr)

        fun typeArrayMenu(typedArray: TypedArray?, indexAttr: Int) =
            typedArray?.getResourceId(indexAttr, android.R.color.transparent)
                ?: android.R.color.transparent
    }
}