package com.example.submissionandroidexpertpertama.core.domain.repositories

import com.example.submissionandroidexpertpertama.core.domain.model.Restaurant
import kotlinx.coroutines.flow.Flow

interface IRestaurantRepository {

    fun getAllRestaurant(): Flow<com.example.submissionandroidexpertpertama.core.data.Resource<List<Restaurant>>>

    fun getAllFavorite(): Flow<List<Restaurant>>

    fun setFavorite(restaurant : Restaurant, isFavorite : Boolean)
}