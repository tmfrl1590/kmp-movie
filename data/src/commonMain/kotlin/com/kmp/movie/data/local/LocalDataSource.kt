package com.kmp.movie.data.local

interface LocalDataSource {

    suspend fun saveIsLightTheme(isLightTheme: Boolean)

    suspend fun getIsLightTheme(): Boolean
}