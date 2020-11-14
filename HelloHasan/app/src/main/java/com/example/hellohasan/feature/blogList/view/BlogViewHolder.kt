package com.example.hellohasan.feature.blogList.view

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_blog.view.*

class BlogViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val blogItem : ImageView = itemView.iv_blog_item
    val blogTitle : TextView = itemView.tv_blogTitle
    val blogDate : TextView = itemView.tv_date
    val blogAuthor : TextView = itemView.tv_authorName

}
