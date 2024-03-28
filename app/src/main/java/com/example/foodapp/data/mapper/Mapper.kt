package com.example.foodapp.data.mapper

import com.example.foodapp.data.model.Category
import com.example.foodapp.data.model.CategoryResponse
import com.example.foodapp.data.model.Meal
import com.example.foodapp.data.model.MealResponse
import com.example.foodapp.domain.entities.CategoryEntity
import com.example.foodapp.domain.entities.CategoryListEntity
import com.example.foodapp.domain.entities.MealEntity
import com.example.foodapp.domain.entities.MealListEntity
import javax.inject.Inject

class Mapper @Inject constructor(){

    private fun mapMealToEntity(meal: Meal): MealEntity = MealEntity(
        strCategory = meal.strCategory,
        strIngredient1 = meal.strIngredient1,
        strIngredient2 = meal.strIngredient2,
        strIngredient3 = meal.strIngredient3,
        strIngredient4 = meal.strIngredient4,
        strIngredient5 = meal.strIngredient5,
        strIngredient6 = meal.strIngredient6,
        strIngredient7 = meal.strIngredient7,
        strIngredient8 = meal.strIngredient8,
        strIngredient9 = meal.strIngredient9,
        strIngredient10 = meal.strIngredient10,
        strIngredient11 = meal.strIngredient11,
        strIngredient12 = meal.strIngredient12,
        strIngredient13 = meal.strIngredient13,
        strIngredient14 = meal.strIngredient14,
        strIngredient15 = meal.strIngredient15,
        strIngredient16 = meal.strIngredient16,
        strIngredient17 = meal.strIngredient17,
        strIngredient18 = meal.strIngredient18,
        strIngredient19 = meal.strIngredient19,
        strIngredient20 = meal.strIngredient20,
        strMeal = meal.strMeal,
        strMealThumb = meal.strMealThumb,
        idMeal = meal.idMeal
    )

    private fun mapCategoryToEntity(category: Category): CategoryEntity = CategoryEntity(
        strCategory = category.strCategory,
        idCategory = category.idCategory
    )

    fun mapMealListToEntityList(mealResponse: MealResponse): MealListEntity = MealListEntity(
        meals = mealResponse.meals.map { mapMealToEntity(it) }
    )

    fun mapCategoryListToEntity(categoryResponse: CategoryResponse): CategoryListEntity = CategoryListEntity(
        categories = categoryResponse.categories.map { mapCategoryToEntity(it) }
    )

}