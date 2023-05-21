package com.leandro1995.healthypet.config.listener

import android.app.Activity
import com.leandro1995.healthypet.config.callback.camera.CameraPhotoCallBack
import com.leandro1995.healthypet.util.FileUtil
import com.otaliastudios.cameraview.CameraListener
import com.otaliastudios.cameraview.PictureResult

class CameraPhotoListener constructor(private val activity: Activity) : CameraListener() {

    var cameraPhotoCallBack: CameraPhotoCallBack? = null

    override fun onPictureTaken(result: PictureResult) {

        isCameraPhoto(byteArray = result.data)
    }

    private fun isCameraPhoto(byteArray: ByteArray) {

        if (cameraPhotoCallBack != null) {

            cameraPhotoCallBack!!.photoByteArray(
                url = FileUtil.photoUrl(
                    activity = activity,
                    byteArray = byteArray
                )
            )
        }
    }
}