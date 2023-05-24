package com.leandro1995.healthypet.application

import android.app.Application
import com.facebook.drawee.backends.pipeline.Fresco
import com.leandro1995.healthypet.database.config.DataBaseConfig
import com.leandro1995.healthypet.datastore.config.HealthyPetDataStoreConfig

class HealthyPetApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        HealthyPetDataStoreConfig.instance(context = this)
        Fresco.initialize(this)
        DataBaseConfig.instance(context = this)
    }
}