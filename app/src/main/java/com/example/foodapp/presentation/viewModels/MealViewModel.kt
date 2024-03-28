package com.example.foodapp.presentation.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.foodapp.domain.entities.CategoryListEntity
import com.example.foodapp.domain.entities.MealEntity
import com.example.foodapp.domain.entities.MealListEntity
import com.example.foodapp.domain.usecases.GetCategoryListUseCase
import com.example.foodapp.domain.usecases.GetMealListUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class MealViewModel @Inject constructor(
    private val getMealListUseCase: GetMealListUseCase,
    private val getCategoryListUseCase: GetCategoryListUseCase
) : ViewModel() {
    private val _mealList = MutableLiveData<MealListEntity>()
    val mealList: LiveData<MealListEntity>
        get() = _mealList

    private val _categoryList = MutableLiveData<CategoryListEntity>()
    val categoryList: LiveData<CategoryListEntity>
        get() = _categoryList

    private val _sortedMealList = MutableLiveData<List<MealEntity>>()
    val sortedMealList: LiveData<List<MealEntity>>
        get() = _sortedMealList

    fun loadMealList() {
        viewModelScope.launch(Dispatchers.IO) {
            _mealList.postValue(getMealListUseCase.invoke())
        }
    }

    fun loadCategoryList() {
        viewModelScope.launch(Dispatchers.IO) {
            _categoryList.postValue(getCategoryListUseCase.invoke())
        }
    }

    fun sortMealByCategory(category: String) {
        val sortedList = _mealList.value?.meals?.filter {
            it.strCategory == category
        }
        _sortedMealList.value = sortedList
    }
}