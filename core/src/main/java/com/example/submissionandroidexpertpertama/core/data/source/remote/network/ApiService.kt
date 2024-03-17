package com.example.submissionandroidexpertpertama.core.data.source.remote.network

import com.example.submissionandroidexpertpertama.core.data.source.remote.response.ListRestaurantResponse
import retrofit2.http.GET

interface ApiService {

    @GET("list")
    suspend fun getAllMovie(
//        @Query("api_key") query : String = "cd45fc4a5ba70bca58dff50e93884d4f"
    ): ListRestaurantResponse

}