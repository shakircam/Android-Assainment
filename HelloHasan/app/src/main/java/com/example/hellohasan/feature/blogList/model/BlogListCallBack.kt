package com.example.hellohasan.feature.blogList.model

interface BlogListCallBack {
    fun onSuccess(blogList: MutableList<Blog>)
    fun onError(throwable: Throwable)
}