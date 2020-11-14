package com.example.foodapp.feature.presenter

import com.example.foodapp.feature.model.Food
import com.example.foodapp.feature.model.FoodListCallBack
import com.example.foodapp.feature.model.FoodListModel
import com.example.foodapp.feature.model.FoodListModelImp
import com.example.foodapp.feature.view.FoodListView
import com.example.foodapp.feature.view.MainActivity

class FoodListPresenterImpl(private val view: FoodListView): FoodListPresenter {
    
    private val model : FoodListModel = FoodListModelImp()
    override fun getFoodList() {
        view.progressBarVisibility(true)

        model.getFoodList(object : FoodListCallBack {
            override fun onSuccess(foodList: MutableList<Food>) {
                view.progressBarVisibility(false)
                view.onFoodListRetrieveSuccess(foodList)
            }

            override fun onError(throwable: Throwable) {
                view.progressBarVisibility(false)
                if (throwable.localizedMessage != null)
                    view.onFoodListRetrieveFailure(throwable.localizedMessage!!)
                else
                    view.onFoodListRetrieveFailure("Data aren't arrive....")
            }

        })
    }
}