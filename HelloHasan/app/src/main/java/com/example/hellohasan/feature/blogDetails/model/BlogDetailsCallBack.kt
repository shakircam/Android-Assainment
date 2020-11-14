package com.example.hellohasan.feature.blogDetails.model

import com.example.hellohasan.feature.blogList.model.Blog

interface BlogDetailsCallBack {
    fun onSuccess(blog: Blog)
    fun onError(throwable: Throwable)
}