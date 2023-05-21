package com.leandro1995.healthypet.intent

sealed class CropImageIntent {

    object View : CropImageIntent()

    object CropImage : CropImageIntent()
}