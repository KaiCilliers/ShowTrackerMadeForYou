package com.sunrisekcdevelopers.navigation

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

/**
 * Single location to store fully qualified names for views
 * Used when navigating using reflection
 */
object GlobalDestinations {
    private const val ROOT_PACKAGE = "com.sunrisekcdevelopers"
    object Activities {
        const val SecondaryActivity = "$ROOT_PACKAGE.showtracker.SecondaryActivity"
    }
    object Fragments {
        const val MovieDetail = "$ROOT_PACKAGE.moviedetail.MovieDetailFragment"
        const val EpisodeDetail = "$ROOT_PACKAGE.episodedetail.EpisodeDetailFragment"
        const val TVShowDetail = "$ROOT_PACKAGE.tvshowdetail.TVShowDetailFragment"
    }
    object KEYS {
        const val SECONDARY_INITIAL_DESTINATION = "secondary_destiantion"
    }
}

sealed interface SecondaryDestinations : Parcelable {
    @Parcelize object MovieDetail : SecondaryDestinations, Parcelable
    @Parcelize object EpisodeDetail : SecondaryDestinations, Parcelable
    @Parcelize object TVShowDetail : SecondaryDestinations, Parcelable
}