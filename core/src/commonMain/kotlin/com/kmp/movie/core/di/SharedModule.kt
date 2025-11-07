package com.kmp.movie.core.di

import com.kmp.movie.core.data.HttpClientFactory
import org.koin.dsl.module

val sharedModule = module {
    single { HttpClientFactory.create(get()) }
}