package com.leandro1995.healthypet.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.leandro1995.healthypet.database.config.DatabaseSetting
import com.leandro1995.healthypet.database.model.Pet

@Dao
interface PetDao {

    @Insert
    suspend fun register(pet: Pet): Long

    @Query("select * from Pet")
    suspend fun petList(): MutableList<Pet>

    @Query("update Pet set ${DatabaseSetting.PHOTO_URL} =:photoUrl, ${DatabaseSetting.NAME} =:name, ${DatabaseSetting.SPICE_ID} =:spiceId, ${DatabaseSetting.IS_SEX} =:isSex, ${DatabaseSetting.DATE} =:date where ${DatabaseSetting.ID} = :id")
    suspend fun update(
        id: Int, photoUrl: String, name: String, spiceId: Int, isSex: Boolean, date: Long
    )

    @Query("select * from Pet where ${DatabaseSetting.ID} = :id")
    suspend fun idPet(id: Int): Pet
}