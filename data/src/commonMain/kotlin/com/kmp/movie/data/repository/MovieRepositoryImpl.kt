package com.kmp.movie.data.repository

import com.kmp.movie.core.domain.DataError
import com.kmp.movie.core.domain.Result
import com.kmp.movie.core.domain.map
import com.kmp.movie.data.remote.MovieRemoteDataSource
import com.kmp.movie.domain.model.DetailMovie
import com.kmp.movie.domain.model.MovieCredit
import com.kmp.movie.domain.model.NowPlayingMovie
import com.kmp.movie.domain.model.PopularMovie
import com.kmp.movie.domain.model.SearchMovie
import com.kmp.movie.domain.model.SimilarMovie
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

    override suspend fun getPopularMovies(
        language: String,
        page: Int,
        region: String
    ): Result<PopularMovie, DataError> {
        return movieRemoteDataSource.getPopularMovies(
            language = language,
            page = page,
            region = region
        ).map { it.toDomain() }
    }

    override suspend fun getSearchedMovies(
        query: String,
        language: String
    ): Result<SearchMovie, DataError> {
        return movieRemoteDataSource.getSearchedMovies(
            query = query,
            language = language
        ).map { it.toDomain() }
    }

    override suspend fun getMovieDetails(
        movieId: Int,
        language: String,
    ): Result<DetailMovie, DataError> {
        return movieRemoteDataSource.getMovieDetails(
            movieId = movieId,
            language = language,
        ).map { it.toDomain() }
    }

    override suspend fun getMovieCredits(
        movieId: Int,
        language: String
    ): Result<MovieCredit, DataError> {
        return movieRemoteDataSource.getMovieCredits(
            movieId = movieId,
            language = language
        ).map { it.toDomain() }
    }

    override suspend fun getSimilarMoves(
        movieId: Int,
        language: String
    ): Result<SimilarMovie, DataError> {
        return movieRemoteDataSource.getSimilarMovies(
            movieId = movieId,
            language = language
        ).map { it.toDomain() }
    }
}