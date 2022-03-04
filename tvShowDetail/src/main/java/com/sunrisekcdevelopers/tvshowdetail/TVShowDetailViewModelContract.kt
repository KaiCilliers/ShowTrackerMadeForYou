package com.sunrisekcdevelopers.tvshowdetail

import androidx.lifecycle.LiveData

interface TVShowDetailViewModelContract {
    val state: LiveData<TVShowDetailUiModel>
}