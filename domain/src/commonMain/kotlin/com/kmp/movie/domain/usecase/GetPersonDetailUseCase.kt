package com.kmp.movie.domain.usecase

import com.kmp.movie.domain.repository.MovieRepository

class GetPersonDetailUseCase(
    private val movieRepository: MovieRepository
) {
    suspend operator fun invoke(
        personId: Int,
        language: String,
    ) = movieRepository.getPersonDetail(personId = personId, language = language)
}