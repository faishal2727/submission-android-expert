@file:Suppress("SpellCheckingInspection")

package com.example.submissionandroidexpertpertama.presentation.di

import com.example.submissionandroidexpertpertama.core.domain.usecase.RestaurantUseCase
import com.example.submissionandroidexpertpertama.core.domain.usecase.impl.RestaurantUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class AppModule {

    @Binds
    @Singleton
    abstract fun provideRepository(restaurantInteractor : RestaurantUseCaseImpl): RestaurantUseCase
}