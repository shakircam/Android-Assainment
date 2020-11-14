package com.example.foodapp.feature.view

import com.example.foodapp.feature.model.Food

interface FoodListView {
    fun progressBarVisibility(isVisible: Boolean)
    fun onFoodListRetrieveSuccess(foodList: MutableList<Food>)
    fun onFoodListRetrieveFailure(errorMessage: String)
}