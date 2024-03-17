package com.example.submissionandroidexpertpertama.core.domain.usecase.impl

import android.annotation.SuppressLint
import com.example.submissionandroidexpertpertama.core.data.Resource
import com.example.submissionandroidexpertpertama.core.domain.model.Restaurant
import com.example.submissionandroidexpertpertama.core.domain.repositories.IRestaurantRepository
import com.example.submissionandroidexpertpertama.core.domain.usecase.RestaurantUseCase
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@SuppressLint("all")
class RestaurantUseCaseImpl @Inject constructor(private val iRestaurantRepository: IRestaurantRepository):
    RestaurantUseCase {

    override fun getAllRestaurant(): Flow<Resource<List<Restaurant>>> {
        return  iRestaurantRepository.getAllRestaurant()
    }

    override fun getAllFavorite(): Flow<List<Restaurant>> {
        return iRestaurantRepository.getAllFavorite()
    }

    override fun setFavorite(restaurant: Restaurant, isFavorite: Boolean) {
        return iRestaurantRepository.setFavorite(restaurant, isFavorite)
    }
}