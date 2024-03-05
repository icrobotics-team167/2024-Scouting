package com.example.cotcscouting.data.model

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface InfoDAO {
    @Query("SELECT * FROM `info`")
    fun getAll(): List<Info>

    @Query("SELECT * FROM `info` WHERE uid IN (:infoIds)")
    fun loadAllByIds(infoIds: IntArray): List<Info>

    @Query("SELECT * FROM `info` WHERE assigned_student LIKE :assigned_student LIMIT 1")
    fun findByTeamNumber(assignedStudent: Int): Info

    @Insert
    fun insertAll(vararg infos: Info)

    @Delete
    fun delete(info: Info)
    @Insert
    fun insert(info: Info)
}