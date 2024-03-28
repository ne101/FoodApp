package com.example.foodapp.data.api

import com.example.foodapp.data.model.CategoryResponse
import com.example.foodapp.data.model.MealResponse
import retrofit2.http.GET

interface ApiService {
    @GET("categories.php")
    suspend fun loadCategoryList(): CategoryResponse
    @GET("search.php?s")
    suspend fun loadMealList(): MealResponse
}