package com.example.submissionandroidexpertpertama.core.utils

import com.example.submissionandroidexpertpertama.core.data.source.local.entity.RestaurantEntity
import com.example.submissionandroidexpertpertama.core.data.source.remote.response.RestaurantResponse
import com.example.submissionandroidexpertpertama.core.domain.model.Restaurant


object DataMapper {

        fun mapFromResponseToEntities(input : List<RestaurantResponse>):List<RestaurantEntity>{
            val list = mutableListOf<RestaurantEntity>()
            input.map{ restaurant ->
                restaurant.apply {
                    val restaurantEntity =
                        RestaurantEntity(
                            id, name, description, pictureId, city, reting
                        )
                    list.add(restaurantEntity)
                }
            }
            return list
        }

    fun mapFromEntitiesToDomain(input : List<RestaurantEntity>):List<Restaurant>{
        val listMovie = mutableListOf<Restaurant>()
        input.map { movie ->
            movie.apply {
                val movieDomain =
                    Restaurant(
                        id, name, description, pictureId, city, reting, isFavorite
                    )

                listMovie.add(movieDomain)
            }
        }
        return listMovie
    }

    fun mapFromDomainToEntity(input : Restaurant): RestaurantEntity {
        return RestaurantEntity(
            input.id,
            input.name,
            input.description,
            input.pictureId,
            input.city,
            input.reting,
            input.isFavorite

        )

    }

}