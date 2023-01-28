package com.yavuzmobile.movie.feature.detail

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController

@Composable
fun DetailScreen(
    navController: NavHostController,
    movieId: String,
    viewModel: DetailViewModel = hiltViewModel()
) {

}