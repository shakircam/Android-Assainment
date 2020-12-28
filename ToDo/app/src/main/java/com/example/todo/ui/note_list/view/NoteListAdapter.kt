package com.example.todo.ui.note_list.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.todo.R
import com.example.todo.data.model.Note

class NoteListAdapter(private val noteList: MutableList<Note>,
                      private val clickListener: NoteListClickListener)
    :RecyclerView.Adapter<NoteViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_note,parent,false)
        return NoteViewHolder(view)
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {

        val note = noteList[position]

        holder.title.text = note.title
        holder.description.text = note.description
        holder.priority.text = note.priority.toString()

        holder.edit.setOnClickListener { clickListener.onEditButtonClicked(note.id) }
        holder.delete.setOnClickListener { clickListener.onDeleteButtonClicked(note.id) }
        holder.itemView.setOnClickListener {
            //nothing
        }
    }

    fun replaceData(noteList: MutableList<Note>) {
        this.noteList.clear()
        this.noteList.addAll(noteList)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return noteList.size
    }
}