package com.example.foodapp.di

import com.example.foodapp.presentation.activities.MainActivity
import dagger.Component

@ApplicationScope
@Component(
    modules = [
        DataModule::class,
        ViewModelModule::class
    ]
)
interface ApplicationComponent {
    fun inject(activity: MainActivity)
}