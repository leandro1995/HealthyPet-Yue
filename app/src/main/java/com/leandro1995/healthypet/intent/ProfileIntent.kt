package com.leandro1995.healthypet.intent

import android.content.Intent

sealed class ProfileIntent {

    object View : ProfileIntent()

    data class PlayStoreOpen constructor(val intent: Intent) : ProfileIntent()
}
