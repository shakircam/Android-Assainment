package com.example.helloandroid.feature.studentList.model

import android.content.Context
import com.example.helloandroid.R
import com.example.helloandroid.core.DataFetchCallback
import com.example.helloandroid.network.CourseApiInterface
import com.example.helloandroid.network.RetrofitClient
import com.example.helloandroid.sharedpreference.AppPreference
import com.example.helloandroid.sharedpreference.AppPreferenceImpl
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class StudentModelImpl(private val context: Context): StudentModel {

    private val apiInterface: CourseApiInterface = RetrofitClient.getClient().create(CourseApiInterface::class.java)



    override fun getStudentList(token: String,callback: DataFetchCallback<StudentResponse>) {

        var appPreference = AppPreferenceImpl(context)
         val token = appPreference.getString(AppPreference.TOKEN)
        appPreference = AppPreferenceImpl(context)

        val call = token.let { it?.let { it1 -> apiInterface.getStudentList(context.getString(R.string.api_key), it1) } }
        call?.enqueue(object : Callback<StudentResponse>  {
            override fun onResponse(
                    call: Call<StudentResponse>,
                    response: Response<StudentResponse>
            ) {
                response.body()?.let { callback.onSuccess(it) }
            }

            override fun onFailure(call: Call<StudentResponse>, t: Throwable) {
                callback.onError(t)
            }
        })
    }


}