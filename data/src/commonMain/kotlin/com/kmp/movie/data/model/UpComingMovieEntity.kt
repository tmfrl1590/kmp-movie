package com.kmp.movie.data.model

import com.kmp.movie.data.DataConstants.backDropImageUrl
import com.kmp.movie.data.DataConstants.posterImageUrl
import com.kmp.movie.data.DataMapper
import com.kmp.movie.domain.model.UpComingMovie
import com.kmp.movie.domain.model.UpComingMovieData
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class UpComingMovieEntity(
    val dates: UpComingMovieDateEntity,
    val results: List<UpComingMovieDataEntity>
): DataMapper<UpComingMovie> {
    override fun toDomain(): UpComingMovie {
        return UpComingMovie(
            results = results.map { it.toDomain() }
        )
    }
}

@Serializable
data class UpComingMovieDateEntity(
    val maximum: String,
    val minimum: String
)

@Serializable
data class UpComingMovieDataEntity(
    val adult: Boolean,

    @SerialName("backdrop_path")
    val backdropPath: String?,

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
): DataMapper<UpComingMovieData> {
    override fun toDomain(): UpComingMovieData {
        return UpComingMovieData(
            adult = adult,
            backdropPath = backDropImageUrl(backdropPath),
            genreIds = genreIds,
            id = id,
            originalLanguage = originalLanguage,
            originalTitle = originalTitle,
            overview = overview,
            popularity = popularity,
            posterPath = posterImageUrl(posterPath),
            releaseDate = releaseDate,
            title = title,
            video = video,
            voteAverage = voteAverage,
            voteCount = voteCount
        )
    }
}