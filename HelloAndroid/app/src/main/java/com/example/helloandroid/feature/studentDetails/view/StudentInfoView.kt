package com.example.helloandroid.feature.studentDetails.view

import com.example.helloandroid.feature.studentList.model.StudentResponse

interface StudentInfoView {
    fun progressBarVisibility(isVisible: Boolean)
    fun onStudentListRetrieveSuccess(studentResponse: List<StudentResponse.Data>)
    fun onStudentListRetrieveFailure(errorMessage: String)
}