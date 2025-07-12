package com.kmp.movie.core

import kmpmovie.core.generated.resources.Res
import kmpmovie.core.generated.resources.app_version
import kmpmovie.core.generated.resources.birthday
import kmpmovie.core.generated.resources.combined_movie
import kmpmovie.core.generated.resources.dark_theme
import kmpmovie.core.generated.resources.gender
import kmpmovie.core.generated.resources.image_default_movie
import kmpmovie.core.generated.resources.image_default_person
import kmpmovie.core.generated.resources.input_movie_title
import kmpmovie.core.generated.resources.known_for_department
import kmpmovie.core.generated.resources.light_theme
import kmpmovie.core.generated.resources.movie_cast
import kmpmovie.core.generated.resources.no_movie
import kmpmovie.core.generated.resources.now_playing
import kmpmovie.core.generated.resources.popular
import kmpmovie.core.generated.resources.recommend_movie
import kmpmovie.core.generated.resources.select_movie_type
import kmpmovie.core.generated.resources.setting
import kmpmovie.core.generated.resources.setting_theme
import kmpmovie.core.generated.resources.similar_movie
import kmpmovie.core.generated.resources.upcoming

object Resources {

    object String {
        val now_playing = Res.string.now_playing
        val upcoming = Res.string.upcoming
        val popular = Res.string.popular
        val selectMovieType = Res.string.select_movie_type

        val setting = Res.string.setting
        val setting_theme = Res.string.setting_theme
        val light_theme = Res.string.light_theme
        val dark_theme = Res.string.dark_theme

        val app_version = Res.string.app_version

        val inputMovieTitle = Res.string.input_movie_title
        val noMovie = Res.string.no_movie

        val movieCast = Res.string.movie_cast
        val similarMovie = Res.string.similar_movie
        val recommendMovie = Res.string.recommend_movie

        val birthDay = Res.string.birthday
        val gender = Res.string.gender
        val knownForDepartment = Res.string.known_for_department
        val combinedMovie = Res.string.combined_movie
    }

    object Image {
        val default_person = Res.drawable.image_default_person
        val default_movie = Res.drawable.image_default_movie
    }
}
