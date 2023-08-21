package com.decode.noteapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.decode.noteapp.db.NotesEntity
import com.decode.noteapp.repo.NotesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NotesViewModel @Inject constructor(private val repository: NotesRepository) : ViewModel() {

    private val _notesList = MutableLiveData<List<NotesEntity>>()
    val notesList: LiveData<List<NotesEntity>> get() = _notesList

    fun saveNote(notesEntity: NotesEntity) = viewModelScope.launch {
        repository.saveNote(notesEntity)
    }

    fun deleteNote(notesEntity: NotesEntity) = viewModelScope.launch {
        repository.deleteNote(notesEntity)
    }

    fun getAllNotes() = viewModelScope.launch {
        repository.allNotes().collect {
            _notesList.postValue(it)
        }
    }

    fun getSearchNotes(text: String) = viewModelScope.launch {
        repository.searchNote(text).collect {
            _notesList.postValue(it)
        }
    }
}