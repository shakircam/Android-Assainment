package com.example.helloandroid.feature.studentList.view

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_list.view.*

class StudentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val pic : ImageView = itemView.iv_pic
    val name : TextView = itemView.tv_name
    val email : TextView = itemView.tv_email
    val college : TextView = itemView.tv_college

}
