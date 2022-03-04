package com.sunrisekcdevelopers.navigation

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

object GlobalDestinations {
    private const val ROOT_PACKAGE = "com.sunrisekcdevelopers"
    object Activities {
        const val SecondaryActivity = "$ROOT_PACKAGE.showtracker.activities.SecondaryActivity"
    }
    object Fragments {
        const val MovieDetail = "$ROOT_PACKAGE.moviedetail.MovieDetailFragment"
        const val EpisodeDetail = "$ROOT_PACKAGE.episodedetail.EpisodeDetailFragment"
    }
    object KEYS {
        const val SECONDARY_INITIAL_DESTINATION = "secondary_destiantion"
    }
}

sealed interface SecondaryDestinations : Parcelable {
    @Parcelize object MovieDetail : SecondaryDestinations, Parcelable
    @Parcelize object EpisodeDetail : SecondaryDestinations, Parcelable
}