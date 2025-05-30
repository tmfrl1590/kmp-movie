package com.kmp.movie.data

internal interface DataMapper<DomainModel> {
    fun toDomain(): DomainModel
}