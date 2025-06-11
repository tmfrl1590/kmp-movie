package com.kmp.movie.data.model

import com.kmp.movie.data.DataConstants.backDropImageUrl
import com.kmp.movie.data.DataConstants.posterImageUrl
import com.kmp.movie.data.DataMapper
import com.kmp.movie.domain.model.CombinedMovie
import com.kmp.movie.domain.model.CombinedMovieItem
import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName

@Serializable
data class CombinedMovieEntity(
    val id: Int,
    val cast: List<CombinedMovieItemEntity>,
): DataMapper<CombinedMovie> {
    override fun toDomain(): CombinedMovie {
        return CombinedMovie(
            cast = cast.map { it.toDomain() }
        )
    }
}

@Serializable
data class CombinedMovieItemEntity(
    val adult: Boolean,
    @SerialName("backdrop_path")
    val backdropPath: String?,
    @SerialName("genre_ids")
    val genreIds: List<Int>,
    val id: Int,
    @SerialName("original_language")
    val originalLanguage: String,
    @SerialName("original_title")
    val originalTitle: String = "",
    val overview: String,
    val popularity: Double,
    @SerialName("poster_path")
    val posterPath: String?,
    @SerialName("release_date")
    val releaseDate: String = "",
    val title: String = "",
    val video: Boolean = false,
    @SerialName("vote_average")
    val voteAverage: Double,
    @SerialName("vote_count")
    val voteCount: Int,
    val character: String?,
    @SerialName("credit_id")
    val creditId: String,
    val order: Int = 0,
    @SerialName("media_type")
    val mediaType: String
): DataMapper<CombinedMovieItem> {
    override fun toDomain(): CombinedMovieItem {
        return CombinedMovieItem(
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
            voteCount = voteCount,
            character = character,
            creditId = creditId,
            order = order,
            mediaType = mediaType,
        )
    }
}