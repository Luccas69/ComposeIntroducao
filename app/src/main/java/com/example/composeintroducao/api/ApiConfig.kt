package com.example.composeintroducao.api

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApiConfig {
    private const val base_url = "https://api-estudos.vercel.app"

    @Singleton
    @Provides
    fun providesHttpLoggingInterceptor() = HttpLoggingInterceptor().apply {
        this.level = HttpLoggingInterceptor.Level.HEADERS
    }




}