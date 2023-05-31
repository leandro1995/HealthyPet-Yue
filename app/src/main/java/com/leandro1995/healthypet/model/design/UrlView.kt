package com.leandro1995.healthypet.model.design

import android.content.Intent
import android.net.Uri

class UrlView constructor(private val url: String) {

    fun viewPage() = Intent(Intent.ACTION_VIEW, Uri.parse(url))
}