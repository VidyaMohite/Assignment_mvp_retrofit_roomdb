package com.example.app.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.app.model.Journal

@Dao
interface JournalDAO {
    @Insert
    fun saveJournalDB(journal: Journal)

    @Query(value = "Select * from JournalEntity")
    fun getAllJournalData() : List<Journal>
}