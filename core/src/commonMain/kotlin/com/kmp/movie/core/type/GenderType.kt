package com.kmp.movie.core.type

enum class GenderType(
    val value: Int,
    val displayName: String
) {
    NOT_SPECIFIED(0, "Not set / not specified"),
    FEMALE(1, "여성"),
    MALE(2, "남성"),
    NON_BINARY(3, "Non-binary");

    companion object {
        fun fromValue(value: Int): GenderType =
            entries.find { it.value == value } ?: NOT_SPECIFIED
    }
}