package com.yavuzmobile.domain.usecase

import com.yavuzmobile.common.model.Movie
import com.yavuzmobile.data.repository.home.HomeRepository
import com.yavuzmobile.domain.responseWrapper
import com.yavuzmobile.domain.Result
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NowPlayingUseCase @Inject constructor(private val homeRepository: HomeRepository) {
    suspend operator fun invoke() : Flow<Result<Movie>> =
        responseWrapper { homeRepository.fetchMovieNowPlaying() }
}