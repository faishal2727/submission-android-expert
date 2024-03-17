package com.example.submissionandroidexpertpertama.core.data

import com.example.submissionandroidexpertpertama.core.utils.AppExecutors
import com.example.submissionandroidexpertpertama.core.utils.DataMapper
import com.example.submissionandroidexpertpertama.core.data.source.local.LocalDataSource
import com.example.submissionandroidexpertpertama.core.data.source.remote.RemoteDataSource
import com.example.submissionandroidexpertpertama.core.data.source.remote.network.ApiResponse
import com.example.submissionandroidexpertpertama.core.data.source.remote.response.RestaurantResponse
import com.example.submissionandroidexpertpertama.core.domain.model.Restaurant
import com.example.submissionandroidexpertpertama.core.domain.repositories.IRestaurantRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton


@Suppress("VerboseNullabilityAndEmptiness")
@Singleton
class RestaurantRepository @Inject constructor(
    val localDataSource: LocalDataSource,
    val remoteDataSource: RemoteDataSource,
    private val appExecutors : AppExecutors
): IRestaurantRepository {

    override fun getAllRestaurant(): Flow<Resource<List<Restaurant>>> {
        return object : NetworkBoundResource<List<Restaurant>, List<RestaurantResponse>>() {
            override fun loadFromDB(): Flow<List<Restaurant>> {
                return localDataSource.getAllRestaurant().map {
                    DataMapper.mapFromEntitiesToDomain(it)
                }
            }

            override suspend fun createCall(): Flow<ApiResponse<List<RestaurantResponse>>> {
                return remoteDataSource.getAllRestaurant()
            }

            override suspend fun saveCallResult(data: List<RestaurantResponse>) {
                val listRestaurant = DataMapper.mapFromResponseToEntities(data)
                localDataSource.insertResto(listRestaurant)
            }

            override fun shouldFetch(data: List<Restaurant>?): Boolean =
                data == null || data.isEmpty()
        }.asFlow()

    }

    override fun getAllFavorite(): Flow<List<Restaurant>> {
        return localDataSource.getAllFavorite().map {
            DataMapper.mapFromEntitiesToDomain(it)
        }
    }

    override fun setFavorite(restaurant: Restaurant, isFavorite: Boolean) {
        val restoEntity = DataMapper.mapFromDomainToEntity(restaurant)
        appExecutors.diskIO().execute{
            localDataSource.updateRestoFavorite(restoEntity, isFavorite)
        }
    }
}