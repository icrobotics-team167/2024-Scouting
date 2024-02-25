package com.example.cotcscouting.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "pit")
data class Pit(
    @PrimaryKey(autoGenerate = true) val uid: Int,
    @ColumnInfo(name = "team_number") val teamNumber: Int?,
    @ColumnInfo(name = "scout_name") val scoutName: String,
    @ColumnInfo(name = "drive_coach_name") val driveCoachName: String,
    @ColumnInfo(name = "drive_base") val driveBase: String,
    @ColumnInfo(name = "rookie_team") val rookieTeam: Boolean?,
    @ColumnInfo(name = "how_many_autos") val howManyAutos: Int?,
    @ColumnInfo(name = "has_auto") val hasAuto: Boolean?,
    @ColumnInfo(name = "does_preload") val doesPreload: Boolean?,
    @ColumnInfo(name = "does_shoot") val doesShoot: Boolean?,
    @ColumnInfo(name = "does_intake") val doesIntake: Boolean?,
    @ColumnInfo(name = "where_do_you_start") val whereDoYouStart: String,
    @ColumnInfo(name = "where_do_you_score") val whereDoYouScore: String,
    @ColumnInfo(name = "notes_score_count") val notesScoreCount: Int?,
    @ColumnInfo(name = "game_strategy") val gameStrategy: String,
    @ColumnInfo(name = "intake") val intake: String
)