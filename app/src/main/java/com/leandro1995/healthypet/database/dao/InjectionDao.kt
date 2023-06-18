package com.leandro1995.healthypet.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.leandro1995.healthypet.database.config.DatabaseSetting
import com.leandro1995.healthypet.database.model.Injection

@Dao
interface InjectionDao {

    @Insert
    suspend fun injectionRegister(injection: Injection): Long

    @Query("select * from Injection where ${DatabaseSetting.ID_PET} == :idPet")
    suspend fun injectionList(idPet: Int): MutableList<Injection>

    @Query("delete from Injection where ${DatabaseSetting.ID} = :id")
    suspend fun injectionDelete(id: Int)

    @Query("update Injection set ${DatabaseSetting.PHOTO_URL} =:photoUrl, ${DatabaseSetting.CURRENT_DATE} =:currentDate, ${DatabaseSetting.NEXT_APPOINTMENT} = :nextAppointment, ${DatabaseSetting.ID_TYPE_INJECTION} =:idTypeInjection, ${DatabaseSetting.COMMENT} =:comment where ${DatabaseSetting.ID} = :id")
    suspend fun injectionUpdate(
        id: Int,
        photoUrl: String,
        currentDate: Long,
        nextAppointment: Long,
        idTypeInjection: Int,
        comment: String
    )
}