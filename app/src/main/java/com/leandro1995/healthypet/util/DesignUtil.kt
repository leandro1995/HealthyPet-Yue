package com.leandro1995.healthypet.util

import android.annotation.SuppressLint
import android.app.Activity
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.google.android.material.appbar.MaterialToolbar
import com.leandro1995.healthypet.R
import com.leandro1995.healthypet.activity.ListPetActivity
import com.leandro1995.healthypet.activity.WelcomeActivity

class DesignUtil {

    companion object {

        fun splashActivitySelect(isWelcome: Boolean) = if (isWelcome) {

            ListPetActivity()
        } else {

            WelcomeActivity()
        }

        @SuppressLint("UseCompatLoadingForDrawables")
        fun materialToolbar(
            activity: Activity,
            materialToolbar: MaterialToolbar,
            @StringRes idTitle: Int = -1,
            isTitleCentered: Boolean = true,
            @DrawableRes arrowImage: Int = R.drawable.ic_arrow,
            isArrow: Boolean = false,
            method: () -> Unit = {}
        ) {

            materialToolbar.apply {

                if (idTitle != -1) {

                    title = activity.getString(idTitle)
                }

                if (isArrow) {

                    navigationIcon = activity.getDrawable(arrowImage)
                }

                this.isTitleCentered = isTitleCentered

                setNavigationOnClickListener { method() }
            }
        }
    }
}