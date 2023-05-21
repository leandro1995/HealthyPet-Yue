package com.leandro1995.healthypet.util

import android.app.Activity
import android.os.Environment

class FileUtil {

    companion object {

        fun createFolder(activity: Activity): String {

            val file = activity.getExternalFilesDir(Environment.DIRECTORY_PICTURES)

            if (!file!!.exists()) {

                file.mkdirs()
            }

            return file.absolutePath
        }
    }
}