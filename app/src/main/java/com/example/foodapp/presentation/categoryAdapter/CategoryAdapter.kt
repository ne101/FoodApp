package com.example.foodapp.presentation.categoryAdapter

import android.graphics.Color
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.ListAdapter
import com.example.foodapp.databinding.CategoryCardBinding
import com.example.foodapp.domain.entities.CategoryEntity


interface OnClickListener {
    fun onClickCategory(category: String)
    fun resetMealList()
}

class CategoryAdapter(val clickListener: OnClickListener) : ListAdapter<CategoryEntity, CategoryViewHolder>(CategoryDiffCallback()) {
   private var selectedPosition = -1
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val binding = CategoryCardBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return CategoryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        val binding = holder.binding
        val category = getItem(position)
        with(binding) {
            with(category) {
                tvCategory.text = strCategory
                if (position == selectedPosition) {
                    tvCategory.setTextColor(Color.RED)
                    tvCategory.setBackgroundColor(Color.parseColor("#fadadd"))
                } else {
                    tvCategory.setTextColor(Color.parseColor("#717171"))
                    tvCategory.setBackgroundColor(Color.WHITE)
                }
                root.setOnClickListener {
                    val previousSelectedPosition = selectedPosition
                    selectedPosition = if (selectedPosition == holder.adapterPosition) {
                        -1
                    } else {
                        holder.adapterPosition
                    }
                    notifyItemChanged(previousSelectedPosition)
                    if (selectedPosition != -1) {
                        notifyItemChanged(selectedPosition)
                        clickListener.onClickCategory(category.strCategory)
                    } else {
                        clickListener.resetMealList()
                    }

                }
            }
        }
    }
}