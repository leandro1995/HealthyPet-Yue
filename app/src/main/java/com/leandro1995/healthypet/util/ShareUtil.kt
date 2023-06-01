package com.leandro1995.healthypet.util

import android.content.Intent
import com.leandro1995.healthypet.model.design.Url

class ShareUtil {

    companion object {

        private const val TYPE_TEXT = "text/plain"

        fun intentShare(message: String) = Intent.createChooser(Intent().apply {

            action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_TEXT, message)
            type = TYPE_TEXT
        }, null)!!
    }
}