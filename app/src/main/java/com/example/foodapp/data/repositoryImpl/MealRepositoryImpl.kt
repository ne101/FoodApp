package com.example.foodapp.data.repositoryImpl

import com.example.foodapp.data.api.ApiService
import com.example.foodapp.data.mapper.Mapper
import com.example.foodapp.domain.entities.CategoryListEntity
import com.example.foodapp.domain.entities.MealListEntity
import com.example.foodapp.domain.repository.MealRepository
import javax.inject.Inject

class MealRepositoryImpl @Inject constructor(
    private val mapper: Mapper,
    private val apiService: ApiService
) : MealRepository {
    override suspend fun getMealList(): MealListEntity {
        val response = apiService.loadMealList()
        return mapper.mapMealListToEntityList(response)
    }

    override suspend fun getCategoryList(): CategoryListEntity {
        val response = apiService.loadCategoryList()
        return mapper.mapCategoryListToEntity(response)
    }
}