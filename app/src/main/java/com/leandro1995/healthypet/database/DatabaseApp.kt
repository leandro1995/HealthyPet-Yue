package com.leandro1995.healthypet.database

import androidx.room.AutoMigration
import androidx.room.Database
import androidx.room.RoomDatabase
import com.leandro1995.healthypet.BuildConfig
import com.leandro1995.healthypet.database.dao.InjectionDao
import com.leandro1995.healthypet.database.dao.PetDao
import com.leandro1995.healthypet.database.model.Injection
import com.leandro1995.healthypet.database.model.Pet

@Database(
    entities = [Pet::class, Injection::class],
    version = BuildConfig.VERSION_CODE,
    exportSchema = true,
    autoMigrations = [AutoMigration(
        from = (BuildConfig.VERSION_CODE - 1), to = BuildConfig.VERSION_CODE
    )]
)
abstract class DatabaseApp : RoomDatabase() {

    abstract fun petDao(): PetDao

    abstract fun injectionDao(): InjectionDao
}