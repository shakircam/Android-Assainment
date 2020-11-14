package com.example.assinmentfour.DataModel

interface AppPreference {

    companion object{
        const val NAME = "name"
        const val AGE = "age"
        const val WEIGHT = "weight"
        const val GENDER = "gender"
        const val URL = "url"
        const val NOTIFICATION = "notification"
    }

    fun getString(key:String):String ?
    fun setString(key:String,value:String)

    fun getInt(key:String):Int ?
    fun setInt(key:String,value:Int)

    fun getFloat(key:String):Float ?
    fun setFloat(key:String,value:Float)

    fun getBoolean(key:String):Boolean ?
    fun setBoolean(key:String,value:Boolean)

}