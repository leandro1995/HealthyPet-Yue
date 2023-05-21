package com.leandro1995.healthypet.intent

import com.leandro1995.healthypet.model.design.Camera

sealed class CameraIntent {

    object View : CameraIntent()

    data class Photo constructor(val camera: Camera) : CameraIntent()
}