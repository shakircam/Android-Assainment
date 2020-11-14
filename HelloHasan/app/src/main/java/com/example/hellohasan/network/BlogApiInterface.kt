package com.example.hellohasan.network

import com.example.hellohasan.feature.blogList.model.Blog
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface BlogApiInterface {

    @GET ("posts")
    fun getBlogList() : Call<MutableList<Blog>>

    @GET("posts/{post_id}")
    fun singlePost(@Path("post_id") post_id : Int): Call<Blog>
}