package com.example.todo.ui.note_list.view

interface NoteListClickListener {
    fun onEditButtonClicked(noteId: Long)
    fun onDeleteButtonClicked(noteId: Long)
}
