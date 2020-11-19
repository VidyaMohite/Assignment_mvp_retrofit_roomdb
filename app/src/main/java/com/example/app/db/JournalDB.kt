package com.example.app.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.app.model.Journal
import com.example.app.utils.Convertors

@Database(entities = [(Journal::class)],version = 1)
@TypeConverters(Convertors::class)
abstract class JournalDB : RoomDatabase() {

    abstract fun journalDao(): JournalDAO

    companion object {

        private var journalDatabase: JournalDB? = null

        //java.lang.RuntimeException: cannot find implementation for com.example.app.db.JournalDB. JournalDB_Impl does not exist

        fun getInstance(context: Context): JournalDB {
            if (journalDatabase == null) {
                journalDatabase =
                    Room.databaseBuilder(context, JournalDB::class.java, "JournalDB.db")
                        .allowMainThreadQueries()
                        .fallbackToDestructiveMigration()
                        .build()
            }
            return journalDatabase!!
        }
    }
}