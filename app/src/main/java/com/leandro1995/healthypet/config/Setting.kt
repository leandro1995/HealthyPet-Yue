package com.leandro1995.healthypet.config

import com.leandro1995.healthypet.R

class Setting {

    companion object {

        const val SPLASH_TIME_OUT = 2L
        const val DATA_STORE_HEALTHY_PET = "data_store_healthy_pet"

        const val IMAGE_PUT = "image_put"

        const val DATE_FORMAT_ONE = "dd/MM/yyyy"

        const val PHOTO_URL_MESSAGE = 1
        const val NAME_MESSAGE = 2
        const val DATE_MESSAGE = 3
        const val COMPLETE = 0

        val MESSAGE_HASH_MAP = hashMapOf(
            Pair(PHOTO_URL_MESSAGE, R.string.photo_url_message),
            Pair(NAME_MESSAGE, R.string.name_message),
            Pair(DATE_MESSAGE, R.string.date_message),
            Pair(COMPLETE, 0)
        )
    }
}