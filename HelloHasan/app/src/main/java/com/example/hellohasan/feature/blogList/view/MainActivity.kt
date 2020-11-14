package com.example.hellohasan.feature.blogList.view

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hellohasan.R
import com.example.hellohasan.core.BaseActivity
import com.example.hellohasan.feature.blogDetails.view.DescribeActivity
import com.example.hellohasan.feature.blogList.model.Blog
import com.example.hellohasan.feature.blogList.presenter.BlogListPresenter
import com.example.hellohasan.feature.blogList.presenter.BlogListPresenterImpl
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.toolbar.*

class MainActivity() : BaseActivity(),BlogListView {

    override fun setLayoutId(): Int {
        return R.layout.activity_main
    }

    override fun setToolbar(): Toolbar {
        toolbar.title = "Hello Hasan"
        return toolbar
    }

    override val isHomeUpButtonEnable: Boolean get() = false
    private lateinit var presenter : BlogListPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter = BlogListPresenterImpl(this)
        presenter.getBlogList()

    }

    override fun progressBarVisibility(isVisible: Boolean) {
        if (isVisible)
            progress.visibility = View.VISIBLE
        else
            progress.visibility = View.GONE
    }

    override fun onBlogListRetrieveSuccess(blogList: MutableList<Blog>) {
        initAdapter(blogList)
    }

    override fun onBlogFetchSuccess(blog: Blog) {
        // No implementation
    }

    private fun initAdapter(blogList: MutableList<Blog>) {
        val adapter = BlogListAdapter(blogList, object : ItemClickListener {
            override fun onItemClick(position: Int) {
                val id = blogList[position].id
                val intent = Intent(this@MainActivity, DescribeActivity::class.java)
                intent.putExtra("value",id)
                startActivity(intent)
            }

        })
        recyclerViewId.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        recyclerViewId.adapter = adapter

    }

    override fun onBlogListRetrieveFailure(errorMessage: String) {
        showToast(errorMessage)
    }
}