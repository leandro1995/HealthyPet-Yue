package com.leandro1995.healthypet.util

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.os.Build
import android.text.Html
import android.view.Window
import android.view.WindowManager
import android.widget.TextView
import androidx.activity.OnBackPressedCallback
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import androidx.core.text.HtmlCompat
import com.google.android.material.appbar.MaterialToolbar
import com.leandro1995.healthypet.R
import com.leandro1995.healthypet.activity.ToCompleteActivity
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

            Setting.UPDATE_COMPLETE_MESSAGE_CODE -> {

                R.string.update_pet_message
            }

            Setting.TO_COMPLETE_INJECTION_MESSAGE_CODE -> {

                R.string.register_injection_message
            }

            else -> {

                -1
            }
        }

        fun onBackPressed(activity: Activity, method: () -> Unit = {}) {

            (activity as AppCompatActivity).onBackPressedDispatcher.addCallback(activity,
                object : OnBackPressedCallback(true) {
                    override fun handleOnBackPressed() {

                        method()
                    }
                })
        }

        @Suppress("DEPRECATION")
        fun textHtml(
            activity: Activity, textView: TextView, @StringRes idString: Int, petName: String
        ) {

            textView.setText(
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {

                    Html.fromHtml(
                        "${activity.getString(idString)} ${colorHtml(string = petName)}",
                        HtmlCompat.FROM_HTML_MODE_LEGACY
                    )
                } else {

                    Html.fromHtml("${activity.getString(idString)} ${colorHtml(string = petName)}")
                }, TextView.BufferType.SPANNABLE
            )

        }

        fun sexText(isSex: Boolean) = if (isSex) {

            R.string.female_text
        } else {

            R.string.male_text
        }

        fun intentToCompleteActivity(activity: Activity, code: Int) = Intent(
            activity, ToCompleteActivity::class.java
        ).apply {

            putExtra(Setting.CODE_MESSAGE_PUT, code)
        }

        private fun colorHtml(string: String) = "<font color='#FFCF6F'>${string}.</font>"
    }
}