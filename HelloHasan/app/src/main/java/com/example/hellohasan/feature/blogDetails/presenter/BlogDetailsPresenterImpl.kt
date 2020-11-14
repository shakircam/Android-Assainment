package com.example.hellohasan.feature.blogDetails.presenter

import com.example.hellohasan.feature.blogList.model.Blog
import com.example.hellohasan.feature.blogDetails.model.BlogDetailsCallBack
import com.example.hellohasan.feature.blogDetails.model.BlogDetailsModel
import com.example.hellohasan.feature.blogDetails.model.BlogDetailsModelImpl
import com.example.hellohasan.feature.blogList.view.BlogListView
import java.text.SimpleDateFormat

class BlogDetailsPresenterImpl(private val view: BlogListView): BlogDetailsPresenter {
    private val model : BlogDetailsModel = BlogDetailsModelImpl()

    override fun singlePost(post_id: Int) {
        view.progressBarVisibility(true)

       model.singlePost(post_id, object : BlogDetailsCallBack {
           override fun onSuccess(blog: Blog) {
               view.progressBarVisibility(false)
               blog.date = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").parse(blog.date).toString()
               view.onBlogFetchSuccess(blog)
           }

           override fun onError(throwable: Throwable) {
               view.progressBarVisibility(false)
               if (throwable.localizedMessage != null)
                   view.onBlogListRetrieveFailure(throwable.localizedMessage!!)
               else
                   view.onBlogListRetrieveFailure("Data aren't arrived.......")

           }
       })

    }


}