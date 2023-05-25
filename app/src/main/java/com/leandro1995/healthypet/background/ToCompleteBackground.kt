package com.leandro1995.healthypet.background

import kotlinx.coroutines.delay
import java.util.concurrent.TimeUnit

class ToCompleteBackground {

    companion object {

        private const val TIME_OUT = 2L

        suspend fun timeOut(method: () -> Unit) {

            delay(TimeUnit.SECONDS.toMillis(TIME_OUT))

            method()
        }
    }
}