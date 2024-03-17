package com.example.submissionandroidexpertpertama.presentation.screen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.example.submissionandroidexpertpertama.databinding.ActivityDetailBinding
import com.example.submissionandroidexpertpertama.presentation.view_model.DetailViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class DetailActivity : AppCompatActivity() {
    private var _binding : ActivityDetailBinding? = null
    private val binding get() = _binding!!

    private val detailViewModel  by viewModels<DetailViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initView()
    }

    private fun initView(){
        val i = intent.getParcelableExtra<com.example.submissionandroidexpertpertama.core.domain.model.Restaurant>("restaurant")
        showDetail(i)
    }

    private fun showDetail(restaurant : com.example.submissionandroidexpertpertama.core.domain.model.Restaurant?) {
        binding.apply {
            if(restaurant != null){
                restoTittle.text = restaurant.name
                tvDescription.text = restaurant.description
                tvDetailCity.text = restaurant.city
                tvDetailRating.text = restaurant.reting.toString()
                Glide.with(root).load("https://restaurant-api.dicoding.dev/images/small/${restaurant.pictureId}").into(restoImage)
                var isFavorite = restaurant.isFavorite
                setStatusFavorite(isFavorite)
                fabFavorite.setOnClickListener {
                    isFavorite = !isFavorite
                    detailViewModel.showDetail(restaurant,isFavorite)
                    setStatusFavorite(isFavorite)
                    if(isFavorite) Toast.makeText(this@DetailActivity, "Success add to favorite", Toast.LENGTH_SHORT).show() else Toast.makeText(this@DetailActivity, "Success remove to favorite", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    private fun setStatusFavorite(statusFavorite: Boolean) {
        if (statusFavorite) {
            binding.fabFavorite.setImageDrawable(ContextCompat.getDrawable(this, com.example.submissionandroidexpertpertama.R.drawable.ic_bookmark_fill))
        } else {
            binding.fabFavorite.setImageDrawable(ContextCompat.getDrawable(this, com.example.submissionandroidexpertpertama.R.drawable.ic_bookmark_outlined))
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}