package com.kmp.movie.data.remote

import com.kmp.movie.core.domain.DataError
import com.kmp.movie.core.domain.Result
import com.kmp.movie.data.model.DetailMovieEntity
import com.kmp.movie.data.model.MovieCreditCastEntity
import com.kmp.movie.data.model.MovieCreditEntity
import com.kmp.movie.data.model.NowPlayingMovieEntity
import com.kmp.movie.data.model.PopularMovieEntity
import com.kmp.movie.data.model.SearchMovieEntity
import com.kmp.movie.data.model.SimilarMovieEntity
import com.kmp.movie.data.model.UpComingMovieEntity

interface MovieRemoteDataSource {

    suspend fun getNowPlayingMovies(
        language: String,
        page: Int,
        region: String,
    ): Result<NowPlayingMovieEntity, DataError>

    suspend fun getUpcomingMovies(
        language: String,
        page: Int,
        region: String,
    ): Result<UpComingMovieEntity, DataError>

    suspend fun getPopularMovies(
        language: String,
        page: Int,
        region: String,
    ): Result<PopularMovieEntity, DataError>

    suspend fun getSearchedMovies(
        query: String,
        language: String,
    ): Result<SearchMovieEntity, DataError>

    suspend fun getMovieDetails(
        movieId: Int,
        language: String,
    ): Result<DetailMovieEntity, DataError>

    suspend fun getMovieCredits(
        movieId: Int,
        language: String,
    ): Result<MovieCreditEntity, DataError>

    suspend fun getSimilarMovies(
        movieId: Int,
        language: String,
    ): Result<SimilarMovieEntity, DataError>
}