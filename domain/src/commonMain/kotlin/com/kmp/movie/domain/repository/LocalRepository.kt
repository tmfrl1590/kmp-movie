package com.kmp.movie.domain.repository

interface LocalRepository {

    suspend fun saveIsLightTheme(isLightTheme: Boolean)

    suspend fun getIsLightTheme(): Boolean
}