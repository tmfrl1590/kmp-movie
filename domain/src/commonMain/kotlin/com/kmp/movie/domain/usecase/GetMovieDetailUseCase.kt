package com.kmp.movie.domain.usecase

import com.kmp.movie.domain.repository.MovieRepository

class GetMovieDetailUseCase(
    private val movieRepository: MovieRepository,
) {
    suspend operator fun invoke(
        movieId: Int,
        language: String,
    ) = movieRepository.getMovieDetails(movieId = movieId, language = language)
}