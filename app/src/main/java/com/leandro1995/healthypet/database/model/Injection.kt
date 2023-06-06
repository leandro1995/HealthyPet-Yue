package com.leandro1995.healthypet.database.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.leandro1995.healthypet.database.config.DatabaseSetting

@Entity
class Injection constructor(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = DatabaseSetting.ID) val id: Int = 0,
    @ColumnInfo(name = DatabaseSetting.PHOTO_URL) var photoUrl: String = "",
    @ColumnInfo(name = DatabaseSetting.CURRENT_DATE) var currentDate: Long = -1L,
    @ColumnInfo(name = DatabaseSetting.NEXT_APPOINTMENT) var nextAppointment: Long = -1L,
    @ColumnInfo(name = DatabaseSetting.ID_TYPE_INJECTION) var idTypeInjection: Int = -1,
    @ColumnInfo(name = DatabaseSetting.COMMENT) val comment: String = ""
)