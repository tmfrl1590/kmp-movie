package com.kmp.movie.remote.di

import com.kmp.movie.data.remote.MovieRemoteDataSource
import com.kmp.movie.remote.network.MovieRemoteDataSourceImpl
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val remoteSourceModule = module {
    singleOf(::MovieRemoteDataSourceImpl).bind<MovieRemoteDataSource>()
}