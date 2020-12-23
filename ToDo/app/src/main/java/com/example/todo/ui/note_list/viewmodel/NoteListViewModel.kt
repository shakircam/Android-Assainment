package com.example.todo.ui.note_list.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.helloandroid.core.DataFetchCallback
import com.example.todo.data.model.Note
import com.example.todo.data.model.NoteModel

class NoteListViewModel(private val model : NoteModel):ViewModel() {

    val noteListLiveData = MutableLiveData<MutableList<Note>>()
    val noteListFailedLiveData = MutableLiveData<String>()
    val noteDeletionSuccessLiveData = MutableLiveData<Int>()
    val noteDeletionFailedLiveData = MutableLiveData<String>()

    fun getNoteList(){
        model.getNoteList(object : DataFetchCallback<MutableList<Note>> {
            override fun onSuccess(data: MutableList<Note>) {
                noteListLiveData.postValue(data)
            }

            override fun onError(throwable: Throwable) {
                noteListFailedLiveData.postValue(throwable.localizedMessage)
            }

        })
    }
    fun deleteNoteById(id : Long){
        model.deleteNote(id, object : DataFetchCallback<Int> {
            override fun onSuccess(data: Int) {
                noteDeletionSuccessLiveData.postValue(data)
            }

            override fun onError(throwable: Throwable) {
                noteDeletionFailedLiveData.postValue(throwable.localizedMessage)
            }

        })
    }

}