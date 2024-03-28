package com.example.foodapp.data.model

import com.google.gson.annotations.SerializedName

data class Category(
    @SerializedName("idCategory")
    val idCategory: Int,
    @SerializedName("strCategory")
    val strCategory: String
)