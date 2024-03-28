package com.example.foodapp.domain.repository

import com.example.foodapp.domain.entities.CategoryListEntity
import com.example.foodapp.domain.entities.MealListEntity

interface MealRepository {

    suspend fun getMealList(): MealListEntity
    suspend fun getCategoryList(): CategoryListEntity

}