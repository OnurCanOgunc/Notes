package com.decode.noteapp.db

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [NotesEntity::class], version = 2, exportSchema = false)
abstract class NoteDB: RoomDatabase() {
    abstract fun noteDao(): NoteDao
}