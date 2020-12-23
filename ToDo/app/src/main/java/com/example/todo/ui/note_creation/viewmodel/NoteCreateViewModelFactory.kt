package com.example.todo.ui.note_creation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.todo.data.model.NoteModel

class NoteCreateViewModelFactory(val model: NoteModel): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {

        if (modelClass.isAssignableFrom(NoteCreateViewModel::class.java)) {
            return NoteCreateViewModel(model) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class... ")
    }
}