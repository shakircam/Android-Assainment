package com.example.helloandroid.feature.Information.view

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.helloandroid.R
import com.example.helloandroid.core.BaseActivity
import com.example.helloandroid.feature.Information.model.Course
import com.example.helloandroid.feature.Information.presenter.CourseInformationPresenter
import com.example.helloandroid.feature.Information.presenter.CourseInformationPresenterImpl
import com.example.helloandroid.feature.login.view.LoginActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.toolbar.*

class MainActivity : BaseActivity(),CourseListView {
    override fun setLayoutId(): Int {
        return R.layout.activity_main
    }

    override fun setToolbar(): Toolbar {
       toolbar.title = getString(R.string.course)
        return toolbar
    }

    override val isHomeUpButtonEnable: Boolean get() = false

private lateinit var presenter: CourseInformationPresenter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter = CourseInformationPresenterImpl(this)
        presenter.getCourseList()
        loginBt.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

    }

    override fun progressBarVisibility(isVisible: Boolean) {
        if (isVisible)
            progress.visibility = View.VISIBLE
        else
            progress.visibility = View.GONE
    }

    override fun onBlogListRetrieveSuccess(courseInformation: Course) {
        Glide.with(this)
                .load(R.drawable.android)
                .into(iv_item)

        tv_CourseName.text = courseInformation.data.name
        tv_blog_duration.text = courseInformation.data.duration
        tv_no_class.text = courseInformation.data.number_of_class.toString()
        tv_no_fee.text = courseInformation.data.fee
        url.text = courseInformation.data.url
        url.setOnClickListener {
          val  intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(courseInformation.data.url)
            startActivity(intent)
        }


        initAdapter(courseInformation)

        
    }

    private fun initAdapter(courseInformation: Course) {
        val adapter = ClassDaysAdapter(courseInformation)
        recyclerViewId.layoutManager = LinearLayoutManager(
            this,
            LinearLayoutManager.HORIZONTAL,
            false
        )
        recyclerViewId.adapter = adapter

    }

    override fun onBlogListRetrieveFailure(errorMessage: String) {
        showToast("Data aren't coming....")
    }
}