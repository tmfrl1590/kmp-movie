package com.kmp.movie.domain.model

data class MovieCredit(
    val id: Int,
    val cast: List<MovieCreditCast>
)

data class MovieCreditCast(
    val id: Int,
    val knownForDepartment: String,
    val name: String,
    val originalName: String,
    val profilePath: String,
    val character: String,
    val creditId: String,
)