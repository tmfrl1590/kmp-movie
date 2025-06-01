package com.kmp.movie.di

import com.kmp.movie.core.data.HttpClientFactory
import com.kmp.movie.data.remote.MovieRemoteDataSource
import com.kmp.movie.data.repository.MovieRepositoryImpl
import com.kmp.movie.domain.repository.MovieRepository
import com.kmp.movie.domain.usecase.GetNowPlayingMovieListUseCase
import com.kmp.movie.domain.usecase.GetUpComingMovieListUseCase
import com.kmp.movie.presentation.ui.home.viewmodel.HomeViewModel
import com.kmp.movie.remote.network.MovieRemoteDataSourceImpl
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
    viewModelOf(::HomeViewModel)
}

val useCaseModule = module {
    factory { GetNowPlayingMovieListUseCase(get()) }
    factory { GetUpComingMovieListUseCase(get()) }
}

val repositoryModule = module {
    singleOf(::MovieRepositoryImpl).bind<MovieRepository>()
}

val remoteSourceModule = module {
    singleOf(::MovieRemoteDataSourceImpl).bind<MovieRemoteDataSource>()
}