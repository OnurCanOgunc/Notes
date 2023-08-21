package com.decode.noteapp.repo

import com.decode.noteapp.db.NoteDao
import com.decode.noteapp.db.NotesEntity
import javax.inject.Inject

class NotesRepository @Inject constructor(private val noteDao: NoteDao) {

    fun allNotes() = noteDao.getAllNotes()
    suspend fun saveNote(notesEntity: NotesEntity) = noteDao.insertNote(notesEntity)
    suspend fun deleteNote(notesEntity: NotesEntity) = noteDao.deleteNote(notesEntity)
    fun searchNote(text: String) = noteDao.searchNote(text)
}