package com.kmp.movie.domain.usecase.local

import com.kmp.movie.domain.repository.LocalRepository

class SaveIsLightThemeUseCase(
    private val localRepository: LocalRepository
) {
    suspend operator fun invoke(isLightTheme: Boolean) = localRepository.saveIsLightTheme(isLightTheme = isLightTheme)
}