package com.yavuzmobile.data

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import com.yavuzmobile.common.model.Movie
import com.yavuzmobile.common.model.MovieDetail


interface MovieApi {

    companion object {
        const val API_KEY = "5e56c9ea84a4fa87f994608e6844b886"
    }

    @GET("movie/now_playing")
    suspend fun fetchMovieNowPlaying(@Query("api_key") apiKey: String = API_KEY): Response<Movie>

    @GET("movie/upcoming")
    suspend fun fetchMovieUpComing(@Query("api_key") apiKey: String = API_KEY): Response<Movie>

    @GET("movie/{movie_id}")
    suspend fun fetchMovieDetail(
        @Path("movie_id") movieId: Int,
        @Query("api_key") apiKey: String = API_KEY
    ): Response<MovieDetail>

}