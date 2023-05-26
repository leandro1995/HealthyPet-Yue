package com.leandro1995.healthypet.component.util

import com.leandro1995.healthypet.R

class DesignComponentUtil {

    companion object {

        fun sexImage(isSex: Boolean) = if (isSex) {

            R.drawable.ic_female
        } else {

            R.drawable.ic_male
        }
    }
}