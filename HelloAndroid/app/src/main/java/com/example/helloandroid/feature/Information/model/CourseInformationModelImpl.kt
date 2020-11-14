package com.example.helloandroid.feature.Information.model

import com.example.helloandroid.network.CourseApiInterface
import com.example.helloandroid.network.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CourseInformationModelImpl : CourseInformationModel {

    private val apiInterface: CourseApiInterface = RetrofitClient.getClient().create(CourseApiInterface::class.java)
    private val call : Call<Course> = apiInterface.getCourseList()

    override fun getCourseList(courseInformationCallBack: CourseInformationCallBack) {
        call.enqueue(object : Callback<Course> {
            override fun onResponse(call: Call<Course>, response: Response<Course>) {
                response.body()?.let { courseInformationCallBack.onSuccess(it) }
            }

            override fun onFailure(call: Call<Course>, t: Throwable) {
                courseInformationCallBack.onError(t)
            }

        })
    }
}