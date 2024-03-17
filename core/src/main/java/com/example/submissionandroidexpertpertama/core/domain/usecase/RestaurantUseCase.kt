package com.example.submissionandroidexpertpertama.core.domain.usecase

import com.example.submissionandroidexpertpertama.core.data.Resource
import com.example.submissionandroidexpertpertama.core.domain.model.Restaurant
import kotlinx.coroutines.flow.Flow

interface RestaurantUseCase {

    fun getAllRestaurant(): Flow<Resource<List<Restaurant>>>

    fun getAllFavorite(): Flow<List<Restaurant>>

    fun setFavorite(restaurant : Restaurant, isFavorite : Boolean)
}