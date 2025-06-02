package com.kmp.movie.domain.usecase

import com.kmp.movie.domain.repository.MovieRepository

class GetPopularMovieListUseCase(
    private val movieRepository: MovieRepository
) {
    suspend operator fun invoke(
        language: String,
        page: Int,
        region: String,
    ) = movieRepository.getPopularMovies(
        language = language,
        page = page,
        region = region,
    )
}