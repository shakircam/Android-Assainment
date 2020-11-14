package com.example.helloandroid.feature.studentDetails.presenter

import com.example.helloandroid.feature.studentDetails.view.StudentInfoView


interface StudentInfoPresenter {
    fun getSingleStudent(view : StudentInfoView)
}