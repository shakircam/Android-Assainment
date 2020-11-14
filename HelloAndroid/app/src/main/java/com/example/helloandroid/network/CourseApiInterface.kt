package com.example.helloandroid.network

import com.example.helloandroid.feature.Information.model.Course
import com.example.helloandroid.feature.login.model.LoginResponse
import com.example.helloandroid.feature.login.model.UserCredential
import com.example.helloandroid.feature.studentList.model.StudentResponse
import retrofit2.Call
import retrofit2.http.*

interface CourseApiInterface {

    @GET("course_info.php")
    fun getCourseList(): Call<Course>

    @POST("login.php")
    fun login(@Body userCredential: UserCredential, @Header("api_key") apiKey:String): Call<LoginResponse>

    @GET("student.php")
    fun getStudentList(@Header("api_key")apiKey: String,@Header("token") token: String): Call<StudentResponse>

    @GET("student.php")
    fun getSingleStudent(@Header("api_key") apiKey: String, @Header("token") token: String, @Query("id") id: Int) : Call<StudentResponse>
}