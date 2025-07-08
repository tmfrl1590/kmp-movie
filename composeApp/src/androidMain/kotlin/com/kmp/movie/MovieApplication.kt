package com.kmp.movie

import android.app.Application
import com.kmp.movie.di.initKoin
import com.kmp.movie.presentation.ContextProvider
import org.koin.android.ext.koin.androidContext

class MovieApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        ContextProvider.initialize(this)
        initKoin {
            androidContext(this@MovieApplication)
        }
    }
}