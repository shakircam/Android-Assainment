package com.example.helloandroid.feature.Information.model

import java.io.Serializable

data class Course(
        val status : Boolean,
        val message: String,
        val data : Data
): Serializable {
    data class Data(
            val name : String,
            val duration : String,
            val number_of_class : Int,
            val class_duration : String,
            val fee : String,
            val url : String,
            val class_days : MutableList<String>
    )
}