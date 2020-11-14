package com.example.foodapp.feature.model

interface FoodListCallBack {
    fun onSuccess(foodList: MutableList<Food>)
    fun onError(throwable: Throwable)
}