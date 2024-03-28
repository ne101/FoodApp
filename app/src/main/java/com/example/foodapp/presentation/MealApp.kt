package com.example.foodapp.presentation

import android.app.Application
import com.example.foodapp.di.DaggerApplicationComponent

class MealApp : Application() {
    val component by lazy {
        DaggerApplicationComponent.create()
    }
}