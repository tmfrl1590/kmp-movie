package com.kmp.movie.data.model

import com.kmp.movie.data.DataConstants.backDropImageUrl
import com.kmp.movie.data.DataConstants.posterImageUrl
import com.kmp.movie.data.DataMapper
import com.kmp.movie.domain.model.RecommendMovie
import com.kmp.movie.domain.model.RecommendMovieData
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RecommendMovieEntity(
    val page: Int,
    val results: List<RecommendMovieDataEntity>,
    @SerialName("total_pages")
    val totalPages: Int,
    @SerialName("total_results")
    val totalResults: Int,
): DataMapper<RecommendMovie>{
    override fun toDomain(): RecommendMovie {
        return RecommendMovie(
            results = results.map { it.toDomain() }
        )
    }
}

@Serializable
data class RecommendMovieDataEntity(
    @SerialName("backdrop_path")
    val backdropPath: String?,
    val id: Int,
    val title: String,
    @SerialName("original_title")
    val originalTitle: String,
    val overview: String,
    @SerialName("poster_path")
    val posterPath: String?,
    @SerialName("media_type")
    val mediaType: String,
    val adult: Boolean,
    @SerialName("original_language")
    val originalLanguage: String,
    @SerialName("genre_ids")
    val genreIds: List<Int>,
    val popularity: Double,
    @SerialName("release_date")
    val releaseDate: String,
    val video: Boolean,
    @SerialName("vote_average")
    val voteAverage: Double,
    @SerialName("vote_count")
    val voteCount: Int
): DataMapper<RecommendMovieData>{
    override fun toDomain(): RecommendMovieData {
        return RecommendMovieData(
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