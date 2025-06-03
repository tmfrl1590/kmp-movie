package com.kmp.movie.data.model

import com.kmp.movie.data.DataConstants.backDropImageUrl
import com.kmp.movie.data.DataConstants.posterImageUrl
import com.kmp.movie.data.DataMapper
import com.kmp.movie.domain.model.BelongsToCollection
import com.kmp.movie.domain.model.DetailMovie
import com.kmp.movie.domain.model.Genre
import com.kmp.movie.domain.model.ProductionCompany
import com.kmp.movie.domain.model.ProductionCountry
import com.kmp.movie.domain.model.SpokenLanguage
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class DetailMovieEntity(
    val adult: Boolean,
    @SerialName("backdrop_path")
    val backdropPath: String?,
    @SerialName("belongs_to_collection")
    val belongsToCollection: BelongsToCollectionEntity?,
    val budget: Int,
    val genres: List<GenreEntity>,
    val homepage: String,
    val id: Int,
    @SerialName("imdb_id")
    val imdbId: String?,
    @SerialName("origin_country")
    val originCountry: List<String>,
    @SerialName("original_language")
    val originalLanguage: String,

    @SerialName("original_title")
    val originalTitle: String,

    val overview: String,
    val popularity: Double,

    @SerialName("poster_path")
    val posterPath: String,

    @SerialName("production_companies")
    val productionCompanies: List<ProductionCompanyEntity>,

    @SerialName("production_countries")
    val productionCountries: List<ProductionCountryEntity>,

    @SerialName("release_date")
    val releaseDate: String,

    val revenue: Int,
    val runtime: Int,

    @SerialName("spoken_languages")
    val spokenLanguages: List<SpokenLanguageEntity>,

    val status: String,
    val tagline: String,
    val title: String,
    val video: Boolean,

    @SerialName("vote_average")
    val voteAverage: Double,

    @SerialName("vote_count")
    val voteCount: Int
): DataMapper<DetailMovie>{
    override fun toDomain(): DetailMovie {
        return DetailMovie(
            adult = adult,
            backdropPath = backDropImageUrl(backdropPath),
            belongsToCollection = belongsToCollection?.toDomain(),
            budget = budget,
            genres = genres.map { it.toDomain() },
            homepage = homepage,
            id = id,
            imdbId = imdbId,
            originCountry = originCountry,
            originalLanguage = originalLanguage,
            originalTitle = originalTitle,
            overview = overview,
            popularity = popularity,
            posterPath = posterImageUrl(posterPath),
            productionCompanies = productionCompanies.map { it.toDomain() },
            productionCountries = productionCountries.map { it.toDomain() },
            releaseDate = releaseDate,
            revenue = revenue,
            runtime = runtime,
            spokenLanguages = spokenLanguages.map { it.toDomain() },
            status = status,
            tagline = tagline,
            title = title,
            video = video,
            voteAverage = voteAverage,
            voteCount = voteCount
        )
    }
}

@Serializable
data class GenreEntity(
    val id: Int,
    val name: String,
): DataMapper<Genre>{
    override fun toDomain(): Genre {
        return Genre(
            id = id,
            name = name
        )
    }
}

@Serializable
data class ProductionCompanyEntity(
    val id: Int,
    @SerialName("logo_path")
    val logoPath: String?,
    val name: String,
    @SerialName("origin_country")
    val originCountry: String,
): DataMapper<ProductionCompany>{
    override fun toDomain(): ProductionCompany {
        return ProductionCompany(
            id = id,
            logoPath = logoPath,
            name = name,
            originCountry = originCountry,
        )
    }
}

@Serializable
data class ProductionCountryEntity(
    val iso_3166_1: String,
    val name: String,
): DataMapper<ProductionCountry>{
    override fun toDomain(): ProductionCountry {
        return ProductionCountry(
            iso_3166_1 = iso_3166_1,
            name = name
        )
    }
}

@Serializable
data class SpokenLanguageEntity(
    @SerialName("english_name")
    val englishName: String,
    val iso_639_1: String,
    val name: String,
): DataMapper<SpokenLanguage>{
    override fun toDomain(): SpokenLanguage {
        return SpokenLanguage(
            englishName = englishName,
            iso_639_1 = iso_639_1,
            name = name
        )
    }
}

@Serializable
data class BelongsToCollectionEntity(
    val id: Int,
    val name: String,
    @SerialName("poster_path")
    val posterPath: String,
    @SerialName("backdrop_path")
    val backdropPath: String,
): DataMapper<BelongsToCollection>{
    override fun toDomain(): BelongsToCollection {
        return BelongsToCollection(
            id = id,
            name = name,
            posterPath = posterPath,
            backdropPath = backdropPath
        )
    }
}