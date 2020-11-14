package com.example.helloandroid.feature.login.model

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName
@Keep
data class LoginResponse (
        @SerializedName("message")
        val message: String?,
        @SerializedName("status")
        val status: Boolean?,
        @SerializedName("token")
        val token: String?
)