package com.leandro1995.healthypet.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.leandro1995.healthypet.database.model.Pet

@Dao
interface PetDao {

    @Insert
    suspend fun register(pet: Pet)

    @Query("select * from Pet")
    suspend fun petList(): MutableList<Pet>
}