package com.example.submissionandroidexpertpertama.presentation.view_model

import androidx.lifecycle.ViewModel
import com.example.submissionandroidexpertpertama.core.domain.model.Restaurant
import com.example.submissionandroidexpertpertama.core.domain.usecase.RestaurantUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val  restaurantUseCase: RestaurantUseCase
): ViewModel() {

    fun showDetail(restaurant : Restaurant, isFavorite: Boolean){
        restaurantUseCase.setFavorite(restaurant,isFavorite)
    }

}