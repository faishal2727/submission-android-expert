package com.example.submissionandroidexpertpertama.presentation.view_model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.submissionandroidexpertpertama.core.domain.usecase.RestaurantUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor (private val reaturantUseCase : RestaurantUseCase): ViewModel() {

    fun getAllRestaurant() = reaturantUseCase.getAllRestaurant().asLiveData()
}