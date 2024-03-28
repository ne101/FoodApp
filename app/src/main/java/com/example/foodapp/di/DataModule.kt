package com.example.foodapp.di

import com.example.foodapp.data.api.ApiFactory
import com.example.foodapp.data.api.ApiService
import com.example.foodapp.data.repositoryImpl.MealRepositoryImpl
import com.example.foodapp.domain.repository.MealRepository
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
interface DataModule {
    @ApplicationScope
    @Binds
    fun bindRepositoryImpl(impl: MealRepositoryImpl): MealRepository

    companion object {
        @ApplicationScope
        @Provides
        fun provideApiService(): ApiService = ApiFactory.apiService
    }
}