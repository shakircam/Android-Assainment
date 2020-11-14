package com.example.helloandroid.feature.login.model

import android.content.Context
import com.example.helloandroid.R
import com.example.helloandroid.core.DataFetchCallback
import com.example.helloandroid.network.CourseApiInterface
import com.example.helloandroid.network.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AuthModelImpl(private val context: Context):AuthModel {

    private val apiInterface: CourseApiInterface = RetrofitClient.getClient().create(CourseApiInterface::class.java)

    override fun login(userCredential: UserCredential, callback: DataFetchCallback<LoginResponse>) {
        val apiKey = context.getString(R.string.api_key)
        val call = apiInterface.login(userCredential,apiKey)

        call.enqueue(object : Callback<LoginResponse> {
            override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
                response.body()?.let { callback.onSuccess(it) }
            }

            override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                callback.onError(t)
            }
        })
    }
}