package com.example.cotcscouting.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "info")
data class Info(
    @PrimaryKey(autoGenerate = true) val uid: Int,
//    @ColumnInfo()
)

