package com.kmp.movie.presentation.model

import com.kmp.movie.domain.model.DetailPerson
import com.kmp.movie.presentation.type.GenderType
import com.kmp.movie.presentation.type.KnownForDepartmentType

data class DetailPersonModel(
    val birthday: String = "",
    val gender: String = "",
    val id: Int = 0,
    val name: String = "",
    val profilePath: String = "",
    val knownForDepartment: String = "",
)

fun DetailPerson.toPresentation(): DetailPersonModel = DetailPersonModel(
    birthday = birthday,
    gender = GenderType.fromValue(gender).displayName,
    id = id,
    name = name,
    profilePath = profilePath,
    knownForDepartment = KnownForDepartmentType.fromValue(knownForDepartment).displayName,
)