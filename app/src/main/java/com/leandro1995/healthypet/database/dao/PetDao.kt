package com.leandro1995.healthypet.database.dao

import androidx.room.Dao
import androidx.room.Insert
import com.leandro1995.healthypet.database.model.Pet

@Dao
interface PetDao {

    @Insert
    suspend fun register(pet: Pet)
}