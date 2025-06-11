package com.kmp.movie.core.type

enum class KnownForDepartmentType(
    val value: String,
    val displayName: String,
) {
    ACTING("Acting", "배우"),
    DIRECTING("Directing", "감독"),
    PRODUCTION("Production", "프로듀서"),
    WRITING("Writing", "작가"),
    SOUND("Sound", "음향"),
    ART("Art", "미술"),
    CREW("Crew", "스태프"),
    EDITING("Editing", "편집"),
    CAMERA("Camera", "촬영"),
    VISUAL_EFFECTS("Visual Effects", "VFX"),
    COSTUME_MAKEUP("Costume & Make-Up", "의상/분장"),
    UNKNOWN("", "기타");

    companion object {
        fun fromValue(value: String): KnownForDepartmentType =
            entries.find { it.value == value } ?: UNKNOWN
    }

}