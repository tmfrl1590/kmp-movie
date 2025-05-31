package com.kmp.movie.data

object DataConstants {
    private const val IMAGE_PREFIX_URL = "https://image.tmdb.org/t/p"
    const val POSTER_IMAGE_PREFIX_URL = "${IMAGE_PREFIX_URL}/w185"
    const val BACKDROP_IMAGE_PREFIX_URL = "${IMAGE_PREFIX_URL}/w780"
    const val PROFILE_IMAGE_PREFIX_URL = "${IMAGE_PREFIX_URL}/w185"
    const val YOUTUBE_PREFIX_URL = "https://www.youtube.com/watch?v="

    fun backDropImageUrl(urlString: String): String{
        return "$BACKDROP_IMAGE_PREFIX_URL$urlString"
    }
    fun posterImageUrl(urlString: String): String{
        return "$POSTER_IMAGE_PREFIX_URL$urlString"
    }
}