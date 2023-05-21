package com.leandro1995.healthypet.extension

import android.app.Activity
import android.content.Context
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

infix fun String.putExtra(activity: Activity) = activity.intent.getStringExtra(this)