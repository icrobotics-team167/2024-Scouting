package com.example.cotcscouting.data.model

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface AllianceDAO {
    @Query("SELECT * FROM alliance")
    fun getAll(): List<Alliance>

    @Query("SELECT * FROM alliance WHERE uid IN (:allianceIds)")
    fun loadAllByIds(allianceIds: IntArray): List<Alliance>

    @Query("SELECT * FROM alliance WHERE first_name LIKE :first AND " +
            "last_name LIKE :last LIMIT 1")
    fun findByName(first: String, last: String): Alliance

    @Insert
    fun insertAll(vararg alliances: Alliance)

    @Delete
    fun delete(alliance: Alliance)
}