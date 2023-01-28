package com.yavuzmobile.movie.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.yavuzmobile.movie.feature.detail.DetailScreen
import com.yavuzmobile.movie.feature.home.HomeScreen
import com.yavuzmobile.movie.util.Constant

@Composable
fun NavGraph(navController: NavHostController) {

    NavHost(
        navController = navController,
        startDestination = Screens.Home.route
    ) {
        composable(route = Screens.Home.route) {
            HomeScreen(navController = navController)
        }
        composable(
            route = Screens.Detail.route,
            arguments = listOf(navArgument(Constant.ARG_MOVIE_ID) {
                type = NavType.StringType
            })
        ) { backStackEntry ->
            backStackEntry.arguments?.getString(Constant.ARG_MOVIE_ID)
                ?.let { DetailScreen(navController, it) }
        }
    }
}