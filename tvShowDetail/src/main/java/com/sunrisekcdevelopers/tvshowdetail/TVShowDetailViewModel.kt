package com.sunrisekcdevelopers.tvshowdetail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TVShowDetailViewModel : ViewModel(), TVShowDetailViewModelContract {
    override val state = MutableLiveData<TVShowDetailUiModel>()

    init {
        foo()
    }

    private fun foo() {
        state.value = TVShowDetailUiModel(
            id = 60574,
            coreDetails = TVShowCoreDetails(
                title = "Peaky Blinders",
                posterPath = "https://image.tmdb.org/t/p/w500/i6C8T76p9kbHs62sz6VRVCnTZTS.jpg",
                releaseYear = "2013-09-12",
                status = "Returning Series",
                rating = 8.6f,
                director = "Steven Knight"
            ),
            overview = "A gangster family epic set in 1919 Birmingham, England and centered on a gang who sew razor blades in the peaks of their caps, and their fierce boss Tommy Shelby, who means to move up in the world.",
            languages = listOf("English"),
            tagline = "London's for the taking",
            genres = listOf("Drama", "Crime"),
            backdropPath = "https://image.tmdb.org/t/p/w500/hI5h8o3bbZlZwnySEs6rL7pXH32.jpg",
            banner = BannerUi("some message for banner")
        )
    }
}

data class TVShowDetailUiModel(
    val id: Int,
    val coreDetails: TVShowCoreDetails,
    val banner: BannerUi?,
    val overview: String,
    val genres: List<String>,
    val languages: List<String>,
    val tagline: String,
    val backdropPath: String
)

data class TVShowCoreDetails(
    val title: String,
    val posterPath: String,
    val releaseYear: String,
    val director: String,
    val rating: Float,
    val status: String
)

data class BannerUi(val message: String)