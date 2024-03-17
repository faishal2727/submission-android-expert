package com.example.submissionandroidexpertpertama.presentation.screen

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.submissionandroidexpertpertama.core.adapter.RestaurantAdapter
import com.example.submissionandroidexpertpertama.core.data.Resource
import com.example.submissionandroidexpertpertama.core.domain.model.Restaurant
import com.example.submissionandroidexpertpertama.databinding.ActivityHomeBinding
import com.example.submissionandroidexpertpertama.presentation.view_model.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class HomeActivity : AppCompatActivity() {
    private var _binding : ActivityHomeBinding? = null
    private val binding get() = _binding!!
    private lateinit var resturantAdapter: RestaurantAdapter
    private val homeViewModel by viewModels<HomeViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        showData()
        moveToFavorite()
    }


    private fun showData(){
        homeViewModel.getAllRestaurant().observe(this){
            when(it){
                is Resource.Success -> {
                    it.data?.let { restaurant -> setRecycler(restaurant) }
                }
                is Resource.Error -> {
                    Toast.makeText(this, "${it.message}", Toast.LENGTH_SHORT).show()
                }

                is Resource.Loading -> {
                    Toast.makeText(this, "Loading", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    private fun setRecycler(data : List<Restaurant>){
        resturantAdapter = RestaurantAdapter(object : RestaurantAdapter.OnClick{
            override fun onDetail(restaurant: Restaurant) {
                startActivity(Intent(this@HomeActivity, DetailActivity::class.java).also {
                    it.putExtra("restaurant",restaurant)
                })
            }

        })

        resturantAdapter.submit(data)
        binding.rvResto.apply {
            adapter = resturantAdapter
            layoutManager = LinearLayoutManager(this@HomeActivity)
        }
    }

    private fun moveToFavorite(){
        binding.fabFavorite.setOnClickListener {
            val uri = Uri.parse("submissionandroidexpertpertama://paporit")
            startActivity(Intent(Intent.ACTION_VIEW, uri))
        }

    }
}