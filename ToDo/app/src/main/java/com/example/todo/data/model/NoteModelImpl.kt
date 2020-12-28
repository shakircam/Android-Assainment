package com.example.todo.data.model

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.util.Log
import com.example.helloandroid.core.DataFetchCallback
import com.example.todo.data.db.DatabaseHelper
import com.example.todo.utils.*
import com.orhanobut.logger.Logger
import java.lang.Exception

class NoteModelImpl(private val context: Context):NoteModel {


    override fun insertNote(note: Note, callback: DataFetchCallback<Note>) {

        val databaseHelper = DatabaseHelper.getInstance(context)
        val sqLiteDatabase = databaseHelper.writableDatabase
        val contentValues = ContentValues()

        contentValues.put(COLUMN_NOTE_TITLE,note.title)
        contentValues.put(COLUMN_NOTE_DESCRIPTION,note.description)
        contentValues.put(COLUMN_NOTE_PRIORITY,note.priority)


        try {
            val id = sqLiteDatabase.insertOrThrow(TABLE_NOTE,null,contentValues)
            if (id>0){
                note.id = id
                callback.onSuccess(note)
                Log.d("yes","data insert.......")
            }
            else
                callback.onError(Throwable("Insert failed...."))
            Log.d("key","err why.......")

        }catch (e:Exception){
            callback.onError(e)
            Logger.e(e.localizedMessage)
            //Log.d("key","err.......")
        }finally {
            sqLiteDatabase?.close()
        }

    }


    override fun getNoteList(callback: DataFetchCallback<MutableList<Note>>) {

        val databaseHelper = DatabaseHelper.getInstance(context)
        val sqLiteDatabase = databaseHelper.readableDatabase

        var cursor : Cursor? = null

        try {
            cursor = sqLiteDatabase.query(TABLE_NOTE,
                null,
                null,
                null,
                null,
                null,
                null,
                null)

            if (cursor?.moveToFirst() == true){
                val noteList = mutableListOf<Note>()

                do {
                    val id = cursor.getInt(cursor.getColumnIndex(COLUMN_NOTE_ID))
                    val title = cursor.getString(cursor.getColumnIndex(COLUMN_NOTE_TITLE))
                    val description = cursor.getString(cursor.getColumnIndex(COLUMN_NOTE_DESCRIPTION))
                    val priority = cursor.getInt(cursor.getColumnIndex(COLUMN_NOTE_PRIORITY))

                    noteList.add(Note(id.toLong(),title,description,priority))

                } while (cursor.moveToNext())

                callback.onSuccess(noteList)
                Log.d("list","list....")
            }
        }catch (e:Exception){

            callback.onError(e)
            Logger.e(e.localizedMessage.toString())
        }finally {
            cursor?.close()
            sqLiteDatabase.close()
        }
    }

    override fun updateNote(note: Note, callback: DataFetchCallback<Int>) {

        val databaseHelper = DatabaseHelper.getInstance(context)
        val sqLiteDatabase = databaseHelper.writableDatabase

        val contentValues = ContentValues()
        contentValues.put(COLUMN_NOTE_TITLE,note.title)
        contentValues.put(COLUMN_NOTE_DESCRIPTION,note.description)
        contentValues.put(COLUMN_NOTE_PRIORITY,note.priority)


        try {
            val rawUpdate = sqLiteDatabase.update(
                TABLE_NOTE,
                contentValues,
                "$COLUMN_NOTE_ID = ? ",
                arrayOf(note.id.toString()))

            if (rawUpdate>0){
                callback.onSuccess(rawUpdate)
            }
            else
                callback.onError(Throwable("Update failed...."))
        }catch (e:Exception){
            callback.onError(e)
         }finally {
            sqLiteDatabase.close()
          }
        }


    override fun deleteNote(id: Long, callback: DataFetchCallback<Int>) {
        val databaseHelper = DatabaseHelper.getInstance(context)
        val sqLiteDatabase = databaseHelper.writableDatabase

        try {
            val deleteRawCount = sqLiteDatabase.delete(TABLE_NOTE,"$COLUMN_NOTE_ID = ? ", arrayOf(id.toString()))
            if (deleteRawCount>0){
                callback.onSuccess(deleteRawCount)
            }else
                callback.onError(Throwable("No data is delete"))
        }
        catch (e:Exception){
            callback.onError(e)
        }finally {
            sqLiteDatabase.close()
        }
    }
}