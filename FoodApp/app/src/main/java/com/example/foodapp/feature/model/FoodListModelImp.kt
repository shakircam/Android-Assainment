package com.example.foodapp.feature.model

import com.example.foodapp.network.FoodApiInterface
import com.example.foodapp.network.RetrofitClient
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Call


class FoodListModelImp : FoodListModel {
    private val apiInterface = RetrofitClient.getClient().create(FoodApiInterface::class.java)
    private val call = apiInterface.getFoodList()

    override fun getFoodList(foodListCallback: FoodListCallBack) {
        call.enqueue(object: Callback<MutableList<Food>>{

            override fun onResponse(
                call: Call<MutableList<Food>>,
                response: Response<MutableList<Food>>)
            {
                response.body()?.let {
                    foodListCallback.onSuccess(it)
                }
            }

            override fun onFailure(call: Call<MutableList<Food>>, t: Throwable) {
               foodListCallback.onError(t)
            }
        })
    }
}



