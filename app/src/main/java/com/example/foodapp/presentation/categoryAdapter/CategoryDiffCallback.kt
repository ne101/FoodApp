package com.example.foodapp.presentation.categoryAdapter

import androidx.recyclerview.widget.DiffUtil
import com.example.foodapp.domain.entities.CategoryEntity

class CategoryDiffCallback : DiffUtil.ItemCallback<CategoryEntity>() {
    override fun areItemsTheSame(oldItem: CategoryEntity, newItem: CategoryEntity): Boolean {
        return oldItem.idCategory == newItem.idCategory
    }

    override fun areContentsTheSame(oldItem: CategoryEntity, newItem: CategoryEntity): Boolean {
        return oldItem == newItem
    }
}