package com.example.helloandroid.feature.studentList.presenter

import com.example.helloandroid.feature.studentList.view.StudentView

interface StudentListPresenter {
    fun getStudentList(view : StudentView)
}