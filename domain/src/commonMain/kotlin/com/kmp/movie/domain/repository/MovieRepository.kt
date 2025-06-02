package com.kmp.movie.domain.repository

import com.kmp.movie.core.domain.DataError
import com.kmp.movie.core.domain.Result
import com.kmp.movie.domain.model.NowPlayingMovie
import com.kmp.movie.domain.model.PopularMovie
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
}