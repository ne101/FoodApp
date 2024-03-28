package com.example.foodapp.presentation.mealAdapter

import androidx.recyclerview.widget.DiffUtil
import com.example.foodapp.domain.entities.MealEntity

class MealDiffCallback : DiffUtil.ItemCallback<MealEntity>() {
    override fun areItemsTheSame(oldItem: MealEntity, newItem: MealEntity): Boolean {
        return oldItem.idMeal == newItem.idMeal
    }

    override fun areContentsTheSame(oldItem: MealEntity, newItem: MealEntity): Boolean {
        return oldItem == newItem
    }
}