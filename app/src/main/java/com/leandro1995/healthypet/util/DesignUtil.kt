package com.leandro1995.healthypet.util

import android.annotation.SuppressLint
import android.app.Activity
import android.os.Build
import android.view.Window
import android.view.WindowManager
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.google.android.material.appbar.MaterialToolbar
import com.leandro1995.healthypet.R
import com.leandro1995.healthypet.config.Setting

class DesignUtil {

    companion object {

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

        fun statusBarTransparent(window: Window) {

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {

                window.setDecorFitsSystemWindows(false)
            } else {

                window.setFlags(
                    WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                    WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
                )
            }
        }

        fun messageId(code: Int) = when (code) {

            Setting.TO_COMPLETE_MESSAGE_CODE -> {

                R.string.register_pet_message
            }

            else -> {

                -1
            }
        }
    }
}