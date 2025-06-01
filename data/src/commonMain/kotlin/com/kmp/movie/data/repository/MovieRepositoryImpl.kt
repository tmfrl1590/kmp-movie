package com.kmp.movie.data.repository

import com.kmp.movie.core.domain.DataError
import com.kmp.movie.core.domain.Result
import com.kmp.movie.core.domain.map
import com.kmp.movie.data.remote.MovieRemoteDataSource
import com.kmp.movie.domain.model.NowPlayingMovie
import com.kmp.movie.domain.model.UpComingMovie
import com.kmp.movie.domain.repository.MovieRepository

class MovieRepositoryImpl(
    private val movieRemoteDataSource: MovieRemoteDataSource
): MovieRepository {
    override suspend fun getNowPlayingMovies(
        language: String,
        page: Int,
        region: String
    ): Result<NowPlayingMovie, DataError> {
        return movieRemoteDataSource.getNowPlayingMovies(
            language = language,
            page = page,
            region = region
        ).map { it.toDomain() }
    }

    override suspend fun getUpComingMovies(
        language: String,
        page: Int,
        region: String
    ): Result<UpComingMovie, DataError> {
        return movieRemoteDataSource.getUpcomingMovies(
            language = language,
            page = page,
            region = region
        ).map { it.toDomain() }
    }
}