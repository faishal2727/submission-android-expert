package com.example.submissionandroidexpertpertama.presentation.screen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.example.submissionandroidexpertpertama.core.adapter.RestaurantAdapter
import com.example.submissionandroidexpertpertama.core.domain.model.Restaurant
import com.example.submissionandroidexpertpertama.di.DaggerFavoriteComponent
import com.example.submissionandroidexpertpertama.presentation.di.FavoriteModuleDependencies
import com.example.submissionandroidexpertpertama.presentation.state.FavoriteViewModel
import com.example.submissionandroidexpertpertama.presentation.state.ViewModelFactory
import dagger.hilt.android.EntryPointAccessors
import javax.inject.Inject


class FavoriteActivity : AppCompatActivity() {
    private var _binding : ActivityFavoriteBinding? = null
    private val binding get() = _binding!!
    private lateinit var movieAdapter : RestaurantAdapter

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private  val  favoriteViewModel : FavoriteViewModel by viewModels{
        viewModelFactory
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        DaggerFavoriteComponent.builder()
            .context(this)
            .appDependencies(
                EntryPointAccessors.fromApplication(applicationContext,
                FavoriteModuleDependencies::class.java))
            .build()
            .inject(this)

        super.onCreate(savedInstanceState)
        _binding = ActivityFavoriteBinding.inflate(layoutInflater)
        setContentView(binding.root)


        showFavorite()
    }


    private fun setRecycler(data : List<Restaurant>){
        movieAdapter = RestaurantAdapter(object : RestaurantAdapter.OnClick{
            override fun onDetail(movie: Restaurant) {
                startActivity(Intent(this@FavoriteActivity, DetailActivity::class.java).also{
                    it.putExtra("movie",movie)
                })
            }
        })

        movieAdapter.submit(data)

        binding.rvMovie.apply {
            adapter = movieAdapter
            layoutManager = GridLayoutManager(this@FavoriteActivity,2)
        }
    }

    private fun showFavorite(){
        favoriteViewModel.getAllFavorite().observe(this){
            setRecycler(it)
        }
    }


}