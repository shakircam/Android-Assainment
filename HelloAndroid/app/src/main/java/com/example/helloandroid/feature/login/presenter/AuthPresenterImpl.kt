package com.example.helloandroid.feature.login.presenter

import android.content.Context
import com.example.helloandroid.core.DataFetchCallback
import com.example.helloandroid.feature.login.model.AuthModel
import com.example.helloandroid.feature.login.model.AuthModelImpl
import com.example.helloandroid.feature.login.model.LoginResponse
import com.example.helloandroid.feature.login.model.UserCredential
import com.example.helloandroid.feature.login.view.LoginView

class AuthPresenterImpl(private val context: Context,
        private val view: LoginView,
        private val userCredential: UserCredential,
        private val apiKey : String,
        private val dataFetchCallback: DataFetchCallback<LoginResponse>)
    :AuthPresenter {

    private val model : AuthModel  = AuthModelImpl(context)

    override fun login() {
        model.login(userCredential, object : DataFetchCallback<LoginResponse> {
            override fun onSuccess(data: LoginResponse) {
                dataFetchCallback.onSuccess(data)
            }

            override fun onError(throwable: Throwable) {
                dataFetchCallback.onError(throwable)
            }

        })
    }
}