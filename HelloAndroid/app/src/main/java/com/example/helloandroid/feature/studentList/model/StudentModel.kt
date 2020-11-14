package com.example.helloandroid.feature.studentList.model

import com.example.helloandroid.core.DataFetchCallback

interface StudentModel {
    fun getStudentList(token: String,callback: DataFetchCallback<StudentResponse>)

}