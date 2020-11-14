package com.example.hellohasan.feature.blogList.view

import com.example.hellohasan.feature.blogList.model.Blog

interface BlogListView {
    fun progressBarVisibility(isVisible: Boolean)
    fun onBlogListRetrieveSuccess(blogList: MutableList<Blog>)
    fun onBlogFetchSuccess(blog: Blog)
    fun onBlogListRetrieveFailure(errorMessage: String)
}