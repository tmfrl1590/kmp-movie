package com.kmp.movie

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform