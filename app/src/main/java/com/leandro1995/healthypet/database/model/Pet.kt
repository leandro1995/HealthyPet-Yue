package com.leandro1995.healthypet.database.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.leandro1995.healthypet.database.config.DatabaseSetting
import com.leandro1995.healthypet.model.entity.Pet
import com.leandro1995.healthypet.model.entity.Spice

@Entity
class Pet constructor(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = DatabaseSetting.ID) val id: Int = 0,
    @ColumnInfo(name = DatabaseSetting.PHOTO_URL) var photoUrl: String = "",
    @ColumnInfo(name = DatabaseSetting.NAME) var name: String = "",
    @ColumnInfo(name = DatabaseSetting.SPICE_ID) var spiceId: Int = -1,
    @ColumnInfo(name = DatabaseSetting.IS_SEX) var isSex: Boolean = false,
    @ColumnInfo(name = DatabaseSetting.DATE) var date: Long = -1L
) {

    fun pet() = Pet(
        id = id,
        photoUrl = photoUrl,
        name = name,
        spice = Spice(id = spiceId),
        isSex = isSex,
        date = date
    )
}