package com.leandro1995.healthypet.config

class Setting {

    companion object {

        const val SPLASH_TIME_OUT = 2L
        const val DATA_STORE_HEALTHY_PET = "data_store_healthy_pet"

        const val IMAGE_PUT = "image_put"

        const val DATE_FORMAT_ONE = "dd/MM/yyyy"

        const val PHOTO_URL_MESSAGE = 0
        const val NAME_MESSAGE = 1
        const val DATE_MESSAGE = 2
        const val COMPLETE = 3

        val MessageHashMap =
            hashMapOf(
                Pair(PHOTO_URL_MESSAGE, 0),
                Pair(NAME_MESSAGE, 0),
                Pair(DATE_MESSAGE, 0),
                Pair(COMPLETE, 0)
            )
    }
}