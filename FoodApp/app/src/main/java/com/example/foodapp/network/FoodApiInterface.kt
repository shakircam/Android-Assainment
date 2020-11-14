package com.example.foodapp.network

import com.example.foodapp.feature.model.Food
import retrofit2.Call
import retrofit2.http.GET

interface FoodApiInterface {
    @GET("shakircam/FoodApp/master/app/src/main/java/com/example/foodapp/Food_list" )
    fun getFoodList(): Call<MutableList<Food>>
}