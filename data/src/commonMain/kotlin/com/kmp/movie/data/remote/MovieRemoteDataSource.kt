package com.kmp.movie.data.remote

import com.kmp.movie.core.domain.DataError
import com.kmp.movie.core.domain.Result
import com.kmp.movie.data.model.NowPlayingMovieEntity

interface MovieRemoteDataSource {

    suspend fun getNowPlayingMovies(
        language: String,
        page: Int,
        region: String,
    ): Result<NowPlayingMovieEntity, DataError>
}