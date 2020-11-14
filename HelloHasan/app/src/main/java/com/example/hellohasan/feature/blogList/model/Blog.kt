package com.example.hellohasan.feature.blogList.model

import java.io.Serializable

data class Blog(
        val id : Int,
        val title : Title,
        var date : String,
        val jetpack_featured_media_url : String,
        val content: Description


):Serializable{
    data class Title(val rendered : String )
    data class Description (val rendered : String)
}



