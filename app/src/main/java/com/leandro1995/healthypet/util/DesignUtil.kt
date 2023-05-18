package com.leandro1995.healthypet.util

import com.leandro1995.healthypet.activity.ListPetActivity
import com.leandro1995.healthypet.activity.WelcomeActivity

class DesignUtil {

    companion object {

        fun splashActivitySelect(isWelcome: Boolean) = if (isWelcome) {

            ListPetActivity()
        } else {

            WelcomeActivity()
        }
    }
}