package com.kmp.movie.remote

object RemoteConstants {

    private const val SERVER_URL = "https://api.themoviedb.org/3/"

    fun serverUrl(urlString: String): String {
        return "$SERVER_URL$urlString"
    }
}