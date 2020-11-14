package com.example.helloandroid.feature.Information.presenter

import com.example.helloandroid.feature.Information.model.Course
import com.example.helloandroid.feature.Information.model.CourseInformationCallBack
import com.example.helloandroid.feature.Information.model.CourseInformationModel
import com.example.helloandroid.feature.Information.model.CourseInformationModelImpl
import com.example.helloandroid.feature.Information.view.CourseListView

class CourseInformationPresenterImpl(private val view : CourseListView) : CourseInformationPresenter {
    private val model : CourseInformationModel = CourseInformationModelImpl()

    override fun getCourseList() {
        view.progressBarVisibility(true)
        model.getCourseList(object : CourseInformationCallBack {
            override fun onSuccess(courseInformation: Course) {
                view.progressBarVisibility(false)
                view.onBlogListRetrieveSuccess(courseInformation)
            }

            override fun onError(throwable: Throwable) {
                view.progressBarVisibility(false)
                if (throwable.localizedMessage != null)
                view.onBlogListRetrieveFailure(throwable.localizedMessage)
                else
                    view.onBlogListRetrieveFailure("Data aren't arrived......")
            }

        })
    }
}