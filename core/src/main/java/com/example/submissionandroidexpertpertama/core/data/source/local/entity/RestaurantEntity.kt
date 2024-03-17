@file:Suppress("RemoveEmptyParenthesesFromAnnotationEntry")

package com.example.submissionandroidexpertpertama.core.data.source.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "restaurant")
data class RestaurantEntity (

    @PrimaryKey()
    @ColumnInfo(name = "id")
    val id: String,

    @ColumnInfo(name = "name")
    val name: String,

    @ColumnInfo(name = "description")
    val description: String,

    @ColumnInfo(name = "pictureId")
    val pictureId: String,

    @ColumnInfo(name = "city")
    val city: String,

    @ColumnInfo(name = "rating")
    val reting: Double,

    @ColumnInfo(name = "isFavorite")
    var isFavorite : Boolean = false

)