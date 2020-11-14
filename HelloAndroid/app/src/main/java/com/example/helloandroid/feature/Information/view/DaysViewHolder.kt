package com.example.helloandroid.feature.Information.view

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_days.view.*

class DaysViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

val day : TextView = itemView.days
}
