package com.example.foodapp.domain.usecases

import com.example.foodapp.domain.entities.CategoryListEntity
import com.example.foodapp.domain.repository.MealRepository
import javax.inject.Inject

class GetCategoryListUseCase @Inject constructor(private val repository: MealRepository) {
    suspend operator fun invoke(): CategoryListEntity {
        return repository.getCategoryList()
    }
}