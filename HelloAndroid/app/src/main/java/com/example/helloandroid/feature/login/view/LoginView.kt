package com.example.helloandroid.feature.login.view

import com.example.helloandroid.feature.login.model.LoginResponse
import com.example.helloandroid.feature.login.model.UserCredential

interface LoginView {
   // fun progressBarVisibility(isVisible: Boolean)
   // fun onLoginCheck(userCredential:UserCredential)
    fun onSuccess(data:LoginResponse)
    fun onBlogListRetrieveFailure(errorMessage: String)
}