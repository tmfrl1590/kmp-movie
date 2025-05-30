package com.kmp.movie.domain.repository

import com.kmp.movie.core.domain.DataError
import com.kmp.movie.core.domain.Result
import com.kmp.movie.domain.model.NowPlayingMovie

interface MovieRepository {

    suspend fun getNowPlayingMovies(
        language: String,
        page: Int,
        region: String,
    ): Result<NowPlayingMovie, DataError>
}