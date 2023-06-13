package com.leandro1995.healthypet.config

import com.leandro1995.healthypet.R

class Setting {

    companion object {

        const val SPLASH_TIME_OUT = 2L
        const val DATA_STORE_HEALTHY_PET = "data_store_healthy_pet"

        const val IMAGE_PUT = "image_put"
        const val CODE_MESSAGE_PUT = "code_message_put"
        const val PET_PUT = "pet_put"
        const val ID_PET_PUT = "id_pet_put"
        const val PET_ARRAY_LIST_PUT = "pet_array_list_put"
        const val INJECTION_PUT = "injection_put"
        const val BOOLEAN_PUT = "boolean_put"

        const val DATE_FORMAT_ONE = "dd/MM/yyyy"

        const val PHOTO_URL_MESSAGE = 1
        const val NAME_MESSAGE = 2
        const val DATE_MESSAGE = 3
        const val NEXT_APPOINTMENT = 4
        const val INJECTION = 5
        const val PHOTO_URL_INJECTION_MESSAGE = 6
        const val COMPLETE = 0

        const val TO_COMPLETE_MESSAGE_CODE = 0
        const val UPDATE_COMPLETE_MESSAGE_CODE = 1
        const val TO_COMPLETE_INJECTION_MESSAGE_CODE = 2

        const val PLAY_STORE_URL =
            "https://play.google.com/store/apps/details?id=com.leandro1995.healthypet"

        val MESSAGE_HASH_MAP = hashMapOf(
            Pair(PHOTO_URL_MESSAGE, R.string.photo_url_message),
            Pair(NAME_MESSAGE, R.string.name_message),
            Pair(DATE_MESSAGE, R.string.date_message),
            Pair(NEXT_APPOINTMENT, R.string.next_appointment_message),
            Pair(INJECTION, R.string.select_injection_message),
            Pair(PHOTO_URL_INJECTION_MESSAGE, R.string.photo_url_injection_message),
            Pair(COMPLETE, 0)
        )

        const val GRID_LAYOUT_TWO = 2
    }
}