package com.leandro1995.healthypet.util

import android.app.Activity
import androidx.annotation.StringRes
import com.google.android.material.appbar.MaterialToolbar
import com.leandro1995.healthypet.activity.ListPetActivity
import com.leandro1995.healthypet.activity.WelcomeActivity

class DesignUtil {

    companion object {

        fun splashActivitySelect(isWelcome: Boolean) = if (isWelcome) {

            ListPetActivity()
        } else {

            WelcomeActivity()
        }

        fun materialToolbar(
            activity: Activity,
            materialToolbar: MaterialToolbar,
            @StringRes idTitle: Int,
            isTitleCentered: Boolean = true
        ) {

            materialToolbar.apply {

                title = activity.getString(idTitle)
                this.isTitleCentered = isTitleCentered
            }
        }
    }
}