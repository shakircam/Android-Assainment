package com.example.todo.data.model

data class Note(
    var id: Long = -1L,
    val title: String,
    val description: String,
    val priority: Int
)
