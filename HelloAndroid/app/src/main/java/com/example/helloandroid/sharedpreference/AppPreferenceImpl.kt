package com.example.helloandroid.sharedpreference

import android.content.Context

class AppPreferenceImpl(private val context: Context): AppPreference {

    private val sharedPreferences = context.getSharedPreferences("my_sharedPreference",0)
    private val editor = sharedPreferences.edit()

    override fun getString(key: String): String? {
        return sharedPreferences.getString(key,"Error")
    }

    override fun setString(key: String, value: String) {
        editor.putString(key,value)
        editor.apply()
    }
}