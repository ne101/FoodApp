package com.example.foodapp.presentation.activities

import android.content.Context
import android.net.ConnectivityManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.foodapp.databinding.ActivityMainBinding
import com.example.foodapp.presentation.MealApp
import com.example.foodapp.presentation.categoryAdapter.CategoryAdapter
import com.example.foodapp.presentation.categoryAdapter.OnClickListener
import com.example.foodapp.presentation.mealAdapter.MealAdapter
import com.example.foodapp.presentation.viewModels.MealViewModel
import com.example.foodapp.presentation.viewModels.ViewModelFactory
import javax.inject.Inject

class MainActivity : AppCompatActivity(), OnClickListener {

    private lateinit var binding: ActivityMainBinding

    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    private lateinit var viewModel: MealViewModel

    private val component by lazy {
        (application as MealApp).component
    }
    private val mealAdapter = MealAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        component.inject(this)
        viewModel = ViewModelProvider(this, viewModelFactory)[MealViewModel::class.java]
        binding.rvMealAdapter.adapter = mealAdapter
        binding.rvMealAdapter.layoutManager = GridLayoutManager(this, 1)
        val categoryAdapter = CategoryAdapter(this)
        binding.rvCategoryAdapter.adapter = categoryAdapter
        binding.rvCategoryAdapter.layoutManager = LinearLayoutManager(
            this,
            LinearLayoutManager.HORIZONTAL,
            false
        )
        showMealList(mealAdapter)
        showCategoryList(categoryAdapter)
    }

    private fun showMealList(adapter: MealAdapter) {
        if (isNetworkAvailable(this)) {
            viewModel.loadMealList()
            viewModel.mealList.observe(this) {
                adapter.submitList(it.meals)
            }
        } else {
            Toast.makeText(this, "Проверьте интернет соединение!", Toast.LENGTH_SHORT).show()
        }

    }

    private fun isNetworkAvailable(context: Context): Boolean {
        val connectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo = connectivityManager.activeNetworkInfo
        return networkInfo != null && networkInfo.isConnected
    }

    private fun showCategoryList(adapter: CategoryAdapter) {
        if (isNetworkAvailable(this)) {
            viewModel.loadCategoryList()
            viewModel.categoryList.observe(this) {
                adapter.submitList(it.categories)
            }
        } else {
            Toast.makeText(this, "Проверьте интернет соединение!", Toast.LENGTH_SHORT).show()
        }

    }

    override fun onClickCategory(category: String) {

        viewModel.sortMealByCategory(category)
        viewModel.sortedMealList.observe(this) {
            mealAdapter.submitList(it)
        }
    }

    override fun resetMealList() {
        viewModel.mealList.observe(this) {
            mealAdapter.submitList(it.meals)
        }
    }
}