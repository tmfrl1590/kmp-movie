package com.kmp.movie.domain.usecase

import com.kmp.movie.domain.repository.MovieRepository

class GetSearchedMovieListUseCase(
    private val movieRepository: MovieRepository
) {
    suspend operator fun invoke(
        query: String,
        language: String,
    ) = movieRepository.getSearchedMovies(query = query, language = language)
}