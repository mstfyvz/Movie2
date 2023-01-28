package com.yavuzmobile.movie.feature.home

import androidx.compose.foundation.layout.*
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import coil.compose.AsyncImage
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.PagerState
import com.yavuzmobile.common.model.Movie
import com.yavuzmobile.domain.UiState


@OptIn(ExperimentalPagerApi::class)
@Composable
fun MovieNowPlayingSlider(
    items: UiState<Movie>,
    pagerState: PagerState
) {
    HorizontalPager(
        count = items.movie?.results?.size ?: 0,
        state = pagerState,
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
    ) { page ->
        val item = items.movie?.results?.get(page)
        ConstraintLayout(modifier = Modifier.fillMaxSize()) {
            val (image, title, content) = createRefs()
            Box(modifier = Modifier.fillMaxSize()) {
                Surface(modifier = Modifier.fillMaxSize()) {
                    AsyncImage(
                        model = "https://image.tmdb.org/t/p/original${item?.backdropPath}",
                        contentDescription = null
                    )
                }
            }

            Text(
                "${item?.title}",
                Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
                    .constrainAs(title) {
                        bottom.linkTo(content.top, margin = 16.dp)
                    },
                fontSize = 20.sp
            )

            Text(
                "${item?.overview}",
                Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
                    .constrainAs(content) {
                        bottom.linkTo(parent.bottom)
                    },
                fontSize = 12.sp
            )
        }
    }

}