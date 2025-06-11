package com.kmp.movie.presentation.ui.person_detail.state

import com.kmp.movie.presentation.model.CombinedMovieModel
import com.kmp.movie.presentation.model.DetailPersonModel

data class PersonDetailState(
    val personDetailInfo: DetailPersonModel = DetailPersonModel(),
    val combinedMovieModel: CombinedMovieModel = CombinedMovieModel()
)
