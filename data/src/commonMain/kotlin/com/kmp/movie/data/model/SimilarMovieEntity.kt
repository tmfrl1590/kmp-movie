package com.kmp.movie.data.model

import com.kmp.movie.data.DataConstants.backDropImageUrl
import com.kmp.movie.data.DataConstants.posterImageUrl
import com.kmp.movie.data.DataMapper
import com.kmp.movie.domain.model.SimilarMovie
import com.kmp.movie.domain.model.SimilarMovieData
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SimilarMovieEntity(
    val page: Int,
    val results: List<SimilarMovieDateEntity>,
    @SerialName("total_pages")
    val totalPages: Int,
    @SerialName("total_results")
    val totalResults: Int,
): DataMapper<SimilarMovie> {
    override fun toDomain(): SimilarMovie {
        return SimilarMovie(
            results = results.map { it.toDomain() }
        )
    }
}

@Serializable
data class SimilarMovieDateEntity(
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
    val posterPath: String?,

    @SerialName("release_date")
    val releaseDate: String,

    val title: String,
    val video: Boolean,

    @SerialName("vote_average")
    val voteAverage: Double,

    @SerialName("vote_count")
    val voteCount: Int
): DataMapper<SimilarMovieData>{
    override fun toDomain(): SimilarMovieData {
        return SimilarMovieData(
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