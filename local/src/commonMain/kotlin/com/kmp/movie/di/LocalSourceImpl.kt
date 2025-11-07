package com.kmp.movie.di

import com.kmp.movie.data.local.LocalDataSource
import com.kmp.movie.local.LocalDataSourceImpl
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val localSourceModule = module {
    singleOf(::LocalDataSourceImpl).bind<LocalDataSource>()
}