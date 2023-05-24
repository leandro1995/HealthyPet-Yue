package com.leandro1995.healthypet.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.leandro1995.healthypet.BuildConfig
import com.leandro1995.healthypet.database.model.Pet

@Database(entities = [Pet::class], version = BuildConfig.VERSION_CODE)
abstract class DatabaseApp : RoomDatabase() {

}