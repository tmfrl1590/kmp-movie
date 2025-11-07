package com.kmp.movie.presentation.di

import com.kmp.movie.presentation.screen.app.viewmodel.AppViewModel
import com.kmp.movie.presentation.screen.detail.viewmodel.MovieDetailViewModel
import com.kmp.movie.presentation.screen.home.viewmodel.HomeViewModel
import com.kmp.movie.presentation.screen.person_detail.viewmodel.PersonDetailViewModel
import com.kmp.movie.presentation.screen.search.viewmodel.SearchViewModel
import com.kmp.movie.presentation.screen.setting.viewmodel.SettingViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val viewModelModule = module {
    viewModelOf(::AppViewModel)
    viewModelOf(::HomeViewModel)
    viewModelOf(::SearchViewModel)
    viewModelOf(::MovieDetailViewModel)
    viewModelOf(::PersonDetailViewModel)
    viewModelOf(::SettingViewModel)
}