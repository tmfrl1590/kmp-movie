package com.kmp.movie.domain.di

import com.kmp.movie.domain.usecase.GetCombinedMovieUseCase
import com.kmp.movie.domain.usecase.GetMovieCreditsUseCase
import com.kmp.movie.domain.usecase.GetMovieDetailUseCase
import com.kmp.movie.domain.usecase.GetNowPlayingMovieListUseCase
import com.kmp.movie.domain.usecase.GetPersonDetailUseCase
import com.kmp.movie.domain.usecase.GetPopularMovieListUseCase
import com.kmp.movie.domain.usecase.GetRecommendMovieUseCase
import com.kmp.movie.domain.usecase.GetSearchedMovieListUseCase
import com.kmp.movie.domain.usecase.GetSimilarMovieUseCase
import com.kmp.movie.domain.usecase.GetUpComingMovieListUseCase
import com.kmp.movie.domain.usecase.local.GetIsLightThemeUseCase
import com.kmp.movie.domain.usecase.local.SaveIsLightThemeUseCase
import org.koin.dsl.module

val useCaseModule = module {
    factory { GetNowPlayingMovieListUseCase(get()) }
    factory { GetUpComingMovieListUseCase(get()) }
    factory { GetPopularMovieListUseCase(get()) }
    factory { GetSearchedMovieListUseCase(get()) }
    factory { GetMovieDetailUseCase(get()) }
    factory { GetMovieCreditsUseCase(get()) }
    factory { GetSimilarMovieUseCase(get()) }
    factory { GetRecommendMovieUseCase(get()) }
    factory { GetPersonDetailUseCase(get()) }
    factory { GetCombinedMovieUseCase(get()) }

    factory { SaveIsLightThemeUseCase(get()) }
    factory { GetIsLightThemeUseCase(get()) }
}