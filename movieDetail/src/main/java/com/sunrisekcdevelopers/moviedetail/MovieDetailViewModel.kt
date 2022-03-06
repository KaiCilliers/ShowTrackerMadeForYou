package com.sunrisekcdevelopers.moviedetail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MovieDetailViewModel : ViewModel(), MovieDetailViewModelContract {
    override val exampleState = MutableLiveData<MovieDetailUiModel>()

    init {
        foo()
    }

    private fun foo() {
        exampleState.value = MovieDetailUiModel(
            id = 531241,
            coreDetails = MovieCoreDetails(
                posterPath = "https://image.tmdb.org/t/p/w500/nogV4th2P5QWYvQIMiWHj4CFLU9.jpg",
                title = "Spider-Man: No Way Home",
                releaseYear = "2021-12-15",
                director = "Andy Serkis",
                runtime = 148,
                rating = 8.3f
            ),
            backdrop = "https://image.tmdb.org/t/p/w500/AvnqpRwlEaYNVL6wzC4RN94EdSd.jpg",
            banner = BannerUiModel("Cool message"),
            tagline = "The Multiverse unleashed.",
            overview = "Peter Parker is unmasked and no longer able to separate his normal life from the high-stakes of being a super-hero. When he asks for help from Doctor Strange the stakes become even more dangerous, forcing him to discover what it truly means to be Spider-Man.",
            genres = listOf("Action", "Adventure", "Science Fiction"),
            languages = listOf("English", "Tagalog"),
        )
    }
}