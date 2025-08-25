package com.kmp.movie.presentation.ui.home.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kmp.movie.core.domain.map
import com.kmp.movie.core.type.MovieType
import com.kmp.movie.domain.usecase.GetNowPlayingMovieListUseCase
import com.kmp.movie.domain.usecase.GetPopularMovieListUseCase
import com.kmp.movie.domain.usecase.GetUpComingMovieListUseCase
import com.kmp.movie.presentation.Paginator
import com.kmp.movie.presentation.model.HomeMovieModel
import com.kmp.movie.presentation.model.toHomeModel
import com.kmp.movie.presentation.model.toPresentation
import com.kmp.movie.presentation.ui.home.action.HomeAction
import com.kmp.movie.presentation.ui.home.state.HomeState
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class HomeViewModel(
    private val getNowPlayingMovieListUseCase: GetNowPlayingMovieListUseCase,
    private val getUpComingMovieListUseCase: GetUpComingMovieListUseCase,
    private val getPopularMovieListUseCase: GetPopularMovieListUseCase,
): ViewModel() {

    private val _state = MutableStateFlow(HomeState())
    val state = _state.asStateFlow()

    private val _scrollToTop = MutableSharedFlow<Unit>(
        replay = 0,
        extraBufferCapacity = 1,
        onBufferOverflow = BufferOverflow.DROP_OLDEST
    )
    val scrollToTop = _scrollToTop.asSharedFlow()

    private val pageSize = 10
    private val nowPlayingPaginator = Paginator<Int, List<HomeMovieModel>>(
        initialKey = 1,
        onLoadUpdated = { isLoading ->
            _state.update { it.copy(isLoading = isLoading) }
        },
        onRequest = { currentPage ->
            getNowPlayingMovieListUseCase(
                language = "ko",
                region = "KR",
                page = currentPage
            ).map {
                it.toPresentation().results.map { it.toHomeModel() }
            }
        },
        getNextKey = { currentPage, _ ->
            currentPage + 1
        },
        onError = { throwable ->

        },
        onSuccess = { movieList, nextPage ->
            _state.update { it.copy(homeMovieList = it.homeMovieList +  movieList) }
        },
        endReached = { currentPage, response ->
            response.size < pageSize
        }
    )

    private val popularPaginator = Paginator<Int, List<HomeMovieModel>>(
        initialKey = 1,
        onLoadUpdated = { isLoading ->
            _state.update { it.copy(isLoading = isLoading) }
        },
        onRequest = { currentPage ->
            getPopularMovieListUseCase(
                language = "ko",
                region = "KR",
                page = currentPage
            ).map {
                it.toPresentation().results.map { it.toHomeModel() }
            }
        },
        getNextKey = { currentPage, _ ->
            currentPage + 1
        },
        onError = { throwable ->

        },
        onSuccess = { movieList, nextPage ->
            _state.update { it.copy(homeMovieList = it.homeMovieList +  movieList) }
        },
        endReached = { currentPage, response ->
            response.size < pageSize
        }
    )

    private val upComingPaginator = Paginator<Int, List<HomeMovieModel>>(
        initialKey = 1,
        onLoadUpdated = { isLoading ->
            _state.update { it.copy(isLoading = isLoading) }
        },
        onRequest = { currentPage ->
            getUpComingMovieListUseCase(
                language = "ko",
                region = "KR",
                page = currentPage
            ).map {
                it.toPresentation().results.map { it.toHomeModel() }
            }
        },
        getNextKey = { currentPage, _ ->
            currentPage + 1
        },
        onError = { throwable ->

        },
        onSuccess = { movieList, nextPage ->
            _state.update { it.copy(homeMovieList = it.homeMovieList +  movieList) }
        },
        endReached = { currentPage, response ->
            response.size < pageSize
        }
    )

    init {
        loadMovieList()
    }

    fun loadMovieList() {
        viewModelScope.launch {
            when(_state.value.selectedMovieType){
                MovieType.NOW_PLAYING -> nowPlayingPaginator.loadNextItems()
                MovieType.POPULAR -> popularPaginator.loadNextItems()
                MovieType.UPCOMING -> upComingPaginator.loadNextItems()
            }
        }
    }

    fun onAction(action: HomeAction){
        when(action){
            is HomeAction.OnShowBottomSheet -> _state.update { it.copy(isShowBottomSheet = action.isShowSheet) }
            is HomeAction.OnSelectMovieType -> onMovieTypeSelected(type = action.selectedMovieType)
        }
    }

    fun onMovieTypeSelected(type: MovieType) {
        _state.update { it.copy( selectedMovieType = type, homeMovieList = emptyList(), isShowBottomSheet = false ) }
        nowPlayingPaginator.reset()
        popularPaginator.reset()
        upComingPaginator.reset()
        loadMovieList()
        _scrollToTop.tryEmit(Unit)
    }
}