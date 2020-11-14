package com.example.helloandroid.feature.studentDetails.model

import com.example.helloandroid.core.DataFetchCallback
import com.example.helloandroid.feature.studentList.model.StudentResponse

interface StudentInfoModel {
   fun getSingleStudent(id : Int, token: String,callback: DataFetchCallback<StudentResponse>)
}