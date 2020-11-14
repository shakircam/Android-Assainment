package com.example.hellohasan.feature.blogList.model

import com.example.hellohasan.network.BlogApiInterface
import com.example.hellohasan.network.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class BlogListModelImpl : BlogListModel {

    private val apiInterface: BlogApiInterface = RetrofitClient.getClient().create(BlogApiInterface::class.java)
    private val call : Call<MutableList<Blog>> = apiInterface.getBlogList()
    
    override fun getBlogList(blogListCallBack: BlogListCallBack) {

        call.enqueue(object : Callback<MutableList<Blog>> {
            override fun onResponse(
                call: Call<MutableList<Blog>>,
                response: Response<MutableList<Blog>>)
            {
                response.body()?.let { blogListCallBack.onSuccess(it) }
            }

            override fun onFailure(call: Call<MutableList<Blog>>, t: Throwable) {
                blogListCallBack.onError(t)
            }

        })
    }
}