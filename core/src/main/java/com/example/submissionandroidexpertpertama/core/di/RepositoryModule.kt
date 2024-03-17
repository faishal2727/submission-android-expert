package com.example.submissionandroidexpertpertama.core.di

import com.example.submissionandroidexpertpertama.core.data.RestaurantRepository
import com.example.submissionandroidexpertpertama.core.domain.repositories.IRestaurantRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module(includes = [DatabaseModule::class, NetworkModule::class])
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun provideRepository(movieRepository: RestaurantRepository): IRestaurantRepository
}