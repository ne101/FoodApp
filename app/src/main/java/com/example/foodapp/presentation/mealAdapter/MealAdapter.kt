package com.example.foodapp.presentation.mealAdapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.example.foodapp.databinding.MealCardBinding
import com.example.foodapp.domain.entities.MealEntity

class MealAdapter : ListAdapter<MealEntity, MealViewHolder>(MealDiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MealViewHolder {
        val binding = MealCardBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return MealViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MealViewHolder, position: Int) {
        val binding = holder.binding
        val context = holder.itemView.context
        val mealItem = getItem(position)
        val ingredientList = mutableListOf<String>()
        val dpValue = 5
        val scale: Float = context.resources.displayMetrics.density
        val pxValue = (dpValue * scale + 0.5f).toInt()
        with(binding) {
            with(mealItem) {
                if (strIngredient1 != null && strIngredient1 != "") {
                    ingredientList.add(strIngredient1)
                }
                if (strIngredient2 != null && strIngredient2 != "") {
                    ingredientList.add(strIngredient2)
                }
                if (strIngredient3 != null && strIngredient3 != "") {
                    ingredientList.add(strIngredient3)
                }
                if (strIngredient4 != null && strIngredient4 != "") {
                    ingredientList.add(strIngredient4)
                }
                if (strIngredient5 != null && strIngredient5 != "") {
                    ingredientList.add(strIngredient5)
                }
                if (strIngredient6 != null && strIngredient6 != "") {
                    ingredientList.add(strIngredient6)
                }
                if (strIngredient7 != null && strIngredient7 != "") {
                    ingredientList.add(strIngredient7)
                }
                if (strIngredient8 != null && strIngredient8 != "") {
                    ingredientList.add(strIngredient8)
                }
                if (strIngredient9 != null && strIngredient9 != "") {
                    ingredientList.add(strIngredient9)
                }
                if (strIngredient10 != null && strIngredient10 != "") {
                    ingredientList.add(strIngredient10)
                }
                if (strIngredient11 != null && strIngredient11 != "") {
                    ingredientList.add(strIngredient11)
                }
                if (strIngredient12 != null && strIngredient12 != "") {
                    ingredientList.add(strIngredient12)
                }
                if (strIngredient13 != null && strIngredient13 != "") {
                    ingredientList.add(strIngredient13)
                }
                if (strIngredient14 != null && strIngredient14 != "") {
                    ingredientList.add(strIngredient14)
                }
                if (strIngredient15 != null && strIngredient15 != "") {
                    ingredientList.add(strIngredient15)
                }
                if (strIngredient16 != null && strIngredient16 != "") {
                    ingredientList.add(strIngredient16)
                }
                if (strIngredient17 != null && strIngredient17 != "") {
                    ingredientList.add(strIngredient17)
                }
                if (strIngredient18 != null && strIngredient18 != "") {
                    ingredientList.add(strIngredient18)
                }
                if (strIngredient19 != null && strIngredient19 != "") {
                    ingredientList.add(strIngredient19)
                }
                if (strIngredient20 != null && strIngredient20 != "") {
                    ingredientList.add(strIngredient20)
                }
                tvIngredients.text = ingredientList.joinToString(", ")
                tvStrMeal.text = strMeal
                Glide.with(root).load(strMealThumb).apply(
                    RequestOptions.bitmapTransform(
                        RoundedCorners(pxValue)
                    )
                ).into(ivStrMealThumb)
            }
        }
    }
}