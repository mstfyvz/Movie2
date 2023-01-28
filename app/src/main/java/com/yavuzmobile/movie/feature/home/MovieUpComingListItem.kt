package com.yavuzmobile.movie.feature.home

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import coil.compose.AsyncImage
import com.yavuzmobile.common.model.MovieResult

@Composable
fun MovieUpComingListItem(item: MovieResult) {
    ConstraintLayout(
        Modifier
            .fillMaxWidth()
    ) {
        val (image, title, content, date) = createRefs()

        AsyncImage(
            model = "https://image.tmdb.org/t/p/original${item.posterPath}",
            contentDescription = "",
            Modifier
                .constrainAs(image) {
                    start.linkTo(parent.start)
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                    width = Dimension.value(100.dp)
                    height = Dimension.value(105.dp)
                })

        Text(
            "${item.title}",
            Modifier
                .constrainAs(title) {
                    start.linkTo(image.end, margin = 8.dp)
                    top.linkTo(image.top, margin = 8.dp)
                    end.linkTo(parent.end, margin = 8.dp)
                    width = Dimension.fillToConstraints
                },
            fontSize = 14.sp,
        )

        Text(
            "${item.overview}",
            Modifier
                .constrainAs(content) {
                    start.linkTo(title.start)
                    top.linkTo(title.bottom, margin = 8.dp)
                    end.linkTo(parent.end, margin = 8.dp)
                    width = Dimension.fillToConstraints
                },
            fontSize = 14.sp,
            maxLines = 2,
            overflow = TextOverflow.Clip
        )

        Text(
            "${item.releaseDate}",
            Modifier.constrainAs(date) {
                top.linkTo(content.bottom, margin = 8.dp)
                end.linkTo(parent.end, margin = 8.dp)
            },
            fontSize = 14.sp
        )
    }
}
@Preview(showSystemUi = true)
@Composable
fun PreviewMovieUpComingListItem() {
    val movieResult = MovieResult(
        "/ps2oKfhY6DL3alynlSqY97gHSsg.jpg",
        false,
        "Queen Ramonda, Shuri, M’Baku, Okoye and the Dora Milaje fight to protect their nation from intervening world powers in the wake of King T’Challa’s death. As the Wakandans strive to embrace their next chapter, the heroes must band together with the help of War Dog Nakia and Everett Ross and forge a new path for the kingdom of Wakanda.",
        "2022-11-09",
        listOf(28, 12, 878),
        505642,
        "Black Panther: Wakanda Forever",
        "en",
        "Black Panther: Wakanda Forever",
        "/xDMIl84Qo5Tsu62c9DGWhmPI67A.jpg",
        1625.367,
        1227,
        false,
        7.5
    )
    MovieUpComingListItem(movieResult)
}