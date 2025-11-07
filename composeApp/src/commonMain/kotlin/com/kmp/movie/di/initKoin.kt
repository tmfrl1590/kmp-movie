package com.kmp.movie.di

import com.kmp.movie.core.di.sharedModule
import com.kmp.movie.data.di.repositoryModule
import com.kmp.movie.domain.di.useCaseModule
import com.kmp.movie.presentation.di.viewModelModule
import com.kmp.movie.remote.di.remoteSourceModule
import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration

fun initKoin(config: KoinAppDeclaration? = null) {
    startKoin {
        config?.invoke(this)
        modules(
            sharedModule,
            platformModule,
            viewModelModule,
            useCaseModule,
            repositoryModule,
            remoteSourceModule,
            localSourceModule,
        )
    }
}