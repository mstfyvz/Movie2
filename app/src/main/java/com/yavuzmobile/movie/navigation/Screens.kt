package com.yavuzmobile.movie.navigation

sealed class Screens(val route: String) {
    object Home : Screens("home_screen")
    object Detail : Screens("detail_screen/{movieId}") {
        fun argMovieId(movieId: String) = "movie_details_screen/$movieId"
    }
}