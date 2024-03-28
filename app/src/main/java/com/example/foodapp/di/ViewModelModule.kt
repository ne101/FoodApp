package com.example.foodapp.di

import androidx.lifecycle.ViewModel
import com.example.foodapp.presentation.viewModels.MealViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(MealViewModel::class)
    fun bindMealViewModel(viewModel: MealViewModel): ViewModel
}