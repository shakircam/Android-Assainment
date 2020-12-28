package com.example.todo.data.db

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.todo.utils.*

object DatabaseHelper {
    private lateinit var context: Context

    private val databaseHelper by lazy {

    object : SQLiteOpenHelper(context, DATABASE_NAME,null, DATABASE_VERSION) {

        override fun onCreate(db: SQLiteDatabase?) {

            val createNoteTable =
                "CREATE TABLE $TABLE_NOTE($COLUMN_NOTE_ID INTEGER PRIMARY KEY AUTOINCREMENT, $COLUMN_NOTE_TITLE TEXT NOT NULL, $COLUMN_NOTE_DESCRIPTION TEXT, $COLUMN_NOTE_PRIORITY INTEGER NOT NULL UNIQUE)"

            db?.execSQL(createNoteTable)

        }

        override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
            db?.execSQL("DROP TABLE IF EXISTS $TABLE_NOTE")
            onCreate(db)
        }
    }

    }

    fun getInstance(context: Context): SQLiteOpenHelper {
        DatabaseHelper.context = context
        return databaseHelper
    }
}

