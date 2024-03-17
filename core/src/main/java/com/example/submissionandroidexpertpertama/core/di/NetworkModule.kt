package com.example.submissionandroidexpertpertama.core.di

import com.example.submissionandroidexpertpertama.core.data.source.remote.network.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.CertificatePinner
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    private  val hostname = "restaurant-api.dicoding.dev"
    private val certificatePinner = CertificatePinner.Builder()
        .add(hostname, "sha256/d51f005c6a7df73749e43d89389c5758b5a59eb0228e42dfbb9a448b0794930a")
        .add(hostname, "sha256/qRXOtBLL57LL0c7e8w/vou6FL8GMrasDduMdcQqXeBw=")
        .build()

    @Provides
    @Singleton
    fun httpLogging():HttpLoggingInterceptor{
        return HttpLoggingInterceptor()
            .setLevel(HttpLoggingInterceptor.Level.BODY)

    }

    @Provides
    @Singleton
    fun okHttpClient(okHttpLoggingInterceptor: HttpLoggingInterceptor):OkHttpClient{
        return OkHttpClient.Builder()
            .addInterceptor(okHttpLoggingInterceptor)
            .connectTimeout(120,TimeUnit.SECONDS)
            .readTimeout(120,TimeUnit.SECONDS)
            .certificatePinner(certificatePinner)
            .build()
    }

    @Provides
    @Singleton
    fun retrofit(okHttpClient: OkHttpClient):Retrofit{
        return Retrofit.Builder()
            .baseUrl("https://restaurant-api.dicoding.dev/")
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun apiService(retrofit : Retrofit): ApiService {
       return  retrofit.create(ApiService::class.java)
    }
}