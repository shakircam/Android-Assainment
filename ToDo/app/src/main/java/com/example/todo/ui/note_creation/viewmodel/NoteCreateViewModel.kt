package com.example.todo.ui.note_creation.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.helloandroid.core.DataFetchCallback
import com.example.todo.data.model.Note
import com.example.todo.data.model.NoteModel

class NoteCreateViewModel(private val model: NoteModel) : ViewModel(){

    val noteCreationSuccessLiveData = MutableLiveData<Note>()
    val noteCreationFailedLiveData = MutableLiveData<String>()

    fun createNote(note : Note){

        model.insertNote(note, object : DataFetchCallback<Note> {
            override fun onSuccess(data: Note) {
                noteCreationSuccessLiveData.postValue(data)
            }

            override fun onError(throwable: Throwable) {
                noteCreationFailedLiveData.postValue(throwable.localizedMessage)
            }

        })
    }

}