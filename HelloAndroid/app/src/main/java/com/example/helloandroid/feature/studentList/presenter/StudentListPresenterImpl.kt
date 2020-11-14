package com.example.helloandroid.feature.studentList.presenter

import android.content.Context
import com.example.helloandroid.core.DataFetchCallback
import com.example.helloandroid.feature.studentList.model.StudentModelImpl
import com.example.helloandroid.feature.studentList.model.StudentResponse
import com.example.helloandroid.feature.studentList.view.StudentView

class StudentListPresenterImpl(private val context: Context,private val token: String): StudentListPresenter {

private val studentModelImpl = StudentModelImpl(context)

    override fun getStudentList(view: StudentView) {
        view.progressBarVisibility(true)
        studentModelImpl.getStudentList(token,object : DataFetchCallback<StudentResponse> {

            override fun onSuccess(data: StudentResponse) {
                view.progressBarVisibility(false)
                view.onStudentListRetrieveSuccess(data.data as List<StudentResponse.Data>)
            }

            override fun onError(throwable: Throwable) {
                view.progressBarVisibility(false)
                view.onStudentListRetrieveFailure("Error.....")
            }

        })
    }
}