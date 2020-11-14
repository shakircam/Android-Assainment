package com.example.helloandroid.feature.Information.view

import com.example.helloandroid.feature.Information.model.Course

interface CourseListView {
    fun progressBarVisibility(isVisible: Boolean)
    fun onBlogListRetrieveSuccess(courseInformation: Course)
    fun onBlogListRetrieveFailure(errorMessage: String)
}