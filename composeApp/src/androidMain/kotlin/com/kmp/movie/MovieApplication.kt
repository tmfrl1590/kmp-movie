package com.kmp.movie

import android.app.Application
import com.kmp.movie.di.initKoin
import org.koin.android.ext.koin.androidContext

class MovieApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin {
            androidContext(this@MovieApplication)
        }
    }
}