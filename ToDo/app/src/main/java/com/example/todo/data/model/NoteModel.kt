package com.example.todo.data.model

import com.example.helloandroid.core.DataFetchCallback

interface NoteModel {
    fun insertNote(note: Note, callback: DataFetchCallback<Note>)
    fun getNoteList(callback : DataFetchCallback<MutableList<Note>>)
    fun updateNote(note: Note, callback : DataFetchCallback<Int>)
    fun deleteNote(id: Long, callback : DataFetchCallback<Int>)
}