package com.leandro1995.healthypet.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.leandro1995.healthypet.database.model.Injection

@Dao
interface InjectionDao {

    @Insert
    suspend fun register(injection: Injection): Long

    @Query("select * from Injection")
    suspend fun injectionList(): MutableList<Injection>
}