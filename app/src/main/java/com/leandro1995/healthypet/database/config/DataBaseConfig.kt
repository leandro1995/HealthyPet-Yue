package com.leandro1995.healthypet.database.config

import android.content.Context
import androidx.room.Room
import com.leandro1995.healthypet.database.DatabaseApp

object DataBaseConfig {

    private lateinit var database: DatabaseApp

    private const val DATA_BASE = "healthy_pet_db"

    fun instance(context: Context) {

        database =
            Room.databaseBuilder(context.applicationContext, DatabaseApp::class.java, DATA_BASE)
                .build()
    }

    fun petDao() = database.petDao()
}