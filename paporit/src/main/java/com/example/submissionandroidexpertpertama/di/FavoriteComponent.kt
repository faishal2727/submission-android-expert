package com.example.submissionandroidexpertpertama.di

import android.content.Context
import com.example.submissionandroidexpertpertama.presentation.di.FavoriteModuleDependencies
import com.example.submissionandroidexpertpertama.presentation.screen.FavoriteActivity
import dagger.BindsInstance
import dagger.Component


@Component(dependencies = [FavoriteModuleDependencies::class])
interface FavoriteComponent {

    fun inject(activity : FavoriteActivity)

    @Component.Builder
    interface Builder{
        fun context(@BindsInstance context: Context): Builder
        fun appDependencies(favoriteModuleDependencies: FavoriteModuleDependencies): Builder
        fun build(): FavoriteComponent
    }
}