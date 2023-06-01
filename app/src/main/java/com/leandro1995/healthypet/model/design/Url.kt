package com.leandro1995.healthypet.model.design

import android.content.Intent
import android.net.Uri
import com.leandro1995.healthypet.util.ShareUtil

class Url constructor(private val url: String) {

    fun viewPage() = Intent(Intent.ACTION_VIEW, Uri.parse(url))

    fun share(message: String) = ShareUtil.intentShare(message = "$message\n\n${urlIfEmpty()}")

    private fun urlIfEmpty() = url.ifEmpty { "" }
}