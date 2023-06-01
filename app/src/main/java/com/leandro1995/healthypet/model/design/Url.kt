package com.leandro1995.healthypet.model.design

import android.content.Intent
import android.net.Uri

class Url constructor(private val url: String) {

    companion object {

        private const val TYPE_TEXT = "text/plain"
    }

    fun viewPage() = Intent(Intent.ACTION_VIEW, Uri.parse(url))

    fun share(message: String) = Intent.createChooser(Intent().apply {

        action = Intent.ACTION_SEND
        putExtra(Intent.EXTRA_TEXT, "$message\n${urlIfEmpty()}")
        type = TYPE_TEXT
    }, null)!!

    private fun urlIfEmpty() = url.ifEmpty { "" }
}