package com.sunrisekcdevelopers.episodedetail

import androidx.lifecycle.LiveData

interface EpisodeDetailViewModelContract {
    val someData: LiveData<EpisodeDetailUiModel>
}