package com.example.helloandroid.feature.studentList.view

import com.example.helloandroid.feature.studentList.model.StudentResponse

interface StudentView {
    fun progressBarVisibility(isVisible: Boolean)
    fun onStudentListRetrieveSuccess(data: List<StudentResponse.Data>)
    fun onStudentListRetrieveFailure(errorMessage: String)
}