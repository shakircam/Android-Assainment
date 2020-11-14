package com.example.helloandroid.sharedpreference

interface AppPreference {
    companion object{
        const val TOKEN = "token"
    }

    fun getString(key:String):String ?
    fun setString(key:String,value:String)

}