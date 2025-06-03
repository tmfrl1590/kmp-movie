package com.kmp.movie.data.model

import com.kmp.movie.data.DataConstants.profileImageUrl
import com.kmp.movie.data.DataMapper
import com.kmp.movie.domain.model.MovieCredit
import com.kmp.movie.domain.model.MovieCreditCast
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MovieCreditEntity(
    val id: Int,
    val cast: List<MovieCreditCastEntity>
): DataMapper<MovieCredit>{
    override fun toDomain(): MovieCredit {
        return MovieCredit(
            id = id,
            cast = cast.map { it.toDomain() }
        )
    }
}

@Serializable
data class MovieCreditCastEntity(
    val adult: Boolean,
    val gender: Int,
    val id: Int,
    @SerialName("known_for_department")
    val knownForDepartment: String,
    val name: String,
    @SerialName("original_name")
    val originalName: String,
    val popularity: Double,
    @SerialName("profile_path")
    val profilePath: String?,
    @SerialName("cast_id")
    val castId: Int,
    val character: String,
    @SerialName("credit_id")
    val creditId: String,
    val order: Int,
): DataMapper<MovieCreditCast>{
    override fun toDomain(): MovieCreditCast {
        return MovieCreditCast(
            id = id,
            knownForDepartment = knownForDepartment,
            name = name,
            originalName = originalName,
            profilePath = profileImageUrl(profilePath),
            character = character,
            creditId = creditId
        )
    }
}