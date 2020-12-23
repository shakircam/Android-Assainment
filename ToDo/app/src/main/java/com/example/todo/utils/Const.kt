package com.example.todo.utils

// If you change the database schema, you must increment the database version.
const val DATABASE_VERSION = 1
const val DATABASE_NAME = "note-db"

//column names of note table
const val TABLE_NOTE = "note"
const val COLUMN_NOTE_ID = "_id"
const val COLUMN_NOTE_TITLE = "title"
const val COLUMN_NOTE_DESCRIPTION = "description"
const val COLUMN_NOTE_PRIORITY = "priority"


//others for general purpose key-value pair data
const val TITLE = "title"
const val CREATE_NOTE = "create_note"
const val UPDATE_NOTE = "update_note"