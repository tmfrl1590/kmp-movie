package com.kmp.movie.di

import com.kmp.movie.core.data.HttpClientFactory
import com.kmp.movie.data.local.LocalDataSource
import com.kmp.movie.data.remote.MovieRemoteDataSource
import com.kmp.movie.data.repository.LocalRepositoryImpl
import com.kmp.movie.data.repository.MovieRepositoryImpl
import com.kmp.movie.domain.repository.LocalRepository
import com.kmp.movie.domain.repository.MovieRepository
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
import com.kmp.movie.local.LocalDataSourceImpl
import com.kmp.movie.presentation.ui.detail.viewmodel.MovieDetailViewModel
import com.kmp.movie.presentation.ui.home.viewmodel.HomeViewModel
import com.kmp.movie.presentation.ui.person_detail.viewmodel.PersonDetailViewModel
import com.kmp.movie.presentation.ui.search.viewmodel.SearchViewModel
import com.kmp.movie.presentation.ui.setting.viewmodel.SettingViewModel
import com.kmp.movie.remote.network.MovieRemoteDataSourceImpl
import com.kmp.movie.presentation.ui.main.viewmodel.AppViewModel
import org.koin.core.module.Module
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.bind
import org.koin.dsl.module

expect val platformModule: Module

val sharedModule = module {
    single { HttpClientFactory.create(get()) }
}

val viewModelModule = module {
    viewModelOf(::AppViewModel)
    viewModelOf(::HomeViewModel)
    viewModelOf(::SearchViewModel)
    viewModelOf(::MovieDetailViewModel)
    viewModelOf(::PersonDetailViewModel)
    viewModelOf(::SettingViewModel)
}

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

val repositoryModule = module {
    singleOf(::MovieRepositoryImpl).bind<MovieRepository>()
    singleOf(::LocalRepositoryImpl).bind<LocalRepository>()
}

val remoteSourceModule = module {
    singleOf(::MovieRemoteDataSourceImpl).bind<MovieRemoteDataSource>()
    singleOf(::LocalDataSourceImpl).bind<LocalDataSource>()
}