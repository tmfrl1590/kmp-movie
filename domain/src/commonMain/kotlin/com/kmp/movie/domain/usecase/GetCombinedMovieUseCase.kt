package com.kmp.movie.domain.usecase

import com.kmp.movie.domain.repository.MovieRepository

class GetCombinedMovieUseCase(
    private val movieRepository: MovieRepository
) {
    suspend operator fun invoke(
        personId: Int,
        language: String,
    ) = movieRepository.getCombinedMovie(personId = personId, language = language)
}