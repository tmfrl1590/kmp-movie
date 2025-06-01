package com.kmp.movie.remote.network

import com.kmp.movie.core.data.safeCall
import com.kmp.movie.core.domain.DataError
import com.kmp.movie.core.domain.Result
import com.kmp.movie.data.model.NowPlayingMovieEntity
import com.kmp.movie.data.model.UpComingMovieEntity
import com.kmp.movie.data.remote.MovieRemoteDataSource
import com.kmp.movie.remote.RemoteConstants.serverUrl
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.request.parameter

class MovieRemoteDataSourceImpl(
    private val httpClient: HttpClient
) : MovieRemoteDataSource {
    override suspend fun getNowPlayingMovies(
        language: String,
        page: Int,
        region: String
    ): Result<NowPlayingMovieEntity, DataError> {
        return safeCall<NowPlayingMovieEntity> {
            httpClient.get(
                urlString = serverUrl("/movie/now_playing")
            ) {
                parameter("language", language)
                parameter("page", page)
                parameter("region", region)
            }
        }
    }

    override suspend fun getUpcomingMovies(
        language: String,
        page: Int,
        region: String
    ): Result<UpComingMovieEntity, DataError> {
        return safeCall<UpComingMovieEntity> {
            httpClient.get(
                urlString = serverUrl("/movie/upcoming")
            ) {
                parameter("language", language)
                parameter("page", page)
                parameter("region", region)
            }
        }
    }
}