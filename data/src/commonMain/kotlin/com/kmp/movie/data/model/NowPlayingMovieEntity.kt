package com.kmp.movie.data.model

import com.kmp.movie.data.DataMapper
import com.kmp.movie.domain.model.NowPlayingMovie
import com.kmp.movie.domain.model.NowPlayingMovieData
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class NowPlayingMovieEntity(
    val dates: NowPlayingMovieDateEntity,
    val results: List<NowPlayingMovieDataEntity>
): DataMapper<NowPlayingMovie> {
    override fun toDomain(): NowPlayingMovie {
        return NowPlayingMovie(
            results = results.map { it.toDomain() }
        )
    }
}

@Serializable
data class NowPlayingMovieDateEntity(
    val maximum: String,
    val minimum: String
)

@Serializable
data class NowPlayingMovieDataEntity(
    val adult: Boolean,

    @SerialName("backdrop_path")
    val backdropPath: String,

    @SerialName("genre_ids")
    val genreIds: List<Int>,

    val id: Int,

    @SerialName("original_language")
    val originalLanguage: String,

    @SerialName("original_title")
    val originalTitle: String,

    val overview: String,
    val popularity: Double,

    @SerialName("poster_path")
    val posterPath: String,

    @SerialName("release_date")
    val releaseDate: String,

    val title: String,
    val video: Boolean,

    @SerialName("vote_average")
    val voteAverage: Double,

    @SerialName("vote_count")
    val voteCount: Int
): DataMapper<NowPlayingMovieData> {
    override fun toDomain(): NowPlayingMovieData {
        return NowPlayingMovieData(
            adult = adult,
            backdropPath = backdropPath,
            genreIds = genreIds,
            id = id,
            originalLanguage = originalLanguage,
            originalTitle = originalTitle,
            overview = overview,
            popularity = popularity,
            posterPath = posterPath,
            releaseDate = releaseDate,
            title = title,
            video = video,
            voteAverage = voteAverage,
            voteCount = voteCount
        )
    }
}