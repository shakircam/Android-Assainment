package com.example.foodapp.feature.view

import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.foodapp.R
import com.example.foodapp.core.BaseActivity
import com.example.foodapp.feature.adapterClass.FoodListAdapter
import com.example.foodapp.feature.model.Food
import com.example.foodapp.feature.presenter.FoodListPresenter
import com.example.foodapp.feature.presenter.FoodListPresenterImpl
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.toolbar.*


class MainActivity : BaseActivity(),FoodListView {
    override fun setLayoutId(): Int {
       return R.layout.activity_main
    }

    override fun setToolbar(): Toolbar {
        toolbar.title = getString(R.string.title_food_list)
        return toolbar
    }

    override val isHomeUpButtonEnable: Boolean get()= false


private lateinit var presenter : FoodListPresenter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        presenter = FoodListPresenterImpl(this)
        presenter.getFoodList()

    }
    
    override fun progressBarVisibility(isVisible: Boolean) {

        if (isVisible)
            progress.visibility = View.VISIBLE
        else
            progress.visibility = View.GONE
    }

    override fun onFoodListRetrieveSuccess(foodList: MutableList<Food>) {

       initAdapter(foodList)
    }

    private fun initAdapter(foodList: MutableList<Food>) {
        val adapter = FoodListAdapter(foodList, object : ItemClickListener {
            override fun onItemClick(position: Int) {
                showToast("item is Clicked.....")
            }

        })
        recyclerViewId.layoutManager= LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        recyclerViewId.adapter = adapter

    }


    override fun onFoodListRetrieveFailure(errorMessage: String) {
        showToast(errorMessage)
    }

}