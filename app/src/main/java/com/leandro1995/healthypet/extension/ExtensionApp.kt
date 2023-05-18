package com.leandro1995.healthypet.extension

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import kotlinx.coroutines.launch

fun lifecycleScope(activity: Activity, method: suspend () -> Unit) {

    (activity as AppCompatActivity).lifecycleScope.launch {

        activity.repeatOnLifecycle(Lifecycle.State.CREATED) {

            method()
        }
    }
}