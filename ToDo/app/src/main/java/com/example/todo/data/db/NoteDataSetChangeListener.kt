package com.example.todo.data.db

interface NoteDataSetChangeListener {
    fun onNoteDataChanged()
    fun onNoteDataSetChangeError(error: String)
}