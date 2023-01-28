package com.yavuzmobile.data.datasource

import com.yavuzmobile.common.model.Movie
import com.yavuzmobile.data.MovieApi
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton

interface HomeRemoteDataSource {
    suspend fun fetchMovieNowPlaying(): Response<Movie>
    suspend fun fetchMovieUpComing(): Response<Movie>
}

@Singleton
class HomeRemoteDataSourceImpl @Inject constructor(private val movieApi: MovieApi) :
    HomeRemoteDataSource {
    override suspend fun fetchMovieNowPlaying(): Response<Movie> =
        movieApi.fetchMovieNowPlaying()

    override suspend fun fetchMovieUpComing(): Response<Movie> =
        movieApi.fetchMovieUpComing()

}