package com.example.foodapp.feature.adapterClass

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_food.view.*

class FoodViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val foodItem : ImageView = itemView.iv_food_item
    val foodName: TextView = itemView.tv_foodName
    val  priceValue : TextView = itemView.tv_priceValue
    val favoriteItem : ImageView = itemView.iv_favoriteItem

}
