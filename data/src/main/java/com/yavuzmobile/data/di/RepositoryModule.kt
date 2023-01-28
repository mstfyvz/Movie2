package com.yavuzmobile.data.di

import com.yavuzmobile.data.datasource.HomeRemoteDataSource
import com.yavuzmobile.data.repository.home.HomeRepository
import com.yavuzmobile.data.repository.home.HomeRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    fun provideHomeRepository(remoteDataSource: HomeRemoteDataSource) : HomeRepository =
        HomeRepositoryImpl(remoteDataSource)
}