package com.example.submissionandroidexpertpertama.presentation.di

import com.example.submissionandroidexpertpertama.core.domain.usecase.RestaurantUseCase
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@EntryPoint
@InstallIn(SingletonComponent::class)
interface FavoriteModuleDependencies {

    fun restaurantUseCase(): RestaurantUseCase

}