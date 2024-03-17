package com.example.submissionandroidexpertpertama.core.data.source.remote

import android.annotation.SuppressLint
import com.example.submissionandroidexpertpertama.core.data.source.remote.network.ApiResponse
import com.example.submissionandroidexpertpertama.core.data.source.remote.network.ApiService
import com.example.submissionandroidexpertpertama.core.data.source.remote.response.RestaurantResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RemoteDataSource  @Inject constructor(private val apiService : ApiService){

    @SuppressLint("all")
    fun getAllRestaurant(): Flow<ApiResponse<List<RestaurantResponse>>> = flow {
        try {
            val response = apiService.getAllMovie()
            val data = response.restaurants
            if(data.isNotEmpty()){
                emit(ApiResponse.Success(data))
            }else{
                emit(ApiResponse.Empty)
            }

        }catch (e : Exception){
            emit(ApiResponse.Error(e.message.toString()))
        }
    }.flowOn(Dispatchers.IO)
}