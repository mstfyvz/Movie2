package com.yavuzmobile.domain.di

import com.yavuzmobile.data.repository.home.HomeRepository
import com.yavuzmobile.domain.usecase.NowPlayingUseCase
import com.yavuzmobile.domain.usecase.UpComingUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    fun provideNowPlayingUseCase(homeRepository: HomeRepository) = NowPlayingUseCase(homeRepository)

    @Provides
    fun provideUpComingUseCase(homeRepository: HomeRepository) = UpComingUseCase(homeRepository)
}