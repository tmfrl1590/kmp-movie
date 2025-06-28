package com.kmp.movie.data.repository

import com.kmp.movie.data.local.LocalDataSource
import com.kmp.movie.domain.repository.LocalRepository

class LocalRepositoryImpl(
    private val localDataSource: LocalDataSource
): LocalRepository {
    override suspend fun saveIsLightTheme(isLightTheme: Boolean) {
        localDataSource.saveIsLightTheme(isLightTheme = isLightTheme)
    }

    override suspend fun getIsLightTheme(): Boolean {
        return localDataSource.getIsLightTheme()
    }
}