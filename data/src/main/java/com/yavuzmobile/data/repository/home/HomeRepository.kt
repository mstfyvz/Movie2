package com.yavuzmobile.data.repository.home

import com.yavuzmobile.data.datasource.HomeRemoteDataSource
import com.yavuzmobile.common.model.Movie
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton

interface HomeRepository {
    suspend fun fetchMovieNowPlaying(): Response<Movie>
    suspend fun fetchMovieUpComing(): Response<Movie>
}

@Singleton
class HomeRepositoryImpl @Inject constructor(private val dataSource: HomeRemoteDataSource) :
    HomeRepository {
    override suspend fun fetchMovieNowPlaying(): Response<Movie> = dataSource.fetchMovieNowPlaying()
    override suspend fun fetchMovieUpComing(): Response<Movie> = dataSource.fetchMovieUpComing()
}