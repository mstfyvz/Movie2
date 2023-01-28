package com.yavuzmobile.movie.feature.home

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.PagerState
import com.google.accompanist.pager.VerticalPager
import com.yavuzmobile.common.model.Movie
import com.yavuzmobile.common.model.MovieResult
import com.yavuzmobile.domain.UiState

@Composable
fun MovieUpComingList(
    navController: NavHostController,
    items: UiState<Movie>,
    modifier: Modifier = Modifier
) {
    Column(Modifier.verticalScroll(rememberScrollState())) {
        items.movie?.results?.forEach { item ->
            MovieUpComingListItem(item)
        }
    }
}