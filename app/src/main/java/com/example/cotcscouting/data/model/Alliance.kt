package com.example.cotcscouting.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "alliance")
data class Alliance(
    @PrimaryKey(autoGenerate = true) val uid: Int,
    @ColumnInfo(name = "blue_amps_count") val blueAmpsCount: Int?,
    @ColumnInfo(name = "blue_co_op") val blueCoOp: Boolean?,
    @ColumnInfo(name = "blue_melody") val blueMelody: Boolean?,
    @ColumnInfo(name = "blue_ensamble") val blueEnsamble: Boolean?,
    @ColumnInfo(name = "blue_harmony") val blueHarmony: Boolean?,
    @ColumnInfo(name = "red_amps_count") val redAmpsCount: Int?,
    @ColumnInfo(name = "red_co_op") val redCoOp: Boolean?,
    @ColumnInfo(name = "red_melody") val redMelody: Boolean?,
    @ColumnInfo(name = "red_ensamble") val redEnsamble: Boolean?,
    @ColumnInfo(name = "red_harmony") val redHarmony: Boolean?,
    @ColumnInfo(name = "match_number") val matchNumber: Int,
    @ColumnInfo(name = "scout_name") val scoutName: String,
    @ColumnInfo(name= "regional_code") val regionalCode: String
)
