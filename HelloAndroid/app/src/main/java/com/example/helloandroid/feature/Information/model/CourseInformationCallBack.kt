package com.example.helloandroid.feature.Information.model

interface CourseInformationCallBack {
    fun onSuccess(courseInformation: Course)
    fun onError(throwable: Throwable)
}