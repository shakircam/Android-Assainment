package com.example.todo.ui.note_list.view

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.button.MaterialButton
import kotlinx.android.synthetic.main.item_note.view.*


class NoteViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    val title : TextView = itemView.title
    val description : TextView = itemView.description
    val priority : TextView = itemView.priority
    val edit : MaterialButton = itemView.bt_edit
    val delete : MaterialButton = itemView.bt_delete

}
