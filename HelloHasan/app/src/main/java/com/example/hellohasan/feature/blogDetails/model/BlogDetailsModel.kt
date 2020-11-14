package com.example.hellohasan.feature.blogDetails.model

interface BlogDetailsModel {
    fun singlePost(post_id: Int, blogDetailsCallBack: BlogDetailsCallBack)
}