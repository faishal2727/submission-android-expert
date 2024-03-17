package com.example.submissionandroidexpertpertama.core.data.source.local

import com.example.submissionandroidexpertpertama.core.data.source.local.entity.RestaurantEntity
import com.example.submissionandroidexpertpertama.core.data.source.local.room.RestaurantDao
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LocalDataSource @Inject constructor (private val restaurantDao : RestaurantDao) {

    fun getAllRestaurant(): Flow<List<RestaurantEntity>> = restaurantDao.getAllRestaurant()

    fun getAllFavorite(): Flow<List<RestaurantEntity>> = restaurantDao.getAllFavorite()

    suspend fun insertResto(restaurant : List<RestaurantEntity>) = restaurantDao.insertResto(restaurant)

    fun updateRestoFavorite(restaurantEntity : RestaurantEntity, isFavorite : Boolean){
        restaurantEntity.isFavorite = isFavorite
        restaurantDao.updateRestaurant(restaurantEntity)
    }
}