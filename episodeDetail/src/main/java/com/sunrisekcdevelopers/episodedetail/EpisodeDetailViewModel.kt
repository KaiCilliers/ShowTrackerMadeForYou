package com.sunrisekcdevelopers.episodedetail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class EpisodeDetailViewModel : ViewModel(), EpisodeDetailViewModelContract {
    override val someData = MutableLiveData<EpisodeDetailUiModel>()

    init {
        foo()
    }

    private fun foo() {
        someData.value = EpisodeDetailUiModel(
            title = "Lateef Crowder",
            backdropUrl = "https://image.tmdb.org/t/p/w500/dX4VVci4gy0H7bX1lq3N6Gsu4av.jpg",
            season = 1,
            episode = 2,
            bannerMsg = "Some message here",
            overview = "Boba Fett faces new challengers on Tatooine."
        )
    }
}