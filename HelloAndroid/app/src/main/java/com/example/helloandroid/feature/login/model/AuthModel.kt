package com.example.helloandroid.feature.login.model

import com.example.helloandroid.core.DataFetchCallback

interface AuthModel {
    fun login(userCredential: UserCredential, callback: DataFetchCallback<LoginResponse>)
}