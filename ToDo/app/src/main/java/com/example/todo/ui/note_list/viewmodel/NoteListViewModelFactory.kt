package com.example.todo.ui.note_list.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.todo.data.model.NoteModel
import java.lang.IllegalArgumentException

class NoteListViewModelFactory(private val model: NoteModel) : ViewModelProvider.Factory{

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(NoteListViewModel::class.java)){
            return NoteListViewModel(model) as T
        }
        throw IllegalArgumentException(" Unknown View Model Class")
    }
}