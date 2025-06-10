package com.kmp.movie.domain.repository

import com.kmp.movie.core.domain.DataError
import com.kmp.movie.core.domain.Result
import com.kmp.movie.domain.model.DetailMovie
import com.kmp.movie.domain.model.DetailPerson
import com.kmp.movie.domain.model.MovieCredit
import com.kmp.movie.domain.model.NowPlayingMovie
import com.kmp.movie.domain.model.PopularMovie
import com.kmp.movie.domain.model.RecommendMovie
import com.kmp.movie.domain.model.SearchMovie
import com.kmp.movie.domain.model.SimilarMovie
import com.kmp.movie.domain.model.UpComingMovie

interface MovieRepository {

    suspend fun getNowPlayingMovies(
        language: String,
        page: Int,
        region: String,
    ): Result<NowPlayingMovie, DataError>

    suspend fun getUpComingMovies(
        language: String,
        page: Int,
        region: String,
    ): Result<UpComingMovie, DataError>

    suspend fun getPopularMovies(
        language: String,
        page: Int,
        region: String,
    ): Result<PopularMovie, DataError>

    suspend fun getSearchedMovies(
        query: String,
        language: String,
    ): Result<SearchMovie, DataError>

    suspend fun getMovieDetails(
        movieId: Int,
        language: String,
    ): Result<DetailMovie, DataError>

    suspend fun getMovieCredits(
        movieId: Int,
        language: String,
    ): Result<MovieCredit, DataError>

    suspend fun getSimilarMoves(
        movieId: Int,
        language: String,
    ): Result<SimilarMovie, DataError>

    suspend fun getRecommendMovies(
        movieId: Int,
        language: String,
    ): Result<RecommendMovie, DataError>

    suspend fun getPersonDetail(
        personId: Int,
        language: String,
    ): Result<DetailPerson, DataError>
}