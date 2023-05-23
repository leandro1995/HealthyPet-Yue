package com.leandro1995.healthypet.extension

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import androidx.datastore.core.DataStore
import androidx.datastore.dataStore
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.leandro1995.healthypet.HealthyPetPreferences
import com.leandro1995.healthypet.config.Setting
import com.leandro1995.healthypet.datastore.HealthyPetSerializable
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.Date

val Context.healthyPetDataStore: DataStore<HealthyPetPreferences> by dataStore(
    fileName = Setting.DATA_STORE_HEALTHY_PET, serializer = HealthyPetSerializable()
)

fun lifecycleScope(activity: Activity, method: suspend () -> Unit) {

    (activity as AppCompatActivity).lifecycleScope.launch {

        activity.repeatOnLifecycle(Lifecycle.State.CREATED) {

            method()
        }
    }
}

infix fun String.putString(activity: Activity) = activity.intent.getStringExtra(this)

infix fun Intent.putString(key: String) = this.getStringExtra(key)

@SuppressLint("SimpleDateFormat")
infix fun Long.dateFormat(format: String): String {

    return SimpleDateFormat(format).format(Date(this))
}