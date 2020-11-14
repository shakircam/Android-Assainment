package com.example.foodapp.feature.adapterClass

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.foodapp.R
import com.example.foodapp.feature.model.Food
import com.example.foodapp.feature.view.ItemClickListener

class FoodListAdapter(private val foodList: MutableList<Food>, private val itemClickListener: ItemClickListener):RecyclerView.Adapter<FoodViewHolder>() {
    private lateinit var context :Context
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodViewHolder {
        context = parent.context
        val view = LayoutInflater.from(context).inflate(R.layout.item_food,parent,false)
        return FoodViewHolder(view)
    }

    override fun onBindViewHolder(holder: FoodViewHolder, position: Int) {
        val food = foodList[position]
        Glide.with(holder.foodItem)
                .load(food.imageUrl)
                .into(holder.foodItem)
        holder.foodName.text= food.name
        holder.priceValue.text= holder.itemView.context.getString(R.string.price_format,food.price)
        val favorite = if (food.isFavorite)
            R.drawable.favorite
        else
            R.drawable.favorite_no
        holder.favoriteItem.setImageDrawable(ContextCompat.getDrawable(context,favorite))

        holder.itemView.setOnClickListener { itemClickListener.onItemClick(position) }
    }

    override fun getItemCount(): Int {
        return foodList.size
    }
}