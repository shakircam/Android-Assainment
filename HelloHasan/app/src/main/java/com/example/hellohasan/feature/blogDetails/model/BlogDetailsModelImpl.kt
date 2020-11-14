package com.example.hellohasan.feature.blogDetails.model

import com.example.hellohasan.feature.blogList.model.Blog
import com.example.hellohasan.network.BlogApiInterface
import com.example.hellohasan.network.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class BlogDetailsModelImpl : BlogDetailsModel {
    private val apiInterface: BlogApiInterface = RetrofitClient.getClient().create(BlogApiInterface::class.java)

    override fun singlePost(post_id: Int, blogDetailsCallBack: BlogDetailsCallBack) {

        val call   = apiInterface.singlePost(post_id)

        call.enqueue(object : Callback<Blog> {
            override fun onResponse(call: Call<Blog>, response: Response<Blog>) {
                response.body()?.let { blogDetailsCallBack.onSuccess(it) }

            }

            override fun onFailure(call: Call<Blog>, t: Throwable) {
                blogDetailsCallBack.onError(t)
            }

        })
    }
}