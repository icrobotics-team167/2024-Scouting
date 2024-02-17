package com.example.cotcscouting.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "match")
data class Match(
    @PrimaryKey(autoGenerate = true) val uid: Int,
    @ColumnInfo(name = "auto_amp_count") val autoAmpCount: Int?,
    @ColumnInfo(name = "auto_speaker_count") val autoSpeakerCount: Int?,
    @ColumnInfo(name = "teleop_amp_count") val teleopAmpCount: Int?,
    @ColumnInfo(name = "tele_op_speaker_count") val teleOpSpeakerCount: Int?,
    @ColumnInfo(name = "amp_speaker_count") val ampSpeakerCount: Int?,
    @ColumnInfo(name = "leave") val leave: Boolean?,
    @ColumnInfo(name = "on_stage") val onStage: Boolean?,
    @ColumnInfo(name = "on_stage_spotlit") val onStageSpotlit: Boolean?,
    @ColumnInfo(name = "trap_note") val trapNote: Int?,
    @ColumnInfo(name = "park") val park: Boolean?,
    @ColumnInfo(name = "match_number") val matchNumber: Int,
    @ColumnInfo(name = "team_number") val teamNumber: Int,
    @ColumnInfo(name = "scout_name") val scoutName: String,
    @ColumnInfo(name= "regional_code") val regionalCode: String
)
