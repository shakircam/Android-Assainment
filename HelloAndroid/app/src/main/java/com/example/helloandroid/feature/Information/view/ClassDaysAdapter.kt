package com.example.helloandroid.feature.Information.view

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.helloandroid.R
import com.example.helloandroid.feature.Information.model.Course

class ClassDaysAdapter(private val courseInformation : Course):RecyclerView.Adapter<DaysViewHolder>() {
    private lateinit var context : Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DaysViewHolder {
        val context = parent.context
        val view = LayoutInflater.from(context).inflate(R.layout.item_days,parent,false)
        return DaysViewHolder(view)
    }

    override fun onBindViewHolder(holder: DaysViewHolder, position: Int) {
        val classDay = courseInformation.data.class_days[position]

        holder.day.text = classDay
    }

    override fun getItemCount(): Int {
        return courseInformation.data.class_days.size
    }
}