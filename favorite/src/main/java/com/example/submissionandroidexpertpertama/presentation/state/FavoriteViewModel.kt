package com.example.submissionandroidexpertpertama.presentation.state


import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.submissionandroidexpertpertama.core.domain.usecase.RestaurantUseCase

class FavoriteViewModel(
    private val restaurantUseCase: RestaurantUseCase
):ViewModel() {

    fun getAllFavorite() = restaurantUseCase.getAllFavorite().asLiveData()
}