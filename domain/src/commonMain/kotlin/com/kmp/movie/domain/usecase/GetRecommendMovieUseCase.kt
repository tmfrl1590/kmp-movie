package com.kmp.movie.domain.usecase

import com.kmp.movie.domain.repository.MovieRepository

class GetRecommendMovieUseCase(
    private val movieRepository: MovieRepository
) {
    suspend operator fun invoke(
        movieId: Int,
        language: String,
    ) = movieRepository.getRecommendMovies(movieId = movieId, language = language)
}