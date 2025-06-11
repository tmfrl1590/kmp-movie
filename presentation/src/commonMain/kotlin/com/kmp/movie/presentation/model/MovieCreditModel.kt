package com.kmp.movie.presentation.model

import com.kmp.movie.domain.model.MovieCredit
import com.kmp.movie.domain.model.MovieCreditCast
import com.kmp.movie.core.type.KnownForDepartmentType

data class MovieCreditModel(
    val id: Int = -1,
    val cast: List<MovieCreditCastModel> = emptyList()
)

data class MovieCreditCastModel(
    val name: String,
    val profilePath: String,
    val knownForDepartment: String,
    val id: Int,
)

fun MovieCredit.toPresentation(): MovieCreditModel = MovieCreditModel(
    id = id,
    cast = cast.map { it.toPresentation() }
)

fun MovieCreditCast.toPresentation(): MovieCreditCastModel = MovieCreditCastModel(
    name = name,
    profilePath = profilePath,
    knownForDepartment = KnownForDepartmentType.fromValue(knownForDepartment).displayName,
    id = id,
)