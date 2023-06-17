package com.leandro1995.healthypet.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.leandro1995.healthypet.database.config.DatabaseSetting
import com.leandro1995.healthypet.database.model.Injection

@Dao
interface InjectionDao {

    @Insert
    suspend fun register(injection: Injection): Long

    @Query("select * from Injection where ${DatabaseSetting.ID_PET} == :idPet")
    suspend fun injectionList(idPet: Int): MutableList<Injection>

    @Query("delete from Injection where ${DatabaseSetting.ID} = :id")
    suspend fun deleteInjection(id: Int)
}