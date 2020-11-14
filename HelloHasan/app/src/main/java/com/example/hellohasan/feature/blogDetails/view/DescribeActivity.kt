package com.example.hellohasan.feature.blogDetails.view

import android.annotation.SuppressLint
import android.os.Bundle
import android.text.Html
import android.view.View
import androidx.appcompat.widget.Toolbar
import com.bumptech.glide.Glide
import com.example.hellohasan.R
import com.example.hellohasan.core.BaseActivity
import com.example.hellohasan.feature.blogDetails.presenter.BlogDetailsPresenter
import com.example.hellohasan.feature.blogDetails.presenter.BlogDetailsPresenterImpl
import com.example.hellohasan.feature.blogList.model.Blog
import com.example.hellohasan.feature.blogList.view.BlogListView
import kotlinx.android.synthetic.main.activity_describe.*
import kotlinx.android.synthetic.main.toolbar.*

class DescribeActivity() : BaseActivity() , BlogListView {


    private lateinit var presenter : BlogDetailsPresenter
    override fun setLayoutId(): Int {
       return R.layout.activity_describe
    }

    override fun setToolbar(): Toolbar {
        toolbar.title = getString(R.string.toolbar_item)
        return toolbar
    }


    override val isHomeUpButtonEnable: Boolean
        get() = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val id = intent.getIntExtra("value",0)
        presenter = BlogDetailsPresenterImpl(this)
        presenter.singlePost(id)

    }

    override fun progressBarVisibility(isVisible: Boolean) {
        if (isVisible)
            progress.visibility = View.VISIBLE
        else
            progress.visibility = View.GONE

    }


    override fun onBlogListRetrieveSuccess(blogList: MutableList<Blog>) {
      // Nothing necessary
    }


    override fun onBlogFetchSuccess(blog: Blog) {
        Glide.with(this)
            .load(blog.jetpack_featured_media_url)
            .into(iv_item)
        tv_blog_title.text = Html.fromHtml(blog.title.rendered)
        tv_author_name.text = getString(R.string.author_name)
        tvDate.text = blog.date
        tv_details.text = Html.fromHtml(blog.content.rendered)
    }

    override fun onBlogListRetrieveFailure(errorMessage: String) {
        TODO("Not yet implemented")
    }


}