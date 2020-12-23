package com.example.todo.ui.note_update.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.helloandroid.core.DataFetchCallback
import com.example.todo.data.model.Note
import com.example.todo.data.model.NoteModel

class NoteUpdateViewModel(private val model: NoteModel) : ViewModel() {

    val noteUpdateSuccessLiveData = MutableLiveData<Int>()
    val noteUpdateFailedLiveData = MutableLiveData<String>()

    fun upNote(note: Note){
        model.updateNote(note, object : DataFetchCallback<Int> {
            override fun onSuccess(data: Int) {
                noteUpdateSuccessLiveData.postValue(data)
            }

            override fun onError(throwable: Throwable) {
                noteUpdateFailedLiveData.postValue(throwable.localizedMessage)
            }

        })
    }
}