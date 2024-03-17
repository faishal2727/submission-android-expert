@file:Suppress(
    "RemoveRedundantQualifierName", "RedundantSuppression", "RedundantSuppression",
    "RedundantSuppression", "RedundantSuppression", "RedundantSuppression", "RedundantSuppression"
)

package com.example.submissionandroidexpertpertama.core.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import net.sqlcipher.database.SQLiteDatabase
import net.sqlcipher.database.SupportFactory
import javax.inject.Singleton

@Suppress("RemoveRedundantQualifierName", "RedundantSuppression", "RedundantSuppression",
    "RedundantSuppression", "RedundantSuppression"
)
@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    private val passphrase = SQLiteDatabase.getBytes("resto".toCharArray())
    private val factory = SupportFactory(passphrase)

    @Provides
    @Singleton
    fun roomDatabase(@ApplicationContext context : Context): com.example.submissionandroidexpertpertama.core.data.source.local.room.RestaurantDatabase {
        return Room.databaseBuilder(
            context,
            com.example.submissionandroidexpertpertama.core.data.source.local.room.RestaurantDatabase::class.java,
            "my_resto_db")
            .fallbackToDestructiveMigration().openHelperFactory(factory).build()
    }

    @Provides
    @Singleton
    fun restaurantDap(restaurantDatabase : com.example.submissionandroidexpertpertama.core.data.source.local.room.RestaurantDatabase): com.example.submissionandroidexpertpertama.core.data.source.local.room.RestaurantDao {
        return restaurantDatabase.restaurantDao()
    }
}