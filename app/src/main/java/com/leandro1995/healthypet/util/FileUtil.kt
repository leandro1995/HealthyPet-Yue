package com.leandro1995.healthypet.util

import android.app.Activity
import android.os.Environment
import java.io.File
import java.io.FileOutputStream

class FileUtil {

    companion object {

        private const val EXTENSION_JPEG = ".jpeg"
        private const val INITIAL_IMG = "IMG_"

        private fun createFolder(activity: Activity): String {

            val file = activity.getExternalFilesDir(Environment.DIRECTORY_PICTURES)

            if (!file!!.exists()) {

                file.mkdirs()
            }

            return file.absolutePath
        }

        fun photoUrl(activity: Activity, byteArray: ByteArray): String {

            val file = File(
                createFolder(activity = activity),
                "${INITIAL_IMG}${System.currentTimeMillis()}${EXTENSION_JPEG}"
            )

            val fileOutputStream = FileOutputStream(file.path)
            fileOutputStream.write(byteArray)
            fileOutputStream.close()

            return file.absolutePath
        }
    }
}