package com.yavuzmobile.data.di

import com.yavuzmobile.data.MovieApi
import com.yavuzmobile.data.datasource.HomeRemoteDataSource
import com.yavuzmobile.data.datasource.HomeRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataSourceModule {

    @Provides
    fun provideHomeRemoteDataSource(movieApi: MovieApi) : HomeRemoteDataSource =
        HomeRemoteDataSourceImpl(movieApi)
}