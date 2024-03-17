package com.example.submissionandroidexpertpertama.core.domain.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Restaurant(

    val id: String,

    val name: String,

    val description: String,

    val pictureId: String,

    val city: String,

    val reting: Double,

    var isFavorite : Boolean = false
): Parcelable
