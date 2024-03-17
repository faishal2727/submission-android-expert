package com.example.submissionandroidexpertpertama.core.data.source.local.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.submissionandroidexpertpertama.core.data.source.local.entity.RestaurantEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface RestaurantDao {

    @Query("SELECT * FROM restaurant")
    fun getAllRestaurant(): Flow<List<RestaurantEntity>>

    @Query("SELECT * FROM restaurant WHERE isFavorite = 1")
    fun getAllFavorite(): Flow<List<RestaurantEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertResto(restaurants : List<RestaurantEntity>)

    @Update
    fun updateRestaurant(restaurantEntity: RestaurantEntity)

}