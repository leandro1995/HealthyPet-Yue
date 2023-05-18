package com.leandro1995.healthypet.datastore.config

import android.content.Context
import androidx.datastore.core.DataStore
import com.leandro1995.healthypet.HealthyPetPreferences
import com.leandro1995.healthypet.extension.healthyPetDataStore
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking

object HealthyPetDataStoreConfig {

    private lateinit var healthyPetDataStore: DataStore<HealthyPetPreferences>

    fun instance(context: Context) {

        healthyPetDataStore = context.healthyPetDataStore
    }

    fun setIsWelcome(isWelcome: Boolean) = runBlocking {
        healthyPetDataStore.updateData { data ->

            data.toBuilder().setIsWelcome(isWelcome).build()
        }
    }

    fun isWelcome() = runBlocking { healthyPetDataStore.data.first().isWelcome }
}