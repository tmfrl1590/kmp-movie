package com.kmp.movie.domain.usecase

import com.kmp.movie.domain.repository.MovieRepository

class GetNowPlayingMovieListUseCase(
    private val movieRepository: MovieRepository
) {
    suspend operator fun invoke(
        language: String,
        page: Int,
        region: String,
    ) = movieRepository.getNowPlayingMovies(
        language = language,
        page = page,
        region = region,
    )
}