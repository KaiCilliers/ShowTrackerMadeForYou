package com.sunrisekcdevelopers.moviedetail

import androidx.lifecycle.LiveData

interface MovieDetailViewModelContract {
    val exampleState: LiveData<MovieDetailUiModel>
}