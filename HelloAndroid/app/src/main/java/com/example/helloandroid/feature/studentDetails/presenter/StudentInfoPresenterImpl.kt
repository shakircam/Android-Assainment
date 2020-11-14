package com.example.helloandroid.feature.studentDetails.presenter

import android.content.Context
import com.example.helloandroid.core.DataFetchCallback
import com.example.helloandroid.feature.studentDetails.model.StudentInfoModelImpl
import com.example.helloandroid.feature.studentDetails.view.StudentInfoView
import com.example.helloandroid.feature.studentList.model.StudentResponse

class StudentInfoPresenterImpl(private val context: Context,private val id : Int,private val token: String):StudentInfoPresenter {
    private val studentInfoModelImpl = StudentInfoModelImpl(context)

    override fun getSingleStudent(view: StudentInfoView) {
        view.progressBarVisibility(true)
        studentInfoModelImpl.getSingleStudent(id, token, object : DataFetchCallback<StudentResponse> {
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