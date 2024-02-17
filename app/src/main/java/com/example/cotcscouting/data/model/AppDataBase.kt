package com.example.cotcscouting.data.model

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Match::class, Alliance::class], version = 1)
abstract class AppDataBase : RoomDatabase() {
    abstract fun matchDAO(): MatchDAO
    abstract fun allianceDAO(): AllianceDAO
}
