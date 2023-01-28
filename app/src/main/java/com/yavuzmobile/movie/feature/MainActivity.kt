package com.yavuzmobile.movie.feature

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.yavuzmobile.movie.navigation.NavGraph
import com.yavuzmobile.movie.ui.theme.MovieTheme
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MovieTheme {
                val navController = rememberNavController()
                NavGraph(navController = navController)
            }
        }
    }
}