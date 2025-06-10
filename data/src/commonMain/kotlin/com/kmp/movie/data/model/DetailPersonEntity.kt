package com.kmp.movie.data.model

import com.kmp.movie.data.DataConstants.profileImageUrl
import com.kmp.movie.data.DataMapper
import com.kmp.movie.domain.model.DetailPerson
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class DetailPersonEntity(
    val adult: Boolean,
    @SerialName("also_known_as")
    val alsoKnownAs: List<String>,
    val biography: String,
    val birthday: String,
    @SerialName("deathday")
    val deathDay: String?,
    val gender: Int,
    val homepage: String?,
    val id: Int,
    @SerialName("imdb_id")
    val imdbId: String,
    @SerialName("known_for_department")
    val knownForDepartment: String,
    val name: String,
    @SerialName("place_of_birth")
    val placeOfBirth: String,
    val popularity: Double,
    @SerialName("profile_path")
    val profilePath: String,
): DataMapper<DetailPerson>{
    override fun toDomain(): DetailPerson {
        return DetailPerson(
            adult = adult,
            alsoKnownAs = alsoKnownAs,
            biography = biography,
            birthday = birthday,
            deathDay = deathDay,
            gender = gender,
            homepage = homepage,
            id = id,
            imdbId = imdbId,
            knownForDepartment = knownForDepartment,
            name = name,
            placeOfBirth = placeOfBirth,
            popularity = popularity,
            profilePath = profileImageUrl(profilePath),
        )
    }
}
