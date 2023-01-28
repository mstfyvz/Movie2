package com.yavuzmobile.movie.feature.home

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yavuzmobile.common.model.Movie
import com.yavuzmobile.domain.Result
import com.yavuzmobile.domain.UiState
import com.yavuzmobile.domain.usecase.NowPlayingUseCase
import com.yavuzmobile.domain.usecase.UpComingUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class HomeViewModel @Inject constructor(
    private val nowPlayingUseCase: NowPlayingUseCase,
    private val upComingUseCase: UpComingUseCase
) : ViewModel() {

    private val _sliderUIState = MutableStateFlow(UiState<Movie>())
    val sliderUIState: StateFlow<UiState<Movie>> = _sliderUIState.asStateFlow()

    private val _homeListUiState = MutableStateFlow(UiState<Movie>())
    val homeListUiState: StateFlow<UiState<Movie>> = _homeListUiState.asStateFlow()

    fun fetchMovieNowPlaying() {
        viewModelScope.launch {
            nowPlayingUseCase().collect {
                when (it) {
                    is Result.Loading -> _sliderUIState.update { state -> state.copy(isLoading = true) }
                    is Result.Success -> {
                        Log.i("SLIDER", it.data.toString())
                        _sliderUIState.update { state -> state.copy(movie = it.data) }
                    }
                    is Result.Error -> _sliderUIState.update { state -> state.copy(error = it.error) }
                }
            }
        }
    }

    fun fetchMovieUpComing() {
        viewModelScope.launch {
            upComingUseCase().collect {
                when (it) {
                    is Result.Loading -> _homeListUiState.update { state -> state.copy(isLoading = true) }
                    is Result.Success -> _homeListUiState.update { state -> state.copy(movie = it.data) }
                    is Result.Error -> _homeListUiState.update { state -> state.copy(error = it.error) }
                }
            }
        }
    }

}