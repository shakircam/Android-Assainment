package com.example.todo.ui.note_update.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.todo.data.model.NoteModel


class NoteUpdateViewModelFactory(val model: NoteModel): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {

        if (modelClass.isAssignableFrom(NoteUpdateViewModel::class.java)) {
            return NoteUpdateViewModel(model) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class... ")

    }
}