package com.kmp.movie.domain.usecase

import com.kmp.movie.domain.repository.MovieRepository

class GetSimilarMovieUseCase(
    private val movieRepository: MovieRepository
) {
    suspend operator fun invoke(
        movieId: Int,
        language: String,
    ) = movieRepository.getSimilarMoves(movieId = movieId, language = language)
}