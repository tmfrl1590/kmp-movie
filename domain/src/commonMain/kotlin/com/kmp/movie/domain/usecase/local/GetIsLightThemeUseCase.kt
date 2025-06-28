package com.kmp.movie.domain.usecase.local

import com.kmp.movie.domain.repository.LocalRepository

class GetIsLightThemeUseCase(
    private val localRepository: LocalRepository
) {
    suspend operator fun invoke() = localRepository.getIsLightTheme()
}