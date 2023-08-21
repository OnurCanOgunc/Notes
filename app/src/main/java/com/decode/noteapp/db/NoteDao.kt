package com.decode.noteapp.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNote(notes: NotesEntity)

    @Delete
    suspend fun deleteNote(notes: NotesEntity)

    @Query("Select * from Notes")
    fun getAllNotes(): Flow<List<NotesEntity>>

    @Query("Select * from notes Where noteTitle Like '%'|| :text || '%'")
    fun searchNote(text: String): Flow<List<NotesEntity>>
}