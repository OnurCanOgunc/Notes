package com.decode.noteapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.decode.noteapp.db.NotesEntity
import com.decode.noteapp.repo.NotesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NotesViewModel @Inject constructor(private val repository: NotesRepository) : ViewModel() {

    private val _notesList = MutableLiveData<List<NotesEntity>>()
    val notesList: LiveData<List<NotesEntity>> get() = _notesList

    fun saveNote(notesEntity: NotesEntity) = viewModelScope.launch(Dispatchers.IO) {
        repository.saveNote(notesEntity)
    }

    fun deleteNote(notesEntity: NotesEntity) = viewModelScope.launch(Dispatchers.IO) {
        repository.deleteNote(notesEntity)
    }

    fun getAllNotes() = viewModelScope.launch(Dispatchers.IO) {
        repository.allNotes().collect {
            _notesList.postValue(it)
        }
    }

    fun getSearchNotes(text: String) = viewModelScope.launch(Dispatchers.IO) {
        repository.searchNote(text).collect {
            _notesList.postValue(it)
        }
    }
}