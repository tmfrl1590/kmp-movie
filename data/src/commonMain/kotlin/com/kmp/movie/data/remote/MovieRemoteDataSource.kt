package com.kmp.movie.data.remote

import com.kmp.movie.core.domain.DataError
import com.kmp.movie.core.domain.Result
import com.kmp.movie.data.model.NowPlayingMovieEntity
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
}