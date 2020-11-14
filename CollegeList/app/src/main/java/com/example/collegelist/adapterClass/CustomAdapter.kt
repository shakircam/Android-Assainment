package com.example.collegelist.adapterClass


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.collegelist.R
import com.example.collegelist.data.College


class CustomAdapter(context:Context , private val collegeList : ArrayList<College> ) : RecyclerView.Adapter<CustomAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
       val view = LayoutInflater.from(parent.context).inflate(R.layout.item_college,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
       return collegeList.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {


    }


}