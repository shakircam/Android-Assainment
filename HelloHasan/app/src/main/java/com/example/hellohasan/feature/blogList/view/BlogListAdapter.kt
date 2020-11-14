package com.example.hellohasan.feature.blogList.view

import android.annotation.SuppressLint
import android.content.Context
import android.text.Html
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.hellohasan.R
import com.example.hellohasan.feature.blogList.model.Blog
import java.text.SimpleDateFormat


class BlogListAdapter(private val blogList: MutableList<Blog>, private val itemClickListener: ItemClickListener):RecyclerView.Adapter<BlogViewHolder>() {

    lateinit var context: Context
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BlogViewHolder {
        context= parent.context
        val view = LayoutInflater.from(context).inflate(R.layout.item_blog, parent, false)
        return BlogViewHolder(view)
    }

    @SuppressLint("SimpleDateFormat")
    override fun onBindViewHolder(holder: BlogViewHolder, position: Int) {
        val blog = blogList[position]
        Glide.with(holder.blogItem)
                .load(blog.jetpack_featured_media_url)
                .into(holder.blogItem)
        holder.blogTitle.text = Html.fromHtml(blog.title.rendered)

        holder.blogDate.text = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").parse(blog.date).toString()
        holder.blogAuthor.text = holder.itemView.context.getString(R.string.author_name)

        holder.itemView.setOnClickListener { itemClickListener.onItemClick(position) }
    }

    override fun getItemCount(): Int {
        return blogList.size
    }
}