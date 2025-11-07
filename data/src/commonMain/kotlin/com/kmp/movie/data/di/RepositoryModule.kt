package com.kmp.movie.data.di

import com.kmp.movie.data.repository.LocalRepositoryImpl
import com.kmp.movie.data.repository.MovieRepositoryImpl
import com.kmp.movie.domain.repository.LocalRepository
import com.kmp.movie.domain.repository.MovieRepository
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val repositoryModule = module {
    singleOf(::MovieRepositoryImpl).bind<MovieRepository>()
    singleOf(::LocalRepositoryImpl).bind<LocalRepository>()
}