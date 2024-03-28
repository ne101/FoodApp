package com.example.foodapp.domain.usecases

import com.example.foodapp.domain.entities.MealListEntity
import com.example.foodapp.domain.repository.MealRepository
import javax.inject.Inject

class GetMealListUseCase @Inject constructor(private val repository: MealRepository) {
    suspend operator fun invoke(): MealListEntity {
        return repository.getMealList()
    }
}