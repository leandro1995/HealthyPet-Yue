package com.leandro1995.healthypet.config.listener

import com.leandro1995.healthypet.config.callback.camera.CameraPhotoCallBack
import com.otaliastudios.cameraview.CameraListener
import com.otaliastudios.cameraview.PictureResult

class CameraPhotoListener : CameraListener() {

    var cameraPhotoCallBack: CameraPhotoCallBack? = null

    override fun onPictureTaken(result: PictureResult) {

        isCameraPhoto(byteArray = result.data)
    }

    private fun isCameraPhoto(byteArray: ByteArray) {

        if (cameraPhotoCallBack != null) {

            cameraPhotoCallBack!!.photoByteArray(byteArray = byteArray)
        }
    }
}