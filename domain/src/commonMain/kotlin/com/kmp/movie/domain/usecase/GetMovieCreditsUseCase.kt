package com.kmp.movie.domain.usecase

import com.kmp.movie.domain.repository.MovieRepository

class GetMovieCreditsUseCase(
    private val movieRepository: MovieRepository
) {
    suspend operator fun invoke(
        movieId: Int,
        language: String,
    ) = movieRepository.getMovieCredits(movieId = movieId, language = language)
}