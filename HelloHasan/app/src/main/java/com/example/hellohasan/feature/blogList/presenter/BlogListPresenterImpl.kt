package com.example.hellohasan.feature.blogList.presenter

import com.example.hellohasan.feature.blogList.model.Blog
import com.example.hellohasan.feature.blogList.model.BlogListCallBack
import com.example.hellohasan.feature.blogList.model.BlogListModel
import com.example.hellohasan.feature.blogList.model.BlogListModelImpl
import com.example.hellohasan.feature.blogList.view.BlogListView

class BlogListPresenterImpl(private val view : BlogListView): BlogListPresenter {
    private val model : BlogListModel = BlogListModelImpl()

    override fun getBlogList() {
        view.progressBarVisibility(true)

        model.getBlogList(object : BlogListCallBack {
            override fun onSuccess(blogList: MutableList<Blog>) {
                view.progressBarVisibility(false)

                view.onBlogListRetrieveSuccess(blogList)
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