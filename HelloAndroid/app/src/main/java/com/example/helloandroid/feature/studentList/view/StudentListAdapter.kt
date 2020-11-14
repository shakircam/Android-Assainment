package com.example.helloandroid.feature.studentList.view

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.helloandroid.R
import com.example.helloandroid.feature.studentList.model.StudentResponse

class StudentListAdapter(private val studentList: List<StudentResponse.Data>,private val itemClickListener: ItemClickListener<Int>):RecyclerView.Adapter<StudentViewHolder>() {
    lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        val context = parent.context
        val view = LayoutInflater.from(context).inflate(R.layout.item_list,parent,false)
        return StudentViewHolder(view)
    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        val student = studentList[position]
        Glide.with(holder.pic)
            .load(student.image)
            .into(holder.pic)
        holder.name.text = student.name
        holder.email.text = student.email
        holder.college.text= student.institution
        holder.itemView.setOnClickListener { itemClickListener.onItemClick(position) }
    }

    override fun getItemCount(): Int {
        return studentList.size
    }
}